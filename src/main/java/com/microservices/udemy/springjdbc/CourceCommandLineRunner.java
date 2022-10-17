package com.microservices.udemy.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.microservices.udemy.springjdbc.entity.Course;

@Component
public class CourceCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourceJdbdRepositoty courceJdbdRepositoty;

	@Autowired
	private SpringJdbcUsingEntityManager springJdbcUsingEntityManager;
	@Override
	public void run(String... args) throws Exception {
		courceJdbdRepositoty.insert(new Course(1, "Learn Spring JDBC", "udemy"));
		courceJdbdRepositoty.insert(new Course(2, "Learn Spring JPA", "udemy"));
		courceJdbdRepositoty.insert(new Course(3, "Learn Spring JPA", "udemy"));

		courceJdbdRepositoty.deletByid(1);
		System.out.println(courceJdbdRepositoty.selectByid("Learn Spring JPA"));
		
		springJdbcUsingEntityManager.insert(new Course(1, "Learn Spring JDBC", "udemy"));
	}

}
