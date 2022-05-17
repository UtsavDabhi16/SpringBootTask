package com.inexture.springBootTask.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import com.inexture.springBootTask.Model.UserBean;
//import com.inexture.springBootTask.repository.UserRepository;

@Controller
public class FrontController {

//	@Autowired
//	private UserRepository userRepository;

	@GetMapping("/hello")
	public String hello() {
		return "Hello User, have a nice day.";
	}

//	@GetMapping("/users")
//	public String listAll(Model model) {
//		List<UserBean> listUsers = userRepository.findAll();
//		model.addAttribute("listUsers", listUsers);
//		return "users";
//	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index() {
		return "login";
	}

}