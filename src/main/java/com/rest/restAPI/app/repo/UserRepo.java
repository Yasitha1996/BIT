package com.rest.restAPI.app.repo;

import com.rest.restAPI.app.mapping.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
