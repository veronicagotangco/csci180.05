package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Room 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long roomId;
	
	@NotNull
	@Column
	private String roomName;
	
	@NotNull
	@Range(min=1, max=10)
	@Column
	private Integer floorNum;

	public Room() {}
	
	public Room(@NotNull String roomName, @NotNull @Range(min = 1, max = 10) Integer floorNum) {
		super();
		this.roomName = roomName;
		this.floorNum = floorNum;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getFloorNum() {
		return floorNum;
	}

	public void setFloorNum(Integer floorNum) {
		this.floorNum = floorNum;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomName=" + roomName + ", floorNum=" + floorNum + "]";
	}
}
