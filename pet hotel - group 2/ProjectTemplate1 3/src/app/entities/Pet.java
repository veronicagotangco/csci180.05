package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Pet 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // auto-increment
	@Column
	private Long id;
	
	// not null
	@NotNull
	@Column
	private String petName;
	
	// not null, cat or dog only
	@NotNull
	@Pattern(regexp="(?i)(\\W|^)(cat|dog)(\\W|$)")
	@Column
	private String type;
	
	@Column
	private Boolean neutered;
	
	@Column
	private Boolean vaccinated;
	
	@Column
	private String medication;
	
	// not null, male or female only
	@NotNull
	@Pattern(regexp="(?i)(\\W|^)(male|female)(\\W|$)")
	@Column
	private String gender;
	
	// not null, small/medium/large only
	@NotNull
	@Pattern(regexp="(?i)(\\W|^)(small|medium|large)(\\W|$)")
	@Column
	private String size;
	
	@Column
	private String color;
	
	@Column
	private String additionalRemarks;

	// getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAdditionalRemarks() {
		return additionalRemarks;
	}

	public void setAdditionalRemarks(String additionalRemarks) {
		this.additionalRemarks = additionalRemarks;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", petName=" + petName + ", type=" + type + ", neutered=" + neutered + ", vaccinated="
				+ vaccinated + ", medication=" + medication + ", gender=" + gender + ", size=" + size + ", color="
				+ color + ", additionalRemarks=" + additionalRemarks + "]";
	}	
}
