package app.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> 
{
	public Room findByRoomName(String roomName);
	public Room findByRoomId(Long roomId);
	
}
