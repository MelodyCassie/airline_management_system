package com.example.airlineManagementSystem.data.repositories;


import com.example.airlineManagementSystem.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmailAddress(String emailAddress);
}
