 package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>
{
	public Pet findByPetName(String petName);
}
