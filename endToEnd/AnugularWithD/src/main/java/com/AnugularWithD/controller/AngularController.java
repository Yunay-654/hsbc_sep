package com.AnugularWithD.controller;
import com.AnugularWithD.entity.*;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnugularWithD.dao.AngularDaoInterface;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AngularController {
@Autowired
AngularDaoInterface di;


@GetMapping("/emp")
public List<Employee> viewProfile(){
	
	List<Employee> uu=new ArrayList<Employee>();
	uu=di.viewallProfileDAO();
	return uu;
}
@DeleteMapping(value="/emp/{email}")
public void deleteProfile(@PathVariable("email") String email) {
	di.deleteProfileDao(email);
}
@PostMapping("/emp")
public void createProfile(@RequestBody Employee e) {
	di.createProfileDao(e);
}
@PutMapping(value="/emp/{email}")
public void editProfile(@PathVariable("email") String email, @RequestBody Employee e) throws Exception{
	di.editProfileDao(email,e);
}
}
