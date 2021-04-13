package com.example.myappemployeeserver.controller;


import com.example.myappemployeeserver.entity.ApiResponse;
import com.example.myappemployeeserver.entity.Employee;
import com.example.myappemployeeserver.repository.EmployeeRepository;
import com.example.myappemployeeserver.service.EmployeeService;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    //GET ALL EMPLOYEES
    @GetMapping
    public HttpEntity<?> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    //GET BY ID
    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(employeeRepository.findById(id));
    }

    //SAVE EMPLOYEE
    @PostMapping
    public HttpEntity<?> addEmployee(@Valid @RequestBody Employee employee) {
        ApiResponse response=employeeService.addEmploye(employee);
        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
    }
// DELETE EMPLOYEE
    @DeleteMapping("/{id}")
    public HttpEntity delete(@PathVariable Long id) {
        ApiResponse response = employeeService.delete(id);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }

    //EDIT EMPLOYEE
    @PutMapping("/{id}")
    public HttpEntity<?> editMaping(@PathVariable Long id,@RequestBody Employee employee){
        ApiResponse response=employeeService.edit(id,employee);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }


}
