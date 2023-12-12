package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.CheckIn;

@Repository
public interface CheckinRepository extends JpaRepository<CheckIn, Long>
{
	public CheckIn findByAnimalID(Long animalID);
}
