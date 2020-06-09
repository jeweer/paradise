package com.springmvc.services.impl;

import com.springmvc.services.dao.DepartmentDao;
import com.springmvc.services.model.Department;
import com.springmvc.services.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public List<Department> select() {
		List<Department> list =  departmentDao.queryDepartment();
		return list;
	}
	
	

}
