package app.rest.controllers;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;


import app.components.PetHotelComponent;

@Path("/pethotel")
public class PetHotelController 
{
	@Autowired
	PetHotelComponent pethotel;
	
	@POST
	@Path("/addroom")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String addRoom(@FormParam("name") String roomName,
						@FormParam("floornum") Integer floorNum,
						@FormParam("occupied") Boolean occupied)
	{
		Long id = pethotel.addRoom(roomName, floorNum, occupied);
		return "Added to Room DB: " + id;
		
	}
	
	@POST
	@Path("/addactivity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String addActivity(@FormParam("name") String activityName,
							@FormParam("type") String activityType,
							@FormParam("desc") String activityDesc)
	{
		Long id = pethotel.addActivity(null, activityName, activityType, activityDesc);
		return "Added to Activity DB: " + id;
		
	}
	
	@POST
	@Path("/addtoy")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String addToy(@FormParam("name") String toyName,
						@FormParam("type") String toyType,
						@FormParam("desc") String toyDesc)
	{
		Long id = pethotel.addToy(null, toyName, toyType, toyDesc);
		return "Added to Toy DB: " + id;
	}
	
	@POST
	@Path("/addcheckin")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addCheckIn(CheckInDTO c)
	{
		return pethotel.addCheckIn(c);
	}
	
	@POST
	@Path("/addplaytime")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addPlaytime(PetActivityDTO pa)
	{
		return pethotel.addPlaytime(pa);
	}

}
