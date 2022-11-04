package com.UST.hib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UST.hib.dao.PersonDao;
import com.UST.hib.model.Person;

@RestController
@RequestMapping("/spring-hib")
public class PersonController {
	
	@Autowired
	private PersonDao persondao;
	
	@PostMapping("/savePerson")
	public String save(@RequestBody Person person) {
		persondao.savePerson(person);
		return "ok saved";		
	}
	
	@GetMapping("/getPerson")
	public List<Person> getAllPersons(){
		return persondao.getPersons();
		
	}
	

}
