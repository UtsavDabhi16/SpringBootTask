package com.inexture.springBootTask.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inexture.springBootTask.DAO.AdminDaoInterface;
import com.inexture.springBootTask.DAO.UserDaoInterface;
import com.inexture.springBootTask.Model.AssignBean;
import com.inexture.springBootTask.Model.UserBean;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private UserDaoInterface userDao;

	@Autowired
	private AdminDaoInterface adminDao;

	@Override
	public List<AssignBean> checkUserType(UserBean uBean) {
		UserBean userBean = userDao.getUserEmail(uBean.getEmail());
		System.out.println("User role is :"+userBean.getUserid());
		List<AssignBean> usertype = adminDao.userType(userBean.getUserid());
		System.out.println("User Tyte is :"+usertype);
		return usertype;
	}

}
