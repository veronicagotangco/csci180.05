package app.rest.controllers;

public class CheckInDTO 
{
	// pet
	private String petName;
	private String type;
	private Boolean neutered;
	private Boolean vaccinated;
	private String medication;
	private String gender;
	private String size;
	private String color;
	private String additional;
	
	// owner
	private String ownerName;
	private String ownerContact;
	private Integer numPets;
	
	// check-in
	private Long id;
	private Long ownerID;
	private Long roomID;
	private String roomName;
	private Integer floorNum;
	private Integer lengthOfStay;
	
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getNeutered() {
		return neutered;
	}
	public void setNeutered(Boolean neutered) {
		this.neutered = neutered;
	}
	public Boolean getVaccinated() {
		return vaccinated;
	}
	public void setVaccinated(Boolean vaccinated) {
		this.vaccinated = vaccinated;
	}
	public String getMedication() {
		return medication;
	}
	public void setMedication(String medication) {
		this.medication = medication;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAdditional() {
		return additional;
	}
	public void setAdditional(String additional) {
		this.additional = additional;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerContact() {
		return ownerContact;
	}
	public void setOwnerContact(String ownerContact) {
		this.ownerContact = ownerContact;
	}
	public Integer getNumPets() {
		return numPets;
	}
	public void setNumPets(Integer numPets) {
		this.numPets = numPets;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(Long ownerID) {
		this.ownerID = ownerID;
	}
	public Long getRoomID() {
		return roomID;
	}
	public void setRoomID(Long roomID) {
		this.roomID = roomID;
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
	public Integer getLengthOfStay() {
		return lengthOfStay;
	}
	public void setLengthOfStay(Integer lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}
	
	@Override
	public String toString() {
		return "CheckInDTO [petName=" + petName + ", type=" + type + ", neutered=" + neutered + ", vaccinated="
				+ vaccinated + ", medication=" + medication + ", gender=" + gender + ", size=" + size + ", color="
				+ color + ", additional=" + additional + ", ownerName=" + ownerName + ", ownerContact=" + ownerContact
				+ ", numPets=" + numPets + ", id=" + id + ", ownerID=" + ownerID + ", roomID=" + roomID + ", roomName="
				+ roomName + ", floorNum=" + floorNum + ", lengthOfStay=" + lengthOfStay + "]";
	}
}
