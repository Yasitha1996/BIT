package com.rest.restAPI.app.repo;

import com.rest.restAPI.app.mapping.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<Jobs, Integer> {

}
