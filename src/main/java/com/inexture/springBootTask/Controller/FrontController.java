package com.inexture.springBootTask.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@GetMapping(value = "/registration")
	public String registration() {
		return "registrationuser";
	}

	@GetMapping("/UserProfile")
	public String home() {
		return "Profile";
	}

	@RequestMapping("/forgotpassword")
	public String forgotpassword() {
		return "fpassword";
	}

	@RequestMapping("/resetPassword")
	public String resetPassword() {
		return "resetpassword";
	}

	@RequestMapping("/updateuser")
	public String updatePUser() throws SQLException {
		return "updateUser";
	}

	@GetMapping("/UserLogout")
	public String userLogout(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		session = request.getSession(false);
		session.invalidate();

		return "redirect:/";
	}

	@GetMapping("/admin")
	public String admin() {
		return "adminmodule";
	}

	@GetMapping("/AdminLogout")
	public String adminLogout(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		session = request.getSession(false);
		session.invalidate();

		return "redirect:/";
	}

//Register User
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute UserBean userBean, BindingResult br, Model model)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException, UnsupportedEncodingException {

		System.out.println("hello");
//		if (br.hasErrors()) {
//			System.out.println("inside");
//			List<FieldError> error = br.getFieldErrors();
//			List<String> errors = new ArrayList<>();
//			for (FieldError f : error) {
//				errors.add(f.getDefaultMessage());
//			}
//			model.addAttribute("validerror", errors);
//			return "registration";
//		} else {
			userService.registerUser(userBean);
			return "login";
//		}

	}

//Login User Or Admin
	@GetMapping(path = "/loginController")
	public String login(@RequestParam String uemail, @RequestParam String upassword, HttpServletRequest request,
			Model model, HttpSession session, HttpServletResponse response) throws SQLException, InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {

		UserBean userData = userService.getUserByEmail(uemail);

		String dpass = Validation.decrypt(userData.getPassword(), secretKey);

		Validation.comparePassword(upassword, dpass);

		session = request.getSession();

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

//Update User 
	@GetMapping(path = "/UpdateUserProfile")
	public String updateUserProfile(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model) {
		session = request.getSession(false);
		UserBean userBean = (UserBean) session.getAttribute("name");
		session.setAttribute("name", userBean);
		return "updateuser";
	}

	@PostMapping(path = "/UpdateUserDetailsController")
	public String updateUserDetailsController(@ModelAttribute UserBean user, Model model, HttpSession session,
			HttpServletRequest request) throws CloneNotSupportedException {

		session = request.getSession(false);
		userService.updateUser(user);
		System.out.println("inside second update address :" + user);
		session.setAttribute("name", user);
		return "UserProfile";
	}

	@GetMapping(path = "/UpdateUserDetails")
	public String updateUserDetails(UserBean user, Model model, HttpSession session) throws SQLException {
		uBean = userService.getUserByEmail(user.getEmail());
		session.setAttribute("name", uBean);
		return "updateuser";
	}

	@GetMapping(path = "/UserTableController")
	public void userTable(HttpServletResponse response) throws IOException {
		List<UserBean> userdata;

		// Convert Data into JSON
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		JsonObject json = new JsonObject();
		userdata = userService.showUser();
		json.add("data", gson.toJsonTree(userdata));
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(json);

	}

	// Delete User
	@GetMapping(path = "/DeleteCurrentUserController")
	@ResponseBody
	public String deleteUser(@RequestParam("uid") String uid) {
		int userId = Integer.parseInt(uid);
		System.out.println(userId);
		userService.deleteUser(userId);
		return "SUCCESS";
	}

	// Forgot Password
	@GetMapping(path = "/ForgotPasswordController")
	public String forgotUserPassword(@RequestParam("email") String email, @RequestParam("phoneNo") String phone,
			@RequestParam("SecurityAnswer") String sQuestion, @RequestParam("NPassword") String NPassword) {
		userService.forgotPassword(email, phone, sQuestion, NPassword);
		return "login";
	}

	// Reset Password
	@GetMapping(path = "/resetPasswordController")
	public String resetUserPassword(@RequestParam("oldPassword") String oldPass,
			@RequestParam("newPassword") String newPass, @RequestParam("CPassword") String CPass) {
		userService.resetPassword(oldPass, newPass, CPass);
		return "login";
	}

	// Email Exist or Not
	@PostMapping("/CheckEmailExist")
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