package com.matheus.uploadimg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheus.uploadimg.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
