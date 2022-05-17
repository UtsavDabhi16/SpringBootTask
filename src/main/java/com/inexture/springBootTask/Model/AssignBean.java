//package com.inexture.springBootTask.Model;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import org.springframework.beans.factory.annotation.Value;
//
//@Entity
//@Table(name = "AssignRole")
//public class AssignBean implements Serializable{
//	
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int AssignId;
//	
//	public int getAssignId() {
//		return AssignId;
//	}
//
//	public void setAssignId(int assignId) {
//		AssignId = assignId;
//	}
//
//	@Value("1")
//	private int id;
//
//	@ManyToOne
//	private UserBean user;
//	
//	
//	
//	public UserBean getUser() {
//		return user;
//	}
//
//	public void setUser(UserBean user) {
//		this.user = user;
//	}
//
//	public AssignBean() {
//		super();
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//	
//	public AssignBean(int id, UserBean user) {
//		super();
//		this.id = id;
//		this.user = user;
//	}
//
//	
//
//}
