package org.spring.test.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.spring.test.www.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	private Map<Long, Person> storage;
	private Long seq;

	@PostConstruct
	public void init() {
		storage = new HashMap<>();
		seq = new Long(1);
	}

	public Long create(Person p) {
		System.out.println("service.create");
		Long id = seq++;
		storage.put(id, p);
		return id;
	}

	public Person get(Long id) {
		System.out.println("service.get");
		System.out.println("storage "+ storage);
		return storage.get(id);
	}

}
