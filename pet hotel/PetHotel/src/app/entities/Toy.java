package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Toy 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long toyID;
	
	@NotNull
	@Column
	private String activityName;
	
	@NotNull
	@Column
	private String toyName;
	
	@NotNull
	@Pattern(regexp="(?i)(\\W|^)(cat|dog)(\\W|$)")
	@Column
	private String toyType;
	
	@Column
	private String toyDesc;

	public Toy() {}
	
	public Toy(@NotNull String activityName, @NotNull String toyName,
			@NotNull @Pattern(regexp = "(?i)(\\W|^)(cat|dog)(\\W|$)") String toyType, String toyDesc) {
		super();
		this.activityName = activityName;
		this.toyName = toyName;
		this.toyType = toyType;
		this.toyDesc = toyDesc;
	}
	
	public Long getToyID() {
		return toyID;
	}

	public void setToyID(Long toyID) {
		this.toyID = toyID;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
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

	public String getToyDesc() {
		return toyDesc;
	}

	public void setToyDesc(String toyDesc) {
		this.toyDesc = toyDesc;
	}

	@Override
	public String toString() {
		return "Toy [toyID=" + toyID + ", activityName=" + activityName + ", toyName=" + toyName + ", toyType="
				+ toyType + ", toyDesc=" + toyDesc + "]";
	}
}
