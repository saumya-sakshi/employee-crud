package com.example.employee_crud.service;

import com.example.employee_crud.Entity.Employee;
import com.example.employee_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repo){
        this.repository=repo;
    }

    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    public Employee getEmployeeById(Long Id)
    {
        return repository.findById(Id).orElseThrow(()->new RuntimeException("Employee with Id"+ Id +" found"));
    }
    public Employee createEmployee(Employee emp)
    {
        return repository.save(emp);
    }
    public Employee updateEmployee(Long Id,Employee newEmp)
    {
        Employee emp = getEmployeeById(Id);
        emp.setDepartment(newEmp.getDepartment());
        emp.setName(newEmp.getName());
        emp.setSalary(newEmp.getSalary());

        return repository.save(emp);
    }

    public void deleteEmployee(Long id){
        repository.deleteById(id);
    }
}
