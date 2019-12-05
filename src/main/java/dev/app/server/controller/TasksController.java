package dev.app.server.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.app.server.entities.Tasks;
import dev.app.server.entities.TasksType;
import dev.app.server.services.TasksServices;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value="/Tasks")
public class TasksController {
	
	@Autowired
	TasksServices tasksServices;
	
	
	@PostMapping
	public void addTask(@Valid @RequestBody Tasks tasks ) {
		tasks.setType(TasksType.PENDING);
		Tasks newtasks = tasksServices.saveOrupdateTasks(tasks);
		System.out.println("Successfully added");
	}
	
	/*@PutMapping("/{id}")
	public void UpdateTask(@Valid @RequestBody Tasks tasks ) {
		tasksServices.saveOrupdateTasks(tasks);
		System.out.println("Successfully Updating");
	}*/
	

	@GetMapping
	public Iterable<Tasks> getTasks(){
		return tasksServices.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Tasks> getByID(@PathVariable int id) throws Exception{
		if(id<0){
			throw new Exception("Invalid ID");
		}
		try{Tasks tasks=tasksServices.getbyID(id);
		return new ResponseEntity<Tasks>(tasks, HttpStatus.OK);}
		catch(Exception e){
			throw new Exception("Can't find any task with ID " +id);
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable int id) {
		tasksServices.delete(id);
	}
	
	@PostMapping("/InProgress/{id}")
	public void InProgress(@PathVariable int id) throws Exception{
		if(id<0){
			throw new Exception("Invalid ID");
		}
		try{
			Tasks tasks=tasksServices.getbyID(id);
			tasks.setType(TasksType.IN_PROGRESS);
	
			tasksServices.saveOrupdateTasks(tasks);
		}
		catch(Exception e){
			throw new Exception("Can't find any task with ID " +id);
		}
	}
	@PostMapping("/Done/{id}")
	public void Done(@PathVariable int id) throws Exception{
		if(id<0){
			throw new Exception("Invalid ID");
		}
		try{
			Tasks tasks=tasksServices.getbyID(id);
			tasks.setType(TasksType.DONE);
	
			tasksServices.saveOrupdateTasks(tasks);
		}
		catch(Exception e){
			throw new Exception("Can't find any task with ID " +id);
		}
	}	
	@PostMapping("/Pending/{id}")
	public void Pending(@PathVariable int id) throws Exception{
		if(id<0){
			throw new Exception("Invalid ID");
		}
		try{
			Tasks tasks=tasksServices.getbyID(id);
			tasks.setType(TasksType.PENDING);
	
			tasksServices.saveOrupdateTasks(tasks);
		}
		catch(Exception e){
			throw new Exception("Can't find any task with ID " +id);
		}
	}	
	
}
