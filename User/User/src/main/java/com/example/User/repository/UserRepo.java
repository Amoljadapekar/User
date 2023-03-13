package com.example.User.repository;

import com.example.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface UserRepo extends JpaRepository <User,Long> {
}
