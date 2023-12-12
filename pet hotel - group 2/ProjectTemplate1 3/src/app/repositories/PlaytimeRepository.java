package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Playtime;

@Repository
public interface PlaytimeRepository extends JpaRepository<Playtime, Long>{

}
