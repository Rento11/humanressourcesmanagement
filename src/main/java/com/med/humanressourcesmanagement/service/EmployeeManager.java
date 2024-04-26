package com.med.humanressourcesmanagement.service;

import com.med.humanressourcesmanagement.dao.entities.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeManager {
    public Employee addEmployee(Employee employee);
    public boolean deleteEmployee(Employee employee);
    public boolean deleteEmployeeById(Integer id);
    public boolean updateEmployee(Employee employee);
    public Employee findEmployee(Employee employee);
    public Employee findEmployeeById(Integer id);
    public List<Employee> getAllEmployees();
    public Page<Employee> getAllEmployees(int page, int taille);
    public Page<Employee> searchEmployees(String keyword, int page, int taille);
}
