package dev.app.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity

@Table(name = "Tasks2")
public class Tasks {
	@GeneratedValue
	@Id
	@Column(name="idTask")
	private int idTask;
	private String title;
	private String description;
	@Enumerated(EnumType.STRING)
    @Column(length = 60)
    private TasksType type;

	
	public Tasks(String title, String description, TasksType type) {
		super();
		this.title = title;
		this.description = description;
		this.type = type;
	}
	
	public Tasks(int idTask, String title, String description, TasksType type) {
		super();
		this.idTask = idTask;
		this.title = title;
		this.description = description;
		this.type = type;
	}

	public Tasks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tasks(int idTask, String title, String description) {
		super();
		this.idTask = idTask;
		this.title = title;
		this.description = description;
	}
	public Tasks(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public int getIdTask() {
		return idTask;
	}
	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TasksType getType() {
		return type;
	}
	public void setType(TasksType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Tasks [idTask=" + idTask + ", title=" + title + ", description=" + description + ", type=" + type + "]";
	}
	
	
	

}
