package app.rest.controllers;

public class PetActivityDTO 
{
	// activity
	private String activityName;
	private String activityType;
	private String activityDesc;
	
	// pet 
	private String petName;
	private String type;
	private String size;
	private Boolean neutered;
	private Boolean vaccinated;
	
	// play time
	private Long id;
	private Long activityID;
	private Long toyID;
	private Integer duration;
	
	// toy
	private String toyName;
	private String toyType;
	
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getActivityDesc() {
		return activityDesc;
	}
	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc;
	}
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getActivityID() {
		return activityID;
	}
	public void setActivityID(Long activityID) {
		this.activityID = activityID;
	}
	public Long getToyID() {
		return toyID;
	}
	public void setToyID(Long toyID) {
		this.toyID = toyID;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getToyName() {
		return toyName;
	}
	public void setToyName(String toyName) {
		this.toyName = toyName;
	}
	public String getToyType() {
		return toyType;
	}
	public void setToyType(String toyType) {
		this.toyType = toyType;
	}
	
	
	@Override
	public String toString() {
		return "PetActivityDTO [activityName=" + activityName + ", activityType=" + activityType + ", activityDesc="
				+ activityDesc + ", petName=" + petName + ", type=" + type + ", size=" + size + ", neutered=" + neutered
				+ ", vaccinated=" + vaccinated + ", id=" + id + ", activityID=" + activityID + ", toyID=" + toyID
				+ ", duration=" + duration + ", toyName=" + toyName + ", toyType=" + toyType + "]";
	}
	
	
	
	
}
