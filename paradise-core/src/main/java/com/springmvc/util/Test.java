package com.springmvc.util;

import com.springmvc.services.model.User;
import com.springmvc.services.service.UserService;

import java.util.List;

public class Test {
	public UserService schoolservice;
	
	public UserService getSchoolservice() {
		return schoolservice;
	}

	public void setSchoolservice(UserService schoolservice) {
		this.schoolservice = schoolservice;
	}

	public static void main(String[] args) {
		Test tes=new Test();
		tes.show();
	}
	public void show(){
			
	  List<User>	list  = schoolservice.select();
	 for (User school : list) {
		System.out.println(school.toString());
	}
		
	}

}
