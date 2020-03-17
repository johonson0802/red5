package liveDemo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	@Autowired
	private LiveService liveService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView toLogin(ModelMap model){
		UserRedis user = new UserRedis();
		model.addAttribute("user", user);
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute(value="user")UserRedis user,ModelMap model,HttpSession session){
		String url = "liveList";
		if(userService.isUser(user)){
			session.setAttribute("user", user);
			List<LiveRedis> list = liveService.getAll();
			model.addAttribute("liveList", list);
		}else{
			model.addAttribute("user", user);
			model.addAttribute("errorMessage", "请输入正确信息！");
			logger.info("用户名="+user.getName());
			url="login";
		}
		return new ModelAndView(url);
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session){
		session.invalidate();
		return new ModelAndView("login");
	}
}
