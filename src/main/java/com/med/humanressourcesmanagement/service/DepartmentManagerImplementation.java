package com.med.humanressourcesmanagement.service;

import com.med.humanressourcesmanagement.dao.entities.Department;
import com.med.humanressourcesmanagement.dao.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManagerImplementation implements DepartmentManager{
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Department addDepartment(Department department) {
        try{
            return departmentRepository.save(department);
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteDepartment(Department department) {
        try{
            departmentRepository.delete(department);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteDepartmentById(Integer id) {
        try{
            departmentRepository.delete(departmentRepository.findById(id).get());
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateDepartment(Department department) {
        try{
            departmentRepository.save(department);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public Department findDepartment(Department department) {
        try{
            return departmentRepository.findById(department.getId()).get();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Department findDepartmentById(Integer id) {
        try{
            return departmentRepository.findById(id).get();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        try{
            return departmentRepository.findAll();
        }catch(Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Page<Department> getAllDepartments(int page, int taille) {
        return departmentRepository.findAll(PageRequest.of(page,taille));
    }

    @Override
    public Page<Department> searchDepartments(String keyword, int page, int taille) {
        return departmentRepository.findDepartmentByNameContaining(keyword, PageRequest.of(page, taille));
    }

}
