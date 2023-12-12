package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Playtime 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long playtimeID;
	
	@NotNull
	@Column
	private Long id;
	
	@NotNull
	@Column
	private Long activityID;
	
	@NotNull
	@Column
	private Long toyID;
	
	@NotNull
	@Range(min=1, max=7)
	@Column
	private Integer duration;

	public Long getPlaytimeID() {
		return playtimeID;
	}

	public void setPlaytimeID(Long playtimeID) {
		this.playtimeID = playtimeID;
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

	@Override
	public String toString() {
		return "Playtime [playtimeID=" + playtimeID + ", id=" + id + ", activityID=" + activityID + ", toyID=" + toyID
				+ ", duration=" + duration + "]";
	}
	
	

}
