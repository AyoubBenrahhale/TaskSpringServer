package dev.app.server.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.app.server.entities.Tasks;


@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer>{
 
	Tasks getByIdTask(int id);
	
	
}
