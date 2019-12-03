package dev.app.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.app.server.entities.Tasks;
import dev.app.server.repository.TasksRepository;



@Service
public class TasksServices {

	@Autowired
	TasksRepository tasksRepository;
	
	public Tasks saveOrupdateTasks(Tasks tasks) {
		return tasksRepository.save(tasks);
		
	}
	
	
	
	public Tasks getbyID(int id) throws Exception {
		try {
			Tasks tasks=tasksRepository.getByIdTask(id);
			return tasks; 
		}
		catch (Exception e) {
			throw new Exception("No task with id :"+id+" was found");

		}
		
	}
	
	public void delete(int id) {
		tasksRepository.deleteById(id);
	}
	
	
	public Iterable<Tasks> findAll(){
		return tasksRepository.findAll();
	}
	
}
