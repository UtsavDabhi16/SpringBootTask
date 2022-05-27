package com.inexture.springBootTask.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.log4j.Logger;
import com.inexture.springBootTask.Model.AddressBean;
import com.inexture.springBootTask.Model.UserBean;

public class Validation {

	static final Logger LOG = Logger.getLogger(Validation.class);
	private static SecretKeySpec secretKey;
	private static byte[] key;

	public static void setKey(final String myKey) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest sha = null;

		key = myKey.getBytes("UTF-8");
		sha = MessageDigest.getInstance("SHA-1");
		key = sha.digest(key);
		key = Arrays.copyOf(key, 16);
		secretKey = new SecretKeySpec(key, "AES");

	}

	public static String encrypt(final String strToEncrypt, final String secret)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, UnsupportedEncodingException {

		setKey(secret);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	}

	public static String decrypt(final String strToDecrypt, final String secret)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, UnsupportedEncodingException {
//	  try {
		setKey(secret);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)), StandardCharsets.UTF_8);
//	    } catch (Exception e) {
//	      System.out.println("Error while decrypting: " + e.toString());
//	    }
//	    return null;
	}

	public static boolean comparePassword(String pass, String dpass) {
		if (pass.equals(dpass))
			return true;
		else
			return false;
	}

	public static boolean validate(UserBean u) {

		String fname = u.getFirstName();
		String lname = u.getLastName();
		String email = u.getEmail();
		String phone = u.getPhoneNo();
		String gender = u.getGender();
		String birthdate = u.getDob();
		String sque = u.getSecurityAnswer();
		String pass = u.getPassword();
		String cpass = u.getCPassword();
		List<AddressBean> address = u.getAddress();

		if (fname.equals("") || fname.length() > 255) {
			LOG.debug("Validation failed for fname.");
			return false;
		} else if (lname.equals("") || lname.length() > 255) {
			LOG.debug("Validation failed for lname.");
			return false;
		} else if (email.equals("") || email.length() > 255) {
			LOG.debug("Validation failed for email.");
			return false;
		} else if (phone.equals("")) {
			LOG.debug("Validation failed for phone.");
			return false;
		} else if (gender.equals("") || gender.length() > 255) {
			LOG.debug("Validation failed for gender.");
			return false;
		} else if (birthdate.equals("") || birthdate.length() > 255) {
			LOG.debug("Validation failed for birthdate.");
			return false;
		} else if (sque.equals("") || sque.length() > 255) {
			LOG.debug("Validation failed for Security Question.");
			return false;
		} else if (pass.equals("") || pass.length() > 255) {
			LOG.debug("Validation failed for Password.");
			return false;
		} else if (cpass.equals("") || cpass.length() > 255) {
			LOG.debug("Validation failed for Confirm Password.");
			return false;
		} else if (address.size() < 1) {
			LOG.debug("Validation failed for address size.");
			return false;
		} else {
			for (AddressBean a : address) {

				String addressLineOne = a.getAddressLineOne();
				String addressLineTwo = a.getAddressLineTwo();
				String city = a.getCity();
				String state = a.getState();
				String pincode = a.getPincode();

				if (addressLineOne == null || addressLineOne.equals("") || addressLineOne.length() > 255) {
					LOG.debug("Validation failed for Address Line One.");
					return false;
				} else if (addressLineTwo == null || addressLineTwo.equals("") || addressLineTwo.length() > 255) {
					LOG.debug("Validation failed for Address Line Two.");
					return false;
				} else if (city == null || city.equals("") || city.length() > 255) {
					LOG.debug("Validation failed for city.");
					return false;
				} else if (state == null || state.equals("") || state.length() > 255) {
					LOG.debug("Validation failed for state.");
					return false;
				} else if (pincode == null || pincode.equals("") || pincode.length() > 255) {
					LOG.debug("Validation failed for pincode.");
					return false;
				}
			}

			LOG.debug("All validation true.");
			return true;

		}
	}
}