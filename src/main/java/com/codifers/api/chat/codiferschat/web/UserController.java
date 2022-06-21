package com.codifers.api.chat.codiferschat.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codifers.api.chat.codiferschat.business.domain.ResponseDTO;
import com.codifers.api.chat.codiferschat.business.domain.UserDTO;
import com.codifers.api.chat.codiferschat.business.service.UserService;
import com.codifers.api.chat.codiferschat.data.entity.User;

@Controller
public class UserController {
	
	private final UserService userService;
	 
	@Autowired
	public UserController(UserService userService) {
		// TODO Auto-generated constructor stub
		this.userService = userService;
		
		
	}
	
	@PostMapping("/register")
	public ResponseDTO registerUser(@RequestBody UserDTO user) {
		
		return userService.save(user);
	}
	
	@PostMapping("/start")
	public String startApp(@RequestBody User user, Model model) {
	
		List<User> users = userService.getAllUsersExceptMe(user);
		model.addAttribute("codifersClientUser", user);
		model.addAttribute("codifersClientList", users);
		return "login";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		User user = new User();
		user.setId(2);
		user.setName("Aditya");
		user.setUserName("adi12");
		return startApp(user,model);
	}
	
	@GetMapping("/login2")
	public String login2(Model model) {
		User user = new User();
		user.setId(1);
		user.setName("Namrata");
		user.setUserName("nimmi");
		return startApp(user,model);
	}
	

}
