package com.inexture.springBootTask.Service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inexture.springBootTask.DAO.AddressDaoInterface;
import com.inexture.springBootTask.DAO.UserDaoInterface;
import com.inexture.springBootTask.Model.AddressBean;
import com.inexture.springBootTask.Model.AssignBean;
import com.inexture.springBootTask.Model.UserBean;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoInterface userDao;

	@Autowired
	private AddressDaoInterface addressDao;

	@Autowired
	UserBean ubean;

	@Autowired
	AddressBean address;

	final static String secretKey = "HelloWorld!!!";

	static final Logger log = Logger.getLogger(UserServiceImpl.class);

	@Override
	public boolean registerUser(UserBean ubean) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {

			List<AddressBean> address = ubean.getAddress();

			for (AddressBean a : address) {
				a.setUser(ubean);
			}

			List<AssignBean> assign = ubean.getAssign();

			for (AssignBean role : assign) {
				role.setUser(ubean);
			}

			String pass = ubean.getPassword();
			String cpass = ubean.getCPassword();
			String password = Validation.encrypt(pass, secretKey);
			String cpassword = Validation.encrypt(cpass, secretKey);

			ubean.setPassword(password);
			ubean.setCPassword(cpassword);
			ubean.setAddress(address);
			
			ubean.setAssign(assign);

			userDao.save(ubean);

			log.info("Inside User Register Service Method");
		
		return true;
	}


	@Override
	public UserBean getUserByEmail(String uemail) {
		
		return userDao.getUserEmail(uemail);
		
	}

	@Override
	public int updateUser(UserBean user) {
		
		List<AddressBean> newAddress = user.getAddress();

		List<Integer> aids = addressDao.getAddressIds(user.getUserid());

		for (AddressBean a : newAddress) {
			if (aids.size() > 0) {
				a.setAddressId(aids.get(0));
				aids.remove(0);
			}

			a.setUser(user);
		}

		user.setAddress(newAddress);

		userDao.save(user);

		if (aids.size() > 0) {
			addressDao.deleteAllById(aids);
		}

		return 1;

	}

	@Override
	public List<UserBean> showUser() {
		List<UserBean> userData=new ArrayList<UserBean>();
		userDao.findAll().forEach(UserBean -> userData.add(UserBean));  
		return userData;
	}

	@Override
	public void deleteUser(int userId) {
		userDao.deleteById(userId);
	}

	@Override
	public int forgotPassword(String email, String phone, String sQuestion, String nPassword) {
		UserBean oldUserData = userDao.getUserEmail(email);
		if (email.equals(oldUserData.getEmail()) && phone.equals(oldUserData.getPhoneNo())
				&& sQuestion.equals(oldUserData.getSecurityAnswer())) {
			oldUserData.setPassword(nPassword);
			oldUserData.setCPassword(nPassword);
			userDao.save(oldUserData);
		}

		return 1;
		
	}

	@Override
	public void resetPassword(String oldPass, String newPass, String cPass) {

		List<UserBean> userData=new ArrayList<UserBean>();
//		List<UserBean> list = userDao.getAllUser();
		userDao.findAll().forEach(UserBean -> userData.add(UserBean));  
		for (UserBean l : userData) {
			if (l.getPassword()!= null && l.getPassword().equals(oldPass)) {
				UserBean user = userDao.getUserEmail(l.getEmail());
				user.setPassword(cPass);
				user.setCPassword(cPass);
				user.setNewPassword(newPass);
				userDao.save(user);
			}
		}		
	}

	@Override
	public boolean checkEmail(String email) {
		return userDao.getUserid(email)==0;
	}

}
