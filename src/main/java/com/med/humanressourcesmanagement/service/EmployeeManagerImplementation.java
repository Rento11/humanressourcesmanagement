package com.med.humanressourcesmanagement.service;

import com.med.humanressourcesmanagement.dao.entities.Employee;
import com.med.humanressourcesmanagement.dao.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManagerImplementation implements EmployeeManager{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        try{
            return employeeRepository.save(employee);
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        try{
            employeeRepository.delete(employee);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteEmployeeById(Integer id) {
        try{
            employeeRepository.delete(employeeRepository.findById(id).get());
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        try{
            employeeRepository.save(employee);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public Employee findEmployee(Employee employee) {
        try{
            return employeeRepository.findById(employee.getId()).get();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        try{
            return employeeRepository.findById(id).get();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        try{
            return employeeRepository.findAll();
        }catch(Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Page<Employee> getAllEmployees(int page, int taille) {
        return employeeRepository.findAll(PageRequest.of(page,taille));
    }

    @Override
    public Page<Employee> searchEmployees(String keyword, int page, int taille) {
        return employeeRepository.findEmployeeByFirstNameContaining(keyword, PageRequest.of(page, taille));
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).get();
    }

}
