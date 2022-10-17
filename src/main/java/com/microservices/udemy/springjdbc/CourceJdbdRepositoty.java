package com.microservices.udemy.springjdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourceJdbdRepositoty {

	@Autowired
	private JdbcTemplate springJdbcTemplate;

	private static String INSERT_QUERY = "insert into course values(?,?,?)";
	private static String DELETE_QUERY = "delete from course where id=?";
	private static String SELECT_QUERY = "select * from course where name=?";

	public void insert() {
		springJdbcTemplate.update(INSERT_QUERY);
	}

	public void insert(Course cource) {
		springJdbcTemplate.update(INSERT_QUERY, cource.getId(), cource.getName(), cource.getAuthor());
	}

	public void deletByid(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	public List<Course> selectByid(String name) {
		return springJdbcTemplate.query(SELECT_QUERY, new BeanPropertyRowMapper(Course.class),name);
	}
}
