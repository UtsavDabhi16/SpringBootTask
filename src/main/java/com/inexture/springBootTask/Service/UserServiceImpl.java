package com.inexture.springBootTask.Service;

import java.util.List;

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
	public boolean registerUser(UserBean ubean) {

		try {

			List<AddressBean> address = ubean.getAddress();

			for (AddressBean a : address) {
				a.setUser(ubean);
			}

			List<AssignBean> assign = ubean.getAssign();

			System.out.println("Assign Value size :" + assign);
			System.out.println(assign.size());

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
			System.out.println("My assig is :" + assign);
			ubean.setAssign(assign);

			userDao.save(ubean);

			log.info("Inside User Register Service Method");
			System.out.println(ubean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public UserBean getUserByEmail(String uemail) {
		UserBean ubean = userDao.getUserEmail(uemail);
		return ubean;
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
		} else {
			log.debug("No addresses found to delete.");
		}

		return 1;

	}

	@Override
	public List<UserBean> showUser() {
		List<UserBean> userData = userDao.getAllUser();
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
		List<UserBean> list = userDao.getAllUser();
		for (UserBean l : list) {
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
