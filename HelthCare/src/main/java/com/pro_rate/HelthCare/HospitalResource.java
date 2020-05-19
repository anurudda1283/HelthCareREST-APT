package com.pro_rate.HelthCare;



import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("hospitals")
public class HospitalResource {
	
	HospitalDataModel hosRepo = new HospitalDataModel();
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	
	public List<Hospital> GetHospital()
	{
		System.out.println("Hospital Get API Called");
		return hosRepo.getHospital();
	}
	
	@GET
	@Path("hospitals/{registerId}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	
	public Hospital GetHospital(@PathParam("registerId") String registerId)
	{
		System.out.println("Hospitals 1 Get API Called");
		return hosRepo.getHospital(registerId);
		
		
	}
	
	@POST
	@Path("register")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Hospital CreateHospital(Hospital hos1) {
		
		System.out.println("Hospital create API Called");
		System.out.println(hos1);
		hosRepo.createHospital(hos1);
		
		return hos1;
	}
	
	@PUT
	@Path("update")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Hospital Upadte(Hospital hos1)
	{
		System.out.println("Hospital Update API Called");
		hosRepo.updateHospital(hos1);
		
		
		return hos1;
	}
	
	@DELETE
	@Path("hospitals/{reisterId}")
	public Hospital deleteHospital(@PathParam("registerId") String registerId)
	{
		System.out.println("Hospital Delete API Called");
		Hospital del_hos = hosRepo.getHospital(registerId);
		if (del_hos.getRegisterId() != "0") {
			hosRepo.deleteHospital(registerId);
		}
		return del_hos;
	}
}
