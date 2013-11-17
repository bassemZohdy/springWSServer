package org.spring.test.endpoint;

import org.spring.test.service.PersonService;
import org.spring.test.www.GetPersonRequest;
import org.spring.test.www.GetPersonResponse;
import org.spring.test.www.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GetPersonEndPoint {

	@Autowired
	PersonService service;

	@PayloadRoot(localPart = "getPersonRequest", namespace = "http://www.example.org/person")
	public @ResponsePayload
	GetPersonResponse get(@RequestPayload GetPersonRequest pRequest) {
		System.out.println("call get " + pRequest.getId());
		Person p = service.get(pRequest.getId());
		System.out.println("Person " + p);
		GetPersonResponse res = new GetPersonResponse();
		res.setPerson(p);
		return res;
	}

}
