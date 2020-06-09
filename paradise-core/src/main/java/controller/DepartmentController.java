package controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springmvc.services.model.Department;
import com.springmvc.services.service.DepartmentService;
import com.springmvc.util.JSONUtilAction;

import io.swagger.annotations.Api;

@Controller
@Api(tags = "部门信息接口")
@RequestMapping("/department")
public class DepartmentController extends JSONUtilAction {
	public DepartmentService departmentService;

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	@Autowired
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@RequestMapping(value = "/departmentList", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void queryDate(HttpServletRequest request, HttpServletResponse response) {

		List<Department> list = departmentService.select();
		if (list != null && list.size() > 0) {
			ObjectMapper mapper = new ObjectMapper();
			String result = "";
			try {
				result = mapper.writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			writeJSONStringToResponse(response, result);
		}

	}

}
