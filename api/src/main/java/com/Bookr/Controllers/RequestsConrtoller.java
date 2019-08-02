/**
 * 
 */
package com.Bookr.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bookr.Entities.Request;
import com.Bookr.Entities.Reservation;
import com.Bookr.Services.RequestsService;
import com.Bookr.Services.ReservationService;

/**
 * @author lowbl
 *
 */

@RestController
@RequestMapping("/api/requests")
@CrossOrigin("http://localhost:8000")
public class RequestsConrtoller {
	@Autowired
	private RequestsService requestsService;
	
	@PostMapping("/create_request")
	public ResponseEntity<?> createNewRequest(@Valid @RequestBody Request requests) 
	{
		Request new_requests = requestsService.saveOrUpdateRequest(requests);
		return new ResponseEntity<Request>(new_requests, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public Iterable<Request> getAllRequests()
	{
		return requestsService.findAll();
	}
	
	@GetMapping("/{request_id}")
	public ResponseEntity<?> getRequestById(@PathVariable Integer request_id)
	{
		Request request = requestsService.getById(request_id);
		return new ResponseEntity<Request>(request, HttpStatus.OK);
	}
}
