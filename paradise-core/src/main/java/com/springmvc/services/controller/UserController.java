package com.springmvc.services.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmvc.services.model.User;
import com.springmvc.services.service.UserService;
import com.springmvc.services.util.JSONUtilAction;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
@Api(tags = "用户信息接口")
@RequestMapping("/user")
public class UserController extends JSONUtilAction{
	public UserService userService;
    
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setSchoolservice(UserService schoolservice) {
		this.userService = schoolservice;
	}


	@RequestMapping(value = "/userList", produces = "application/json;charset=UTF-8")
	@ResponseBody
 public void queryDate(HttpServletRequest request, HttpServletResponse response) {
		
        List<User> list = userService.select();
        if(list != null && list.size()>0){
	        ObjectMapper mapper = new ObjectMapper();
	        String result="";
			try {
				result = mapper.writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			writeJSONStringToResponse(response,result); 
        }
       
    }
	@RequestMapping(value = "/index", produces = "application/json;charset=UTF-8")
	@ResponseBody
 public ModelAndView queryschool(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("schoollist");
	
		
        List<User> list = userService.select();
    	model.addObject("schoollist", list);
    
    	return model;
    }

	@RequestMapping(value = "/index1", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ModelAndView queryschool2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView model = new ModelAndView();
		model.setViewName("schoollist1");
	
		
        List<User> list = userService.select();
    	model.addObject("schoollist1", list);
    	return model;
    }
	
	
}
