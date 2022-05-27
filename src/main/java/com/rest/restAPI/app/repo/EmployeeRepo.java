package com.rest.restAPI.app.repo;

import com.rest.restAPI.app.mapping.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
