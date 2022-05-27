package com.inexture.springBootTask.Service;

<<<<<<< HEAD
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.inexture.springBootTask.Model.UserBean;

public interface UserService {
	
	boolean registerUser(UserBean u) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException;
=======
import java.util.List;

import com.inexture.springBootTask.Model.UserBean;

public interface UserService {
	boolean registerUser(UserBean u);
>>>>>>> 206210ae71d3f20f7aff78ad0efd3f494ece7011

	UserBean getUserByEmail(String uemail);

	int updateUser(UserBean user);

	List<UserBean> showUser();

	void deleteUser(int userId);

	int forgotPassword(String email, String phone, String sQuestion, String nPassword);

	void resetPassword(String oldPass, String newPass, String cPass);

	boolean checkEmail(String email);
}
