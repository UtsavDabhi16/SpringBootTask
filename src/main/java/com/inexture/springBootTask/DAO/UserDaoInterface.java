package com.inexture.springBootTask.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inexture.springBootTask.Model.UserBean;

public interface UserDaoInterface extends JpaRepository<UserBean, Integer> {

	@Query("from UserBean where Email=?1")
	UserBean getUserEmail(String uemail);

	@Query("from UserBean")
	List<UserBean> getAllUser();

	@Query("select Userid from UserBean where Email=?1")
	int getUserid(String email);
	
	
}
