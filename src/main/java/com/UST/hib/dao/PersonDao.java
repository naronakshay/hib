package com.UST.hib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.UST.hib.model.Person;

public class PersonDao {
	
	@Autowired
	private SessionFactory factory;

	public void savePerson(Person person) {
		getSession().save(person);
		
	}

	private Session getSession() {
		Session session = factory.getCurrentSession();
		if(session==null) {
			session = factory.openSession();
		}
		return session;
	}

	
	@SuppressWarnings({"deprecation","unchecked"})
	public List<Person> getPersons() {
		
		return getSession().createCriteria(Person.class).list();
	}

}
