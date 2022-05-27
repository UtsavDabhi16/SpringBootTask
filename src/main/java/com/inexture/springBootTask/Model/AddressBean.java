package com.inexture.springBootTask.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "address")
@Component
public class AddressBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
<<<<<<< HEAD
	int AddressId;
=======
	private int AddressId;
>>>>>>> 206210ae71d3f20f7aff78ad0efd3f494ece7011
	private String AddressLineOne;
	private String AddressLineTwo;
	private String pincode;
	private String city;
	private String state;

	@ManyToOne
<<<<<<< HEAD
	UserBean user;
=======
	private UserBean user;
>>>>>>> 206210ae71d3f20f7aff78ad0efd3f494ece7011

	public AddressBean() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
//	public AddressBean(int addressId, String addressLineOne, String addressLineTwo, String pincode, String city,
//			String state) {
//		super();
//		AddressId = addressId;
//		AddressLineOne = addressLineOne;
//		AddressLineTwo = addressLineTwo;
//		this.pincode = pincode;
//		this.city = city;
//		this.state = state;
//	}
//
//	public AddressBean(String addressLineOne, String addressLineTwo, String pincode, String city, String state) {
//		super();
//		AddressLineOne = addressLineOne;
//		AddressLineTwo = addressLineTwo;
//		this.pincode = pincode;
//		this.city = city;
//		this.state = state;
//	}

//	public int getAddressId() {
//		return AddressId;
//	}
=======
	public AddressBean(int addressId, String addressLineOne, String addressLineTwo, String pincode, String city,
			String state) {
		super();
		AddressId = addressId;
		AddressLineOne = addressLineOne;
		AddressLineTwo = addressLineTwo;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
	}

	public AddressBean(String addressLineOne, String addressLineTwo, String pincode, String city, String state) {
		super();
		AddressLineOne = addressLineOne;
		AddressLineTwo = addressLineTwo;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
	}
	
	public int getAddressId() {
		return AddressId;
	}
>>>>>>> 206210ae71d3f20f7aff78ad0efd3f494ece7011

	public void setAddressId(int addressId) {
		AddressId = addressId;
	}

	public String getAddressLineOne() {
		return AddressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		AddressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return AddressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		AddressLineTwo = addressLineTwo;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

<<<<<<< HEAD
//	public UserBean getUser() {
//		return user;
//	}
=======
	public UserBean getUser() {
		return user;
	}
>>>>>>> 206210ae71d3f20f7aff78ad0efd3f494ece7011

	public void setUser(UserBean User)  {
		this.user = User;
	}
	  

}
