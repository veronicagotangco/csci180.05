package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Owner 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long ownerID;
	
	// not null
	@NotNull
	@Column
	private String ownerName;
	
	// not null
	@NotNull
	@Column
	private String ownerContact;
	
	// minimum of 1
	@NotNull
	@Range(min=1)
	private Integer numPets;

	// getters and setters
	public Long getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Long ownerID) {
		this.ownerID = ownerID;
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

	// toString()
	@Override
	public String toString() {
		return "Owner [ownerID=" + ownerID + ", ownerName=" + ownerName + ", ownerContact=" + ownerContact
				+ ", numPets=" + numPets + "]";
	}

}
