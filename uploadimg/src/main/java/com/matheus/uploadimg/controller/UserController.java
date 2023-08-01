package com.matheus.uploadimg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.matheus.uploadimg.model.User;
import com.matheus.uploadimg.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	 @GetMapping
	 public ResponseEntity<List<User>> getAllUsers() {
		 return ResponseEntity.ok(userService.getAllUsers());
	 }
	 
	 @PostMapping
	 public ResponseEntity<User> createUser(@RequestParam("file") MultipartFile file, @RequestParam("username") String username, @RequestParam("email") String email) throws Exception {
		 return new ResponseEntity<>(userService.createUser(file, username, email), HttpStatus.CREATED);
	 }
}
