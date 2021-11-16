package br.com.api.contatos.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.api.contatos.model.request.ContactRequestModel;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(value = "/v1/contact", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Contacts", description = "Service responsible for make the CR of contact")
@CrossOrigin
public class ContactsController {
	
	private List<ContactRequestModel> createdContactList = new ArrayList<>();
	
	@GetMapping
	public ResponseEntity<?> getAllContact() {
    	return new ResponseEntity<String>(new Gson().toJson(createdContactList), HttpStatus.OK);
    }
	
    @PostMapping
	public ResponseEntity<?> createContact(@RequestBody ContactRequestModel request) {
        createdContactList.add(request);
    	return new ResponseEntity<String>("Contact Created", HttpStatus.CREATED);
    }
}
