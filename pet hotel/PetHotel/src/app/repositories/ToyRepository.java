package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Toy;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Long>
{
}
