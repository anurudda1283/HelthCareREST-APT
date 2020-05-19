package com.pro_rate.HelthCare;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("doctors")
public class DoctorResource {
	
	DoctorDataModel docRepo = new DoctorDataModel();
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	
	public List<Doctor> GetDoctor()
	{
		System.out.println("doctor Get API Called");
		return docRepo.getDoctor();
	}
	
	@GET
	@Path("doctors/{doctorId}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	
	public Doctor GetDoctor(@PathParam("doctorId") String doctorId)
	{
		System.out.println("doctors 1 Get API Called");
		return docRepo.getDoctor(doctorId);
		
		
	}
	
	@POST
	@Path("register")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Doctor CreateDoctor(Doctor doc1) {
		
		System.out.println("Doctor create API Called");
		System.out.println(doc1);
		docRepo.createDoctor(doc1);
		
		return doc1;
	}
	
	@PUT
	@Path("update")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Doctor Upadte(Doctor doc1)
	{
		System.out.println("Doctor Update API Called");
		docRepo.updateDoctor(doc1);
		
		
		return doc1;
	}
	
	@DELETE
	@Path("doctors/{doctorId}")
	public Doctor deleteDoctor(@PathParam("doctorId") String doctorId)
	{
		System.out.println("Doctor Delete API Called");
		Doctor del_doc = docRepo.getDoctor(doctorId);
		if (del_doc.getDoctorId() != "0") {
			docRepo.deleteDoctor(doctorId);
		}
		return del_doc
				
				;
	}
}

