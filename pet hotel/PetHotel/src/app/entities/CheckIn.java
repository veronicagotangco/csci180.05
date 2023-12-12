package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class CheckIn 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long checkinID;
	
	@NotNull
	@Column
	private Long roomID;
	
	@NotNull
	@Column
	private Long animalID;
	
	@NotNull
	@Column
	private Long ownerID;
	
	@NotNull
	@Column
	@Range(min=1, max=30)
	private Integer lengthOfStay;

	@NotNull
	@Column
	private String roomName;
	
	@NotNull
	@Range(min=1, max=30)
	@Column
	private Integer floorNum;
	
	@NotNull
	@Column
	private Boolean occupied;

	public CheckIn() {}
	
	public CheckIn(@NotNull Long roomID, @NotNull Long animalID, @NotNull Long ownerID,
			@NotNull @Range(min = 1, max = 30) Integer lengthOfStay, @NotNull String roomName,
			@NotNull @Range(min = 1, max = 30) Integer floorNum, @NotNull Boolean occupied) {
		super();
		this.roomID = roomID;
		this.animalID = animalID;
		this.ownerID = ownerID;
		this.lengthOfStay = lengthOfStay;
		this.roomName = roomName;
		this.floorNum = floorNum;
		this.occupied = occupied;
	}

	public Long getCheckinID() {
		return checkinID;
	}

	public void setCheckinID(Long checkinID) {
		this.checkinID = checkinID;
	}

	public Long getRoomID() {
		return roomID;
	}

	public void setRoomID(Long roomID) {
		this.roomID = roomID;
	}

	public Long getAnimalID() {
		return animalID;
	}

	public void setAnimalID(Long animalID) {
		this.animalID = animalID;
	}

	public Long getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Long ownerID) {
		this.ownerID = ownerID;
	}

	public Integer getLengthOfStay() {
		return lengthOfStay;
	}

	public void setLengthOfStay(Integer lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
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

	public Boolean getOccupied() {
		return occupied;
	}

	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}
	
	@Override
	public String toString() {
		return "CheckIn [checkinID=" + checkinID + ", roomID=" + roomID + ", animalID=" + animalID + ", ownerID="
				+ ownerID + ", lengthOfStay=" + lengthOfStay + ", roomName=" + roomName + ", floorNum=" + floorNum
				+ ", occupied=" + occupied + "]";
	}
}
