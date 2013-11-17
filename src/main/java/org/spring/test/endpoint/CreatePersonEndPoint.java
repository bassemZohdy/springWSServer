package org.spring.test.endpoint;

import org.spring.test.service.PersonService;
import org.spring.test.www.CreatePersonRequest;
import org.spring.test.www.CreatePersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CreatePersonEndPoint {

	@Autowired
	PersonService service;

	@PayloadRoot(localPart = "createPersonRequest", namespace = "http://www.example.org/person")
	public @ResponsePayload
	CreatePersonResponse create(@RequestPayload CreatePersonRequest req) {
		System.out.println("call create " + req.toString());
		Long id = service.create(req.getPerson());
		CreatePersonResponse res = new CreatePersonResponse();
		res.setId(id);
		return res;
	}

}
