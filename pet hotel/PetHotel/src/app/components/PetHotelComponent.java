package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Activity;
import app.entities.CheckIn;
import app.entities.Owner;
import app.entities.Pet;
import app.entities.Playtime;
import app.entities.Room;
import app.entities.Toy;
import app.repositories.ActivityRepository;
import app.repositories.CheckinRepository;
import app.repositories.OwnerRepository;
import app.repositories.PetRepository;
import app.repositories.PlaytimeRepository;
import app.repositories.RoomRepository;
import app.repositories.ToyRepository;
import app.rest.controllers.CheckInDTO;
import app.rest.controllers.PetPlaytimeDTO;

@Component
public class PetHotelComponent 
{
	@Autowired
	private PetRepository petRepo;
	
	@Autowired
	private OwnerRepository ownerRepo;
	
	@Autowired
	private ActivityRepository activityRepo;
	
	@Autowired
	private PlaytimeRepository playtimeRepo;
	
	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired
	private ToyRepository toyRepo;
	
	@Autowired
	private CheckinRepository checkinRepo;
	
	// adding rooms
	public Long addRoom(String roomName, Integer floorNum) 
	{
		Room r = new Room();
		r.setRoomName(roomName);
		r.setFloorNum(floorNum);
		
		r = roomRepo.save(r);
		return r.getRoomId();
	}
	
	// adding activities
	public Long addActivity(String roomName, String activityName, String activityType, String activityDesc)
	{
		Room r = roomRepo.findByRoomName(roomName);
		
		Activity a = new Activity();
		a.setRoomName(r.getRoomName());
		a.setActivityName(activityName);
		a.setActivityType(activityType);
		a.setActivityDesc(activityDesc);
		
		a = activityRepo.save(a);
		return a.getActivityID();
	}
	
	// adding toys
	public Long addToy(String activityName, String toyName, String toyType, String toyDesc)
	{
		Activity a = activityRepo.findByActivityName(activityName);
		
		Toy t = new Toy();
		t.setActivityName(a.getActivityName());
		t.setToyName(toyName);
		t.setToyType(toyType);
		t.setToyDesc(toyDesc);
		
		t = toyRepo.save(t);
		return t.getToyID();
	}
	
	// adding check-ins using CheckInDTO 
	public String addCheckIn(CheckInDTO checkinDTO)
	{	
		// initialize objects
		CheckIn ch = new CheckIn();
		Owner o = new Owner();
		Pet p = new Pet();
		Room r = new Room();

		// checking if already checked-in
		Pet petQuery = petRepo.findByPetName(checkinDTO.getPetName());
		
		// pet
		if(petQuery == null)
		{
			p.setPetName(checkinDTO.getPetName());
			p.setType(checkinDTO.getType());
			p.setNeutered(checkinDTO.getNeutered());
			p.setVaccinated(checkinDTO.getVaccinated());
			p.setMedication(checkinDTO.getMedication());
			p.setColor(checkinDTO.getColor());
			p.setSize(checkinDTO.getSize());
			p.setGender(checkinDTO.getGender());
			p.setAdditionalRemarks(checkinDTO.getAdditional());
			
			ch.setAnimalID(p.getPetID());
			
			p = petRepo.save(p);
		}
		else
		{
			ch.setAnimalID(petQuery.getPetID());
		}
		
		CheckIn checkinQuery = checkinRepo.findByAnimalID(petQuery.getPetID());
		
		if (checkinQuery != null) 
		{
			return "Your pet is already checked-in.";
		} 
		
		// owner
		Owner ownerQuery = ownerRepo.findByOwnerName(checkinDTO.getOwnerName());
		if(ownerQuery == null)
		{
			o.setOwnerName(checkinDTO.getOwnerName());
			o.setOwnerContact(checkinDTO.getOwnerContact());
			o.setNumPets(checkinDTO.getNumPets());
			
			p.setOwnerID(o.getOwnerID());
			
			ch.setOwnerID(o.getOwnerID());
			
			o = ownerRepo.save(o);
		}
		else
		{
			ch.setOwnerID(ownerQuery.getOwnerID());
			p.setOwnerID(ownerQuery.getOwnerID());
		}
		
		// check-in
		ch.setLengthOfStay(checkinDTO.getLengthOfStay());
		
		Room roomQuery = roomRepo.findByRoomName(checkinDTO.getRoomName());
		
		if (roomQuery == null)
		{
			r.setRoomName(checkinDTO.getRoomName());
			r.setFloorNum(checkinDTO.getFloorNum());
			
			r = roomRepo.save(r);
			
			ch.setRoomName(checkinDTO.getRoomName());
			ch.setFloorNum(checkinDTO.getFloorNum());
		}
		else 
		{ 	
			ch.setRoomName(roomQuery.getRoomName());
			ch.setFloorNum(roomQuery.getFloorNum());
		}
		
		ch = checkinRepo.save(ch);
		return "Check-in made";
	}
	
	// adding play times using PetPlaytimeDTO 
	public String addPlaytime(PetPlaytimeDTO playtimeDTO)
	{
		// initialize objects
		Playtime pt = new Playtime();
		Activity a = new Activity();
		
		// activity
		Activity activityQuery = activityRepo.findByActivityName(playtimeDTO.getActivityName());
		if (activityQuery == null)
		{
			a.setActivityName(playtimeDTO.getActivityName());
			a.setActivityType(playtimeDTO.getActivityType());
			a.setActivityDesc(playtimeDTO.getActivityDesc());
			
			pt.setActivityID(a.getActivityID());
			
			a = activityRepo.save(a);
		}
		else
		{
			pt.setActivityID(activityQuery.getActivityID());
		}
		
		// play time
		Pet petQuery = petRepo.findByPetName(playtimeDTO.getPetName());
		CheckIn checkinQuery = checkinRepo.findByAnimalID(petQuery.getPetID());
		
		if (checkinQuery == null) 
		{
			return "Please check-in your pet first.";
		} 
		else 
		{
			pt.setPetID(checkinQuery.getAnimalID());
			pt.setDuration(playtimeDTO.getDuration());
			
			pt = playtimeRepo.save(pt);
			return "Playtime saved.";
		}
	}
}
