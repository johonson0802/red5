package liveDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import liveDemo.dao.UserRedisDAO;
import liveDemo.model.UserRedis;
import liveDemo.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/userList")
	public ModelAndView List(Model model){
		List<UserRedis> users = userService.getAll();
		model.addAttribute("users", users);
		return new ModelAndView("user/userList");
	}
	
	@RequestMapping("/")
	String home(){
		return "Hello World";
	}
	
	@RequestMapping("/hello/{userName}")
	String index(@PathVariable String userName){
		return "Hello\t" + userName + "!!!";
	}
}
