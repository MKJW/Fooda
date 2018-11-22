package org.controller;

import org.persistence.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/user/info/{userid}", method=RequestMethod.GET)
	public @ResponseBody User getUserInfo(@PathVariable String userid) {
		System.out.println("userid : " + userid + " is requested");
		UserDao userDao = new UserDao();
		User user = userDao.findByUserid(userid);
		
		if(user == null) {
			//예외 처리 필요
		}
		
		System.out.println("return " + user);
		return user;
		
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public void registerUser(@RequestBody User user) {
		System.out.println("POST METHOD");
		System.out.println(user);
	}
}
