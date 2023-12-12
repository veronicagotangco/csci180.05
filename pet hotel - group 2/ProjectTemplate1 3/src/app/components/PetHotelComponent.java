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
import app.rest.controllers.PetActivityDTO;

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
	public Long addRoom(String roomName, Integer floorNum, Boolean occupied) 
	{
		Room r = new Room();
		r.setRoomName(roomName);
		r.setFloorNum(floorNum);
		r.setOccupied(occupied);
		
		r = roomRepo.save(r);
		return r.getRoomId();
	}
	
	// adding activities
	public Long addActivity(Long roomID, String activityName, String activityType, String activityDesc)
	{
		Room r = roomRepo.findByRoomID(roomID);
		
		Activity a = new Activity();
		a.setRoomID(r.getRoomId());
		a.setActivityName(activityName);
		a.setActivityType(activityType);
		a.setActivityDesc(activityDesc);
		
		a = activityRepo.save(a);
		return a.getActivityID();
	}
	
	// adding toys
	public Long addToy(Long activityID, String toyName, String toyType, String toyDesc)
	{
		Activity a = activityRepo.findByActivityID(activityID);
		
		Toy t = new Toy();
		t.setActivityID(a.getActivityID());
		t.setToyName(toyName);
		t.setToyType(toyType);
		t.setToyDesc(toyDesc);
		
		t = toyRepo.save(t);
		return t.getToyID();
	}
	
	// adding check-ins using CheckInDTO 
	public String addCheckIn(CheckInDTO c)
	{
		// pet
		Pet p = new Pet();
		p.setPetName(c.getPetName());
		p.setType(c.getType());
		p.setNeutered(c.getNeutered());
		p.setVaccinated(c.getVaccinated());
		p.setMedication(c.getMedication());
		p.setColor(c.getColor());
		p.setSize(c.getSize());
		p.setGender(c.getGender());
		p.setAdditionalRemarks(c.getAdditional());
		
		p = petRepo.save(p);
		
		// owner
		Owner o = new Owner();
		o.setOwnerName(c.getOwnerName());
		o.setOwnerContact(c.getOwnerContact());
		o.setNumPets(c.getNumPets());
		
		o = ownerRepo.save(o);
		
		// check-in
		CheckIn ch = new CheckIn();
		ch.setAnimalID(p.getId());
		ch.setOwnerID(o.getOwnerID());
		ch.setLengthOfStay(c.getLengthOfStay());
		
		Room r = roomRepo.findByRoomName(c.getRoomName());
		
		if (r==null) // make a room if room doesn't exist 
		{
			Room ro = new Room();
			ro.setRoomName(c.getRoomName());
			ro.setFloorNum(c.getFloorNum());
			ro.setOccupied(c.getOccupied());
			
			// save the info
			ro = roomRepo.save(ro);
			ch.setRoomName(c.getRoomName());
			ch.setFloorNum(c.getFloorNum());
			ch.setOccupied(c.getOccupied());
			return "checkin made";
		}
		else { // if room exists
			ch.setRoomName(r.getRoomName());
			ch.setFloorNum(r.getFloorNum());
			ch.setOccupied(r.getOccupied());
			
			ch = checkinRepo.save(ch);
			return "checkin made";
			
		}
		
	}
	
	// adding play times using PetActivityDTO 
	public String addPlaytime(PetActivityDTO pa)
	{
		// activity
		Activity a = new Activity();
		a.setActivityName(pa.getActivityName());
		a.setActivityType(pa.getActivityType());
		a.setActivityDesc(pa.getActivityDesc());
	
		// toy
		Toy t = new Toy();
		t.setToyName(pa.getToyName());
		t.setToyType(pa.getToyType());
		
		// pet
		Pet p = petRepo.findByPetName(pa.getPetName());
		
		if (p==null) {
			return "Please check-in your pet first.";
		} else {
			Playtime pl = new Playtime();
			
			// pet 
			pa.setPetName(p.getPetName());
			pa.setSize(p.getSize());
			pa.setType(p.getSize());
			pa.setNeutered(p.getNeutered());
			pa.setVaccinated(p.getVaccinated());
			
			// play time
			pl.setId(p.getId());
			pl.setActivityID(a.getActivityID());
			pl.setToyID(t.getToyID());
			pl.setDuration(pa.getDuration());
			
			return "Playtime saved.";
		}
		
	}
}
