package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> 
{
	public Activity findByActivityName(String activityName);
}
