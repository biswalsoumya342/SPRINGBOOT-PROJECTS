package com.soumya.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soumya.blogapp.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
