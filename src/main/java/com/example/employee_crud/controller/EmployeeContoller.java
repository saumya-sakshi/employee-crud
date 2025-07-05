package com.example.employee_crud.controller;

import com.example.employee_crud.Entity.Employee;
import com.example.employee_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeContoller {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeBYId(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp){
        return employeeService.createEmployee(emp);
    }

    @PutMapping
    public Employee updateEmployee(@RequestParam Long id, @RequestBody Employee emp ){
        return employeeService.updateEmployee(id,emp);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}
