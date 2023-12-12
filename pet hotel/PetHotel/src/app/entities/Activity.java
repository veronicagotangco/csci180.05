package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Activity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long activityID;
	
	@Column
	@NotNull
	private String roomName;
	
	@NotNull
	@Column
	private String activityName;
	
	@NotNull
	@Pattern(regexp="(?i)(\\W|^)(light|medium|high)(\\W|$)")
	@Column
	private String activityType;
	
	@Column
	private String activityDesc;

	public Activity() {}

	public Activity(@NotNull String roomName, @NotNull String activityName,
			@NotNull @Pattern(regexp = "(?i)(\\W|^)(light|medium|high)(\\W|$)") String activityType,
			String activityDesc) {
		super();
		this.roomName = roomName;
		this.activityName = activityName;
		this.activityType = activityType;
		this.activityDesc = activityDesc;
	}

	public Long getActivityID() {
		return activityID;
	}

	public void setActivityID(Long activityID) {
		this.activityID = activityID;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

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

	@Override
	public String toString() {
		return "Activity [activityID=" + activityID + ", roomName=" + roomName + ", activityName=" + activityName
				+ ", activityType=" + activityType + ", activityDesc=" + activityDesc + "]";
	}
}
