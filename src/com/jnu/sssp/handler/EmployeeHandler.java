package com.jnu.sssp.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jnu.sssp.entity.Employee;
import com.jnu.sssp.service.EmployeeService;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeService employeeService;

//	@Autowired
//	private DepartmentService departmentService;
	
//	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
//	public String delete(@PathVariable("id") Integer id){
//		employeeService.delete(id);
//		return "redirect:/emps";
//	}
//	
//	@ModelAttribute
//	public void getEmployee(@RequestParam(value="id",required=false) Integer id,
//			Map<String,Object> map){
//		if(id!=null){
//			Employee employee=employeeService.get(id);
//			employee.setDepartment(null);
//			map.put("employee", employee);
//		}
//	}
//	
//	@RequestMapping(value="/emp/{id}",method=RequestMethod.PUT)
//	public String update(Employee employee){
//		employeeService.save(employee);
//		return "redirect:/emps";
//	}
//	
//	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
//	public String get(@PathVariable("id") Integer id,Map<String,Object> map){
//		Employee employee=employeeService.get(id);
//		map.put("employee", employee);
//		map.put("departments", departmentService.getAll());
//		return "emp/input";
//	}
//	
//	@RequestMapping(value="/emp",method=RequestMethod.POST)
//	public String save(Employee employee){
//		employeeService.save(employee);
//		return "redirect:/emps";
//	}
//	
//	
//	@ResponseBody
//	@RequestMapping(value="/ajaxValidateLastName", method=RequestMethod.POST)
//	public String validateLastName(@RequestParam(value="lastName",required=false) String lastName){
//		Employee employee=employeeService.getByLaatName(lastName);
//		if(employee!=null){
//			return "1";
//		}else{
//			return "0";
//		}
//	}
//	
//	@RequestMapping(value="/emp", method=RequestMethod.GET)
//	public String input(Map<String,Object> map){
//		map.put("departments", departmentService.getAll());
//		map.put("employee",new Employee());
//		return "emp/input";
//	}
//	
	
	
	
	@RequestMapping("/emps")
	public String list(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNoStr,
			Map<String, Object> map) {
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pageNoStr);
			if (pageNo < 1) {
				pageNo = 1;
			}
		} catch (Exception e) {
		}

		Page<Employee> page = employeeService.getPage(pageNo, 6);
		map.put("page", page);
		return "emp/list";
	}

}
