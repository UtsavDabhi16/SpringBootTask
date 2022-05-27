package com.inexture.springBootTask.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "AssignRole")
@Component
public class AssignBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
<<<<<<< HEAD
	int AssignId;
	
//	public int getAssignId() {
//		return AssignId;
//	}
=======
	private int AssignId;
	
	public int getAssignId() {
		return AssignId;
	}
>>>>>>> 206210ae71d3f20f7aff78ad0efd3f494ece7011

	public void setAssignId(int assignId) {
		AssignId = assignId;
	}

	@Value("1")
	private int id;

	@ManyToOne
<<<<<<< HEAD
	UserBean user;
	
	
	
//	public UserBean getUser() {
//		return user;
//	}
=======
	private UserBean user;
	
	
	
	public UserBean getUser() {
		return user;
	}
>>>>>>> 206210ae71d3f20f7aff78ad0efd3f494ece7011

	public void setUser(UserBean user) {
		this.user = user;
	}

	public AssignBean() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
<<<<<<< HEAD
//	public AssignBean(int id, UserBean user) {
//		super();
//		this.id = id;
//		this.user = user;
//	}
=======
	public AssignBean(int id, UserBean user) {
		super();
		this.id = id;
		this.user = user;
	}
>>>>>>> 206210ae71d3f20f7aff78ad0efd3f494ece7011

	

}
