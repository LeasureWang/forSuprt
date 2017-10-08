package com.jnu.sssp.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jnu.sssp.entity.Department;
import com.jnu.sssp.repository.DepartmentRepository;

public class SSSPTest {

	private ApplicationContext ctx = null;
	private DepartmentRepository departmentRepository;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		departmentRepository = ctx.getBean(DepartmentRepository.class);
	}

	@Test
	public void testRepositorySecondLevelCache() {
		List<Department> departments = departmentRepository.findAll();
		departments=departmentRepository.findAll();
	}

	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
