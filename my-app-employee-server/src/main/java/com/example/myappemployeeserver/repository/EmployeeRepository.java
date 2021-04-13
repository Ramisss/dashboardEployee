package com.example.myappemployeeserver.repository;

import com.example.myappemployeeserver.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
