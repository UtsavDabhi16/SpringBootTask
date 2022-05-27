package com.inexture.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.inexture.springBootTask.DAO.AddressDaoInterface;
import com.inexture.springBootTask.DAO.AdminDaoInterface;
import com.inexture.springBootTask.DAO.UserDaoInterface;
import com.inexture.springBootTask.Model.AddressBean;
import com.inexture.springBootTask.Model.AssignBean;
import com.inexture.springBootTask.Model.UserBean;
import com.inexture.springBootTask.Service.AdminServiceImpl;
import com.inexture.springBootTask.Service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class UserServiceTest {

	@InjectMocks
	private UserServiceImpl userService;

	@InjectMocks
	private AdminServiceImpl adminService;

	@Mock
	private UserDaoInterface userDao;

	@Mock
	private AdminDaoInterface adminDao;

	@Mock
	private AddressDaoInterface addressDao;

	@BeforeAll
	void init() {
		userService = new UserServiceImpl();
	}

	@Test
	void registerUserTest() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {

		AddressBean ab = new AddressBean();
		ab.setAddressLineOne("First Line");
		ab.setAddressLineTwo("Second Line");
		ab.setPincode("364710");
		ab.setCity("Ahmead");
		ab.setState("Gujarat");

		List<AddressBean> list = new ArrayList<AddressBean>();
		list.add(ab);

		UserBean ub = new UserBean();
		ub.setFirstName("Utsav");
		ub.setLastName("Dabhi");
		ub.setEmail("utsav@gmail.com");
		ub.setPhoneNo("9574359326");
		ub.setDob("16-07-2001");
		ub.setGender("Male");
		ub.setSecurityAnswer("Java");
		ub.setPassword("utsav");
		ub.setCPassword("utsav");
		ub.setAddress(list);

		AssignBean assignb = new AssignBean();
		assignb.setAssignId(1);
		List<AssignBean> assignBean = new ArrayList<AssignBean>();
		assignBean.add(assignb);
		ub.setAssign(assignBean);

		UserBean expected = new UserBean();
		expected.setUserid(1);
		expected.setFirstName("Utsav");
		expected.setLastName("Dabhi");
		expected.setEmail("utsav@gmail.com");
		expected.setPhoneNo("9574359326");
		expected.setDob("16-07-2001");
		expected.setGender("Male");
		expected.setSecurityAnswer("Java");
		expected.setPassword("utsav");
		expected.setCPassword("utsav");
		expected.setAddress(list);
		expected.setAssign(assignBean);

		when(userDao.save(ub)).thenReturn(expected);

		boolean actual = userService.registerUser(ub);
		assertTrue(actual);

		verify(userDao, atLeast(1)).save(ub);

	}

//	@Test
	void registerUserExceptionTest() throws Exception {
//		UserBean user = new UserBean();
//		when(userDao.save(user)).thenReturn(user);
//		assertThrows(RuntimeException.class, ()-> userService.registerUser(user));
//		verify(userDao, atLeast(1)).save(user);
	}

	@Test
	void getUserByEmailTest() {
		UserBean ubean = new UserBean();
		ubean.setUserid(1);
		ubean.setEmail("utsav@gmail.com");
		when(userDao.getUserEmail(ubean.getEmail())).thenReturn(ubean);
		UserBean ub = userService.getUserByEmail(ubean.getEmail());
		assertNotNull(ub);
		verify(userDao, atLeast(1)).getUserEmail("utsav@gmail.com");

	}

	@Test
	void updateUserTest() {
		AddressBean ab = new AddressBean();
		ab.setAddressLineOne("First Line");
		ab.setAddressLineTwo("Second Line");
		ab.setPincode("364710");
		ab.setCity("Ahmead");
		ab.setState("Gujarat");

		List<AddressBean> list = new ArrayList<AddressBean>();
		list.add(ab);

		UserBean ub = new UserBean();
		ub.setFirstName("Utsav");
		ub.setLastName("Dabhi");
		ub.setEmail("utsav@gmail.com");
		ub.setPhoneNo("9574359326");
		ub.setDob("16-07-2001");
		ub.setGender("Male");
		ub.setSecurityAnswer("Java");
		ub.setPassword("utsav");
		ub.setCPassword("utsav");
		ub.setAddress(list);

		AssignBean assignb = new AssignBean();
		assignb.setAssignId(1);
		
		List<AssignBean> assignBean = new ArrayList<AssignBean>();
		assignBean.add(assignb);
		ub.setAssign(assignBean);

		List<Integer> address = new ArrayList<Integer>();
		address.add(1);
		address.add(2);
		address.add(3);
		
		when(addressDao.getAddressIds(ub.getUserid())).thenReturn(address);
//		when(addressDao.deleteAllById(address)).thenReturn(address);
		userService.updateUser(ub);
		verify(userDao, atLeast(1)).save(ub);

	}
	
	

	@Test
	void showUserTest() {
		UserBean ubean = new UserBean();
		ubean.setUserid(1);
		ubean.setEmail("utsav@gmail.com");

		List<UserBean> userData = new ArrayList<UserBean>();
		userData.add(ubean);

		when(userDao.findAll()).thenReturn(userData);
		userData = userService.showUser();
		assertNotNull(userData);
		verify(userDao, atLeast(1)).findAll();

	}

	@Test
	void deleteUserTest() {
		UserBean ubean = new UserBean();
		ubean.setUserid(1);
		int id = ubean.getUserid();
		userService.deleteUser(id);
		verify(userDao, atLeast(1)).deleteById(id);

	}

	@Test
	void checkEmailTest() {
		UserBean ubean = new UserBean();
		ubean.setUserid(1);
		ubean.setEmail("utsav@gmail.com");
		when(userDao.getUserid(ubean.getEmail())).thenReturn(1);
		boolean email = userService.checkEmail(ubean.getEmail());
		assertThat(email == true);
		verify(userDao, atLeast(1)).getUserid("utsav@gmail.com");

	}

	@Test
	void checkEmailTest2() {
		UserBean ubean = new UserBean();
		ubean.setUserid(1);
		ubean.setEmail("utsav@gmail.com");
		when(userDao.getUserid(ubean.getEmail())).thenReturn(0);
		boolean email = userService.checkEmail(ubean.getEmail());
		assertThat(email == true);
		verify(userDao, atLeast(1)).getUserid("utsav@gmail.com");

	}

	@Test
	void forgotPasswordTest() {

		UserBean ubean = new UserBean();
		ubean.setEmail("utsav@gmail.com");
		ubean.setPhoneNo("9574359326");
		ubean.setSecurityAnswer("Java");
		ubean.setPassword("utsav");
		ubean.setCPassword("utsav");

//		UserBean expected = new UserBean();
//		expected.setUserid(1);
//		expected.setEmail("utsav@gmail.com");
//		expected.setPhoneNo("9574359326");
//		expected.setSecurityAnswer("Java");
//		expected.setPassword("utsav");
//		expected.setCPassword("utsav");

		when(userDao.getUserEmail(ubean.getEmail())).thenReturn(ubean);

		int actual = userService.forgotPassword("utsav@gmail.com", "9574359326", "Java", "utsav");
		assertNotNull(actual);

		verify(userDao, atLeast(1)).save(ubean);

	}

	@Test
	void resertPasswordTest() {

		UserBean ubean = new UserBean();
		ubean.setPassword("utsav");
		ubean.setCPassword("utsav");
		ubean.setNewPassword("utsav");

		List<UserBean> userData = new ArrayList<UserBean>();
		userData.add(ubean);

		when(userDao.findAll()).thenReturn(userData);
		when(userDao.getUserEmail(ubean.getEmail())).thenReturn(ubean);

		userService.resetPassword("utsav", "utsav", "utsav");

		verify(userDao, atLeast(1)).save(ubean);

	}

	@Test
	void checkUserTypeTest() {

		UserBean ubean = new UserBean();
		ubean.setUserid(1);
		ubean.setEmail("utsav@gmail.com");
		when(userDao.getUserEmail(ubean.getEmail())).thenReturn(ubean);

		AssignBean assignb = new AssignBean();
		assignb.setAssignId(1);
		List<AssignBean> assignBean = new ArrayList<AssignBean>();
		assignBean.add(assignb);
		ubean.setAssign(assignBean);

		when(adminDao.userType(ubean.getUserid())).thenReturn(assignBean);

		adminService.checkUserType(ubean);
		assertNotNull(ubean);
		verify(adminDao, atLeast(1)).userType(ubean.getUserid());

	}

}
