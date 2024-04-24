package com.med.humanressourcesmanagement.service;

import com.med.humanressourcesmanagement.dao.entities.Department;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DepartmentManager {
    public Department addDepartment(Department department);
    public boolean deleteDepartment(Department department);
    public boolean deleteDepartmentById(Integer id);
    public boolean updateDepartment(Department department);
    public Department findDepartment(Department department);
    public Department findDepartmentById(Integer id);
    public List<Department> getAllDepartments();
    public Page<Department> getAllDepartments(int page, int taille);
    public Page<Department> searchDepartments(String keyword, int page, int taille);
}
