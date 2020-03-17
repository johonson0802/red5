package liveDemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import liveDemo.model.LiveRedis;
import liveDemo.service.LiveService;

@CrossOrigin
@RestController
public class LiveController {
	@Autowired
	private LiveService liveService;
	
	@RequestMapping(value="/publisher",method=RequestMethod.GET)
	public ModelAndView toPublisher(ModelMap model){
		LiveRedis liveRedis = new LiveRedis();
		model.addAttribute("live",	liveRedis);
		return new ModelAndView("publisher");
	}
	
	@RequestMapping(value="/publisher",method=RequestMethod.POST)
	public ModelAndView publisher(@ModelAttribute(value="live")LiveRedis liveRedis,ModelMap model){
		liveService.save(liveRedis);
		List<LiveRedis> list = liveService.getAll();
		model.addAttribute("liveList", list);
		return new ModelAndView("publisher");
	}
	
	@RequestMapping(value="/live",method=RequestMethod.GET)
	public ModelAndView live(ModelMap model,HttpServletRequest request){
		String keyName = request.getParameter("keyname");
		model.addAttribute("keyName", keyName);
		return new ModelAndView("live");
	}
	
	@RequestMapping(value="/liveList",method=RequestMethod.GET)
	public ModelAndView liveList(ModelMap model,HttpSession session){
		List<LiveRedis> list = liveService.getAll();
		model.addAttribute("user", session.getAttribute("user"));
		model.addAttribute("liveList", list);
		return new ModelAndView("liveList");
	}
	
}
