package com.pro_rate.HelthCare;

@Path("users")
public class UserResource {
	
	UserDataModel usrRepo = new UserDataModel();
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	
	public List<User> GetUser()
	{
		System.out.println("user Get API Called");
		return usrRepo.getUser();
	}
	
	@GET
	@Path("users/{userId}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	
	public User GetUser(@PathParam("userId") String userId)
	{
		System.out.println("users 1 Get API Called");
		return usrRepo.getUser(userId);
		
		
	}
	
	@POST
	@Path("register")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public User CreateUser(User usr1) {
		
		System.out.println("User create API Called");
		System.out.println(usr1);
		usrRepo.createUser(usr1);
		
		return usr1;
	}
	
	@PUT
	@Path("update")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public User Upadte(User usr1)
	{
		System.out.println("User Update API Called");
		usrRepo.updateUser(usr1);
		
		
		return usr1;
	}
	
	@DELETE
	@Path("Users/{userId}")
	public User deleteUser(@PathParam("userId") String userId)
	{
		System.out.println("User Delete API Called");
		Doctor del_usr = usrRepo.getUser(userId);
		if (del_usr.getUserId() != "0") {
			usrRepo.deleteUser(userId);
		}
		return del_usr;
				
				
	}
}

