package com.pg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pg.entity.User;

public interface UserRepository extends JpaRepository< User, Integer>{

	User findByEmail(String email);
}
