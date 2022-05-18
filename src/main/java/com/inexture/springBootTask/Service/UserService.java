package com.inexture.springBootTask.Service;

import java.util.List;

import com.inexture.springBootTask.Model.UserBean;

public interface UserService {
	boolean registerUser(UserBean u);

	UserBean getUserByEmail(String uemail);

	int updateUser(UserBean user);

	List<UserBean> showUser();

	void deleteUser(int userId);

	int forgotPassword(String email, String phone, String sQuestion, String nPassword);

	void resetPassword(String oldPass, String newPass, String cPass);

	boolean checkEmail(String email);
}
