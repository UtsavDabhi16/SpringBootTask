package com.inexture.controller;

<<<<<<< HEAD

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
=======
import com.inexture.springBootTask.Model.AddressBean;
import com.inexture.springBootTask.Model.UserBean;
import com.inexture.springBootTask.Service.UserService;
import org.junit.jupiter.api.Test;
>>>>>>> 319f966123046e744cfd32eaed0b6f2eb34bd831
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
<<<<<<< HEAD
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.inexture.springBootTask.Controller.FrontController;
import com.inexture.springBootTask.Model.AddressBean;
import com.inexture.springBootTask.Model.AssignBean;
import com.inexture.springBootTask.Model.UserBean;
import com.inexture.springBootTask.Service.AdminService;
import com.inexture.springBootTask.Service.UserService;
import com.inexture.springBootTask.Service.Validation;

@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = FrontController.class)
public class FrontControllerTest {

	static String secretKey = "HelloWorld!!!";
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@MockBean
	private AdminService adminService;

	@MockBean
	UserBean uBean;

	@MockBean
	AddressBean aBean;

	@Test
	void Test() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"));
	}

	@Test
	void registrationTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/registration"));
	}

	@Test
	void homeTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/UserProfile"));
	}

	@Test
	void forgotTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/forgotpassword"));
	}

	@Test
	void resetTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/resetPassword"));
	}

	@Test
	void updatePUserTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/updateuser"));
	}

	@Test
	void adminTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/admin"));
	}

	@Test
	void adminLogoutTest() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = get("/AdminLogout");
		MockMvcBuilders.standaloneSetup(FrontController.class).build().perform(requestBuilder)
				.andExpect(status().isFound()).andExpect(MockMvcResultMatchers.model().size(0))
				.andExpect(MockMvcResultMatchers.redirectedUrl("/"));
	}

	@Test
	void userLogoutTest() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = get("/UserLogout");
		MockMvcBuilders.standaloneSetup(FrontController.class).build().perform(requestBuilder)
				.andExpect(status().isFound()).andExpect(MockMvcResultMatchers.model().size(0))
				.andExpect(MockMvcResultMatchers.redirectedUrl("/"));
	}

//	@Test
//	void registerTest() throws Exception {
//
//		AddressBean ab = new AddressBean();
//		ab.setAddressLineOne("First Line");
//		ab.setAddressLineTwo("Second Line");
//		ab.setPincode("364710");
//		ab.setCity("Ahmead");
//		ab.setState("Gujarat");
//
//		List<AddressBean> list = new ArrayList<AddressBean>();
//		list.add(ab);
//
//		UserBean ub = new UserBean();
//		ub.setFirstName("Utsav");
//		ub.setLastName("Dabhi");
//		ub.setEmail("utsav@gmail.com");
//		ub.setPhoneNo("9574359326");
//		ub.setDob("16-07-2001");
//		ub.setGender("Male");
//		ub.setSecurityAnswer("Java");
//		ub.setPassword("utsav");
//		ub.setCPassword("utsav");
//		ub.setAddress(list);
//
//		when(userService.registerUser(ub)).thenReturn(true);
//
//		mockMvc.perform(post("/register").flashAttr("userBean", ub));
//
//	}

	@Test
	void registerTest2() throws Exception {

		AddressBean ab = new AddressBean();
		ab.setAddressLineOne("First Line");
		ab.setAddressLineTwo("Second Line");
		ab.setPincode("364710");
		ab.setCity("Ahmead");
		ab.setState("Gujarat");

		List<AddressBean> list = new ArrayList<AddressBean>();
		list.add(ab);

		UserBean ub = new UserBean();
		ub.setUserid(1);
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

		Validation.validate(ub);

		when(userService.registerUser(ub)).thenReturn(true);

		mockMvc.perform(post("/register").flashAttr("failuser", ub));

	}

	
	@Test
	void loginTest() throws Exception {

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
		
		String encryptpass=ub.getPassword();
		String pass=Validation.encrypt(encryptpass,secretKey );
		ub.setPassword(pass);

		when(userService.getUserByEmail("utsav@gmail.com")).thenReturn(ub);

		AssignBean aBean = new AssignBean();
		aBean.setId(2);
		List<AssignBean> assignBean = new ArrayList<AssignBean>();
		assignBean.add(aBean);

		when(adminService.checkUserType(any())).thenReturn(assignBean);

		mockMvc.perform(get("/loginController").param("uemail", "utsav@gmail.com").param("upassword", "utsav"));

	}

	@Test
	void loginTest2() throws Exception {

		AddressBean ab = new AddressBean();
		ab.setAddressLineOne("First Line");
		ab.setAddressLineTwo("Second Line");
		ab.setPincode("364710");
		ab.setCity("Ahmead");
		ab.setState("Gujarat");

		List<AddressBean> list = new ArrayList<AddressBean>();
		list.add(ab);

		UserBean ub = new UserBean();
		ub.setFirstName("");
		ub.setLastName("Dabhi");
		ub.setEmail("utsav@gmail.com");
		ub.setPhoneNo("9574359326");
		ub.setDob("16-07-2001");
		ub.setGender("Male");
		ub.setSecurityAnswer("Java");
		ub.setPassword("utsav");
		ub.setCPassword("utsav");
		ub.setAddress(list);
		
		String encryptpass=ub.getPassword();
		String pass=Validation.encrypt(encryptpass,secretKey );
		ub.setPassword(pass);


		when(userService.getUserByEmail("utsav@gmail.com")).thenReturn(ub);

		AssignBean aBean = new AssignBean();
		aBean.setId(1);
		List<AssignBean> assignBean = new ArrayList<AssignBean>();
		assignBean.add(aBean);

		when(adminService.checkUserType(any())).thenReturn(assignBean);

		mockMvc.perform(get("/loginController").param("uemail", "utsav@gmail.com").param("upassword", "utsav"));

	}

	@Test
	void loginTest3() throws Exception {

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

		String encryptpass=ub.getPassword();
		String pass=Validation.encrypt(encryptpass,secretKey );
		ub.setPassword(pass);

		
		when(userService.getUserByEmail("utsav@gmail.com")).thenReturn(ub);

		AssignBean aBean = new AssignBean();
		aBean.setId(3);
		List<AssignBean> assignBean = new ArrayList<AssignBean>();
		assignBean.add(aBean);

		when(adminService.checkUserType(any())).thenReturn(assignBean);

		mockMvc.perform(get("/loginController").param("uemail", "utsav@gmail.com").param("upassword", "utsav"));

	}

	@Test
	void userTableTest() throws Exception {

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

		List<UserBean> ubean = new ArrayList<UserBean>();
		ubean.add(ub);

		when(userService.showUser()).thenReturn(ubean);

		mockMvc.perform(MockMvcRequestBuilders.get("/UserTableController"));

	}

	@Test
	void updateUserProfileTest() throws Exception {

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

		List<UserBean> ubean = new ArrayList<UserBean>();
		ubean.add(ub);

//		when(userService.updateUser(ub)).thenReturn(1);

		mockMvc.perform(MockMvcRequestBuilders.get("/UpdateUserProfile").sessionAttr("name", ub));

	}

	@Test
	void updateUserDetailsControllerTest() throws Exception {
		AddressBean ab = new AddressBean();
		ab.setAddressLineOne("First Line");
		ab.setAddressLineTwo("Second Line");
		ab.setPincode("364710");
		ab.setCity("Ahmead");
		ab.setState("Gujarat");

		List<AddressBean> list = new ArrayList<AddressBean>();
		list.add(ab);

		UserBean ub = new UserBean();
		ub.setUserid(1);
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

	
		when(userService.updateUser(ub)).thenReturn(1);

		mockMvc.perform(MockMvcRequestBuilders.post("/UpdateUserDetailsController").sessionAttr("name", ub));
	}

	@Test
	void UpdateUserDetailsTest() throws Exception {

		AddressBean ab = new AddressBean();
		ab.setAddressLineOne("First Line");
		ab.setAddressLineTwo("Second Line");
		ab.setPincode("364710");
		ab.setCity("Ahmead");
		ab.setState("Gujarat");

		List<AddressBean> list = new ArrayList<AddressBean>();
		list.add(ab);

		UserBean ub = new UserBean();
		ub.setUserid(1);
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

		when(userService.getUserByEmail(ub.getEmail())).thenReturn(ub);

		mockMvc.perform(MockMvcRequestBuilders.get("/UpdateUserDetails").sessionAttr("name", ub));
	}

	@Test
	void deleteUserTest() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/DeleteCurrentUserController").param("uid", "1"))
				.andExpect(content().string("SUCCESS"));

	}

	@Test
	void forgotUserPasswordTest() throws Exception {
		String email = "utsav@gmail.com";
		String phone = "9574359326";
		String sQuestion = "Java";
		String NewPass = "dabhi";

		when(userService.forgotPassword(email, phone, sQuestion, NewPass)).thenReturn(1);

		mockMvc.perform(get("/ForgotPasswordController").param("email", "utsav@gmail.com")
				.param("phoneNo", "9574359326").param("SecurityAnswer", "Java").param("NPassword", "dabhi"));
	}

	@Test
	void resetPasswordTest() throws Exception {
		String oldPass = "utsav";
		String CPass = "utsav";
		String NewPass = "dabhi";

		userService.resetPassword(oldPass, CPass, NewPass);

		mockMvc.perform(get("/resetPasswordController").param("oldPassword", "utsav").param("newPassword", "utsav")
				.param("CPassword", "dabhi"));
	}

	@Test
	void emailExistOrNotTest() throws Exception {

		String email = "utsav@gmail.com";
		when(userService.checkEmail(email)).thenReturn(true);
		mockMvc.perform(post("/CheckEmailExist").param("Email", "utsav@gmail.com"));
	}

	@Test
	void emailExistOrNotTest2() throws Exception {

		String email = "utsav@gmail.com";
		when(userService.checkEmail(email)).thenReturn(false);
		mockMvc.perform(post("/CheckEmailExist").param("Email", "utsav@gmail.com"));
	}
=======
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FrontControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;


    @Test
    public void registerUserTest() throws Exception {

        AddressBean addressBean=new AddressBean();
        addressBean.setAddressId(1);
        addressBean.setAddressLineOne("First Line");
        addressBean.setAddressLineTwo("Second Line");
        addressBean.setPincode("123456");
        addressBean.setCity("Ahmead");
        addressBean.setState("Gujarat");

        List<AddressBean> addressBeanList=new ArrayList<AddressBean>();
        addressBeanList.add(addressBean);

        UserBean userBean=new UserBean();
        userBean.setUserid(1);
        userBean.setFirstName("Utsav");
        userBean.setLastName("Dabhi");
        userBean.setEmail("utsav@gmail.com");
        userBean.setPhoneNo("9876543210");
        userBean.setDob("12-05-2001");
        userBean.setGender("Male");
        userBean.setSecurityAnswer("Java");
        userBean.setPassword("utsav");
        userBean.setCPassword("utsav");
        userBean.setAddress(addressBeanList);

        when(userService.registerUser(userBean)).thenReturn(true);
 
        verify(userService, atLeast(1)).registerUser(any());

    }


    @Test
    public void deleteUserTest(){
        System.out.println("hello");
    }

>>>>>>> 319f966123046e744cfd32eaed0b6f2eb34bd831

}
