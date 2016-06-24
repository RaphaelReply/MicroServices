package com.sap.hcp.cf.tutorials.mongodb;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sap.hcp.cf.tutorials.mongodb.model.Customer;

@RestController
@RequestMapping("/")
public class RootController {

	private static final Logger log = LoggerFactory.getLogger(RootController.class);

	@Autowired
	MongoTemplate mongoTemplate;

	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> getCustomer() {

		List<Customer> dbObjects = mongoTemplate.findAll(Customer.class);
		return dbObjects;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createCustomer(@RequestBody Customer inputCustomer) throws AppException {

		if (inputCustomer == null)
			throw new AppException(HttpStatus.BAD_REQUEST, // 400
					"No creation possible", "The customers was null, so no customer was given via JSON as input");

		inputCustomer.setActive(true);
		inputCustomer.setCustomerId(generateId());

		mongoTemplate.save(inputCustomer);

		List<Customer> dbObjects = new ArrayList<Customer>();
		dbObjects.add(inputCustomer);

		HttpHeaders headers = new HttpHeaders();
		try {
			headers.setLocation(new URI("/customers/" + inputCustomer.getCustomerId()));
		} catch (URISyntaxException e) {
			log.error("Invalid URI. Customer id is not valid.", e);
		}
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCustomer() {

		mongoTemplate.dropCollection(Customer.class);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	private long generateId() {
		return (long) (Math.random() * Math.pow(10, 10));
	}

	@ExceptionHandler({ AppException.class })
	public ResponseEntity<String> handleAppException(AppException e) {
		return new ResponseEntity<String>(e.getMessage() + " " + e.getDeveloperMessage(), e.getHttp_status_code());
	}
}
