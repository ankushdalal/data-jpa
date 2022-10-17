package com.microservices.udemy.springjdbc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservices.udemy.springjdbc.entity.Course;

@Repository
@Transactional
public class SpringJdbcUsingEntityManager {

	@PersistenceContext
	private EntityManager entityManager;

	public void insert(Course course) {
		entityManager.merge(course);
	}
}
