package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	public UserController() {
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Users list:");
		service.listUsers().stream().map(User::toString).forEach(messages::add);
		model.addAttribute("messages", messages);
		return "index";
	}
	
}