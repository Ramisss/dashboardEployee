package com.example.myappemployeeserver.service;

import com.example.myappemployeeserver.entity.ApiResponse;
import com.example.myappemployeeserver.entity.Employee;
import com.example.myappemployeeserver.exeptions.ResourseNotFoundExeption;
import com.example.myappemployeeserver.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public ApiResponse saveEmp(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourseNotFoundExeption("notfond" + id));
        employeeRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }


    public ApiResponse delete(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourseNotFoundExeption("notfond" + id));
        employeeRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }

    public ApiResponse edit(Long id, Employee employee) {

        Employee employee1 = employeeRepository.findById(id).orElseThrow(() -> new ResourseNotFoundExeption("dfsdf" + id));
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        employeeRepository.save(employee1);
        return new ApiResponse("edited ", true, employee);
    }

    public ApiResponse addEmploye(Employee employee) {
        if (employee.getEmail().equals(null)){
            return new ApiResponse("enter name" ,false);
        }
        Employee employee1= new Employee();
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        employeeRepository.save(employee1);
        return new ApiResponse("saved",true);
    }
}
