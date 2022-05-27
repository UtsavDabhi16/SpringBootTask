package com.inexture.springBootTask.DAO;


<<<<<<< HEAD

=======
>>>>>>> 206210ae71d3f20f7aff78ad0efd3f494ece7011
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
=======

>>>>>>> 206210ae71d3f20f7aff78ad0efd3f494ece7011
import com.inexture.springBootTask.Model.UserBean;

public interface UserDaoInterface extends JpaRepository<UserBean, Integer> {

	@Query("from UserBean where Email=?1")
	UserBean getUserEmail(String uemail);
<<<<<<< HEAD
	
//	UserBean findDistinctByEmail(String uemail);
=======
>>>>>>> 206210ae71d3f20f7aff78ad0efd3f494ece7011

	@Query("from UserBean")
	List<UserBean> getAllUser();

	@Query("select Userid from UserBean where Email=?1")
	int getUserid(String email);
	
<<<<<<< HEAD
//	int findByUserid(String email);
	
=======
>>>>>>> 206210ae71d3f20f7aff78ad0efd3f494ece7011
	
}
