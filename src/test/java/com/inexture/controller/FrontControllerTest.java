package com.inexture.controller;

import com.inexture.springBootTask.Model.AddressBean;
import com.inexture.springBootTask.Model.UserBean;
import com.inexture.springBootTask.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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


}
