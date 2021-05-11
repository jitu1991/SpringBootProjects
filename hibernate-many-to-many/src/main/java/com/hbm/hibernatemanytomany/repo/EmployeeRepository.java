package com.hbm.hibernatemanytomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hbm.hibernatemanytomany.model.Employee;
import com.hbm.hibernatemanytomany.model.Project;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}