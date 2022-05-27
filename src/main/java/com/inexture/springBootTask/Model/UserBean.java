package com.inexture.springBootTask.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "users")
@Component
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Expose
	private int Userid;
	@NotEmpty(message = "Hello Firstname")
	@Expose
	private String FirstName;
	@NotEmpty(message = "Lastname")
	@Expose
	private String LastName;
	@NotEmpty(message = "Email")
	@Expose
	private String Email;
	@NotEmpty(message = "phone")
	@Expose
	private String PhoneNo;
	@NotEmpty(message = "date of birth")
	@Expose
	private String Dob;
	@NotEmpty(message = "this is gender")
	@Expose
	private String gender;
	@NotEmpty(message = "security question")
	@Expose
	private String SecurityAnswer;
	@NotEmpty(message = "password")
	@Expose
	private String Password;
	@NotEmpty(message = "confirm password")
	@Expose
	private String CPassword;
	@NotEmpty(message = "New password")
	@Expose
	private String NewPassword;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<AddressBean> address;

	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<AssignBean> assign;

	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public String toString() {
		return "UserBean [Userid=" + Userid + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email
				+ ", PhoneNo=" + PhoneNo + ", Dob=" + Dob + ", gender=" + gender + ", SecurityAnswer=" + SecurityAnswer
				+ ", Password=" + Password + ", CPassword=" + CPassword + ", NewPassword=" + NewPassword + ", address="
				+ address + "]";
	}

	public int getUserid() {
		return Userid;
	}

	public void setUserid(int userid) {
		Userid = userid;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSecurityAnswer() {
		return SecurityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		SecurityAnswer = securityAnswer;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getCPassword() {
		return CPassword;
	}

	public void setCPassword(String cPassword) {
		CPassword = cPassword;
	}

//	public String getNewPassword() {
//		return NewPassword;
//	}

	public void setNewPassword(String newPassword) {
		NewPassword = newPassword;
	}

	public List<AddressBean> getAddress() {
		return address;
	}

	public void setAddress(List<AddressBean> address) {
		this.address = address;
	}

	public List<AssignBean> getAssign() {
		return assign;
	}

	public void setAssign(List<AssignBean> assign) {
		this.assign = assign;
	}

}
