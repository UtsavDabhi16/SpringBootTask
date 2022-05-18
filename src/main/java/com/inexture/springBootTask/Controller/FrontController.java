package com.inexture.springBootTask.Controller;

import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.inexture.springBootTask.Model.AddressBean;
import com.inexture.springBootTask.Model.AssignBean;
import com.inexture.springBootTask.Model.UserBean;
import com.inexture.springBootTask.Service.AdminService;
import com.inexture.springBootTask.Service.UserService;
import com.inexture.springBootTask.Service.Validation;

@Controller
public class FrontController {

	static String secretKey = "HelloWorld!!!";

	@Autowired
	UserService userService;

	@Autowired
	AdminService adminService;

	@Autowired
	UserBean uBean;

	@Autowired
	AddressBean aBean;

	@RequestMapping({ "/", "/page" })
	public String test() {
		return "login";
	}

	@RequestMapping("/registration")
	public String registration() {
		return "registration";
	}

	@GetMapping("/UserProfile")
	public String home() {
		return "UserProfile";
	}

	@RequestMapping("/forgotpassword")
	public String forgotpassword() {
		return "forgotpassword";
	}

	@RequestMapping("/resetPassword")
	public String resetPassword() {
		return "resetPassword";
	}

	@RequestMapping("/updateuser")
	public String updatePUser() throws SQLException {
		return "updateuser";
	}

	@RequestMapping(value = "/UserLogout", method = RequestMethod.GET)
	public String userLogout(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		session = request.getSession(false);
		if (session != null) {
			System.out.println("inside user logout");
			session.invalidate();
		}
		return "redirect:/";
	}

	@GetMapping("/admin")
	public String adminLogout() {
		return "admin";
	}

	@RequestMapping(value = "/AdminLogout", method = RequestMethod.GET)
	public String adminLogout(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		session = request.getSession(false);
		if (session != null) {
			System.out.println("inside admin logout");
			session.invalidate();
		}
		return "redirect:/";
	}

//Register User
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute UserBean userBean, BindingResult br, Model model) {

		if (br.hasErrors()) {
			List<FieldError> error = br.getFieldErrors();
			List<String> errors = new ArrayList<>();
			for (FieldError f : error) {
				errors.add(f.getDefaultMessage());
			}
			model.addAttribute("validerror", errors);
			return "registration";
		} else if (!Validation.validate(userBean)) {

			model.addAttribute("failuser", userBean);
			model.addAttribute("errormsg", "Input Field is empty or too large or type mismatch.");

			return "registration";

		} else {
			boolean checkValue = userService.registerUser(userBean);

			if (checkValue == true) {
				return "login";
			} else {
				return "registration";
			}
		}

	}

//Login User Or Admin
	@RequestMapping(path = "/loginController", method = RequestMethod.GET)
	public String login(@RequestParam String uemail, @RequestParam String upassword, HttpServletRequest request,
			Model model, HttpSession session, HttpServletResponse response) throws SQLException, InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

		UserBean userData = userService.getUserByEmail(uemail);

		String dpass = Validation.decrypt(userData.getPassword(), secretKey);

		boolean validUser = Validation.comparePassword(upassword, dpass);

		session = request.getSession();

		if (validUser) {

			uBean.setEmail(uemail);
			uBean.setPassword(upassword);

			List<AssignBean> UserType = adminService.checkUserType(uBean);

			System.out.println("User type is :" + UserType);
			if (UserType.get(0).getId() == 2) {
				uBean = userService.getUserByEmail(uemail);
				System.out.println(uBean.getUserid());
				session.setAttribute("admin", uBean);
				return "redirect:admin";

			} else if (UserType.get(0).getId() == 1) {
				uBean = userService.getUserByEmail(uemail);
				session.setAttribute("name", uBean);
				return "redirect:UserProfile";
			} else {
				return "login";
			}

		}
		return "login";
	}

//Update User 
	@RequestMapping(path = "/UpdateUserProfile", method = RequestMethod.GET)
	public String updateUserProfile(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model) {
		session = request.getSession(false);
		if (session == null) {
			return "UserProfile";
		} else {
			UserBean userBean = (UserBean) session.getAttribute("name");
			try {
				session.setAttribute("name", userBean);
				return "updateuser";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "updateuser";
	}

	@RequestMapping(path = "/UpdateUserDetailsController", method = RequestMethod.POST)
	public String updateUserDetailsController(@ModelAttribute UserBean user, Model model, HttpSession session,
			HttpServletRequest request) throws CloneNotSupportedException {
		session = request.getSession(false);
		userService.updateUser(user);
		System.out.println("inside second update address :" + user);
		session.setAttribute("name", user);
		return "UserProfile";
	}

	@RequestMapping(path = "/UpdateUserDetails", method = RequestMethod.GET)
	public String updateUserDetails(UserBean user, Model model, HttpSession session) throws SQLException {
		uBean = userService.getUserByEmail(user.getEmail());
		System.out.println("coco :" + uBean);
		session.setAttribute("name", uBean);
		return "updateuser";
	}

	@RequestMapping(path = "/UserTableController", method = RequestMethod.GET)
	public void userTable(HttpServletResponse response) {
		List<UserBean> userdata;
		try {
			// Convert Data into JSON
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			JsonObject json = new JsonObject();
			userdata = userService.showUser();
			json.add("data", gson.toJsonTree(userdata));
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Delete User
	@RequestMapping(path = "/DeleteCurrentUserController", method = RequestMethod.GET)
	public void deleteUser(@RequestParam("uid") String uid) {
		int userId = Integer.parseInt(uid);
		System.out.println(userId);
		userService.deleteUser(userId);
	}

	// Forgot Password
	@RequestMapping(path = "/ForgotPasswordController", method = RequestMethod.GET)
	public String forgotUserPassword(@RequestParam("email") String email, @RequestParam("phoneNo") String phone,
			@RequestParam("SecurityAnswer") String sQuestion, @RequestParam("NPassword") String NPassword) {
		userService.forgotPassword(email, phone, sQuestion, NPassword);
		return "login";
	}

	// Reset Password
	@RequestMapping(path = "/resetPasswordController", method = RequestMethod.GET)
	public String resetUserPassword(@RequestParam("oldPassword") String oldPass,
			@RequestParam("newPassword") String newPass, @RequestParam("CPassword") String CPass) {
		userService.resetPassword(oldPass, newPass, CPass);
		return "login";
	}

	// Email Exist or Not
	@RequestMapping(path = "/CheckEmailExist", method = RequestMethod.POST)
	@ResponseBody
	public String emailExistOrNot(@RequestParam("Email") String email, HttpSession session) {
		System.out.println("inside user email is :" + email);
		if (!userService.checkEmail(email)) {
			return "<span style=\"color:red;\">Email Already Exist.</span>";
		} else {
			return "";
		}
	}

}