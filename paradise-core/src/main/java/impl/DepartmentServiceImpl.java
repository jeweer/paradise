package impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.services.dao.DepartmentDao;
import com.springmvc.services.dao.UserDao;
import com.springmvc.services.model.Department;
import com.springmvc.services.model.User;
import com.springmvc.services.service.DepartmentService;
import com.springmvc.services.service.UserService;

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
