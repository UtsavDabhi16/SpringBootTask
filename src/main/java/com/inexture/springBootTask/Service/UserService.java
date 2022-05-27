package com.inexture.springBootTask.Service;

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

	UserBean getUserByEmail(String uemail);

	int updateUser(UserBean user);

	List<UserBean> showUser();

	void deleteUser(int userId);

	int forgotPassword(String email, String phone, String sQuestion, String nPassword);

	void resetPassword(String oldPass, String newPass, String cPass);

	boolean checkEmail(String email);
}
