package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
