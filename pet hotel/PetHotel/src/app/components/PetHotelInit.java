package app.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Activity;
import app.entities.Room;
import app.repositories.ActivityRepository;
import app.repositories.CheckinRepository;
import app.repositories.OwnerRepository;
import app.repositories.PetRepository;
import app.repositories.PlaytimeRepository;
import app.repositories.RoomRepository;
import app.repositories.ToyRepository;

@Component
public class PetHotelInit {
	
	@Autowired
	ActivityRepository activityRepo;
	@Autowired
	CheckinRepository checkinRepo;
	@Autowired
	OwnerRepository ownerRepo;
	@Autowired
	PetRepository petRepo;
	@Autowired
	PlaytimeRepository playtimeRepo;
	@Autowired
	RoomRepository roomRepo;
	@Autowired
	ToyRepository toyRepo;
	
	@PostConstruct
	public void populate()
	{
		if(activityRepo.count() == 0 && checkinRepo.count() == 0 && ownerRepo.count() == 0 && petRepo.count() == 0 && playtimeRepo.count() == 0 && roomRepo.count() ==0 && toyRepo.count() ==0)
		{
			//Rooms
			roomRepo.save(new Room("Bubble Room", 1));
			roomRepo.save(new Room("Garden Room", 2));
			roomRepo.save(new Room("Ocean Room", 2));
			roomRepo.save(new Room("Mountain Room", 3));
			
			//Activities
			activityRepo.save(new Activity("Garden Room", "Stroll", "light", "Peaceful stroll through the garden."));
		}
	}
	

}
