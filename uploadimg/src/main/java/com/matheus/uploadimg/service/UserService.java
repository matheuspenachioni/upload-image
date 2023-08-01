package com.matheus.uploadimg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.matheus.uploadimg.model.User;
import com.matheus.uploadimg.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User createUser(MultipartFile file, String username, String email) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPhoto(file.getBytes());
        return userRepository.save(user);
    }
	
}
