package liveDemo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import liveDemo.model.LiveRedis;
import liveDemo.model.UserRedis;
import liveDemo.service.LiveService;
import liveDemo.service.UserService;

@CrossOrigin
@RestController
@EnableAutoConfiguration
public class RegisterController {

	@Autowired
	UserService userService;
	@Autowired
	private LiveService liveService;
	
	@RequestMapping(value="/reg",method=RequestMethod.GET)
	public ModelAndView toRegister(ModelMap model){
		UserRedis user = new UserRedis();
		model.addAttribute("user", user);
		return new ModelAndView("register");
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute(value="user")UserRedis user,HttpSession session,ModelMap model){
		userService.save(user);
		List<LiveRedis> list = liveService.getAll();
		model.addAttribute("liveList", list);
		session.setAttribute("user", user);
		return new ModelAndView("liveList");
	}
}
