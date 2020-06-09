package com.springmvc.dao;

import com.springmvc.services.model.Department;

import java.util.List;

public interface DepartmentDao {
	 List<Department> queryDepartment();
}
