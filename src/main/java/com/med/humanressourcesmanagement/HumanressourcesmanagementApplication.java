package com.med.humanressourcesmanagement;

import com.med.humanressourcesmanagement.dao.entities.Department;
import com.med.humanressourcesmanagement.service.DepartmentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HumanressourcesmanagementApplication {
    @Autowired
    DepartmentManager departmentManager;

    public static void main(String[] args) {
        SpringApplication.run(HumanressourcesmanagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(){
        return args -> {
            Department department1 = new Department(null,"FINANCE","FINANCE DEPARTMENT DESCRIPTION",null);
            Department department2 = new Department(null,"AUDIT","AUDIT DEPARTMENT DESCRIPTION",null);
            Department department3 = new Department(null,"MARKETING","MARKETING DEPARTMENT DESCRIPTION",null);
            Department department4 = new Department(null,"PRODUCTION","PRODUCTION DEPARTMENT DESCRIPTION",null);
            Department department5 = new Department(null,"ADMINISTRATION","ADMINISTRATION DEPARTMENT DESCRIPTION",null);
            Department department6 = new Department(null,"PURCHASE","PURCHASE DEPARTMENT DESCRIPTION",null);
            departmentManager.addDepartment(department1);
            departmentManager.addDepartment(department2);
            departmentManager.addDepartment(department3);
            departmentManager.addDepartment(department4);
            departmentManager.addDepartment(department5);
            departmentManager.addDepartment(department6);
        };
    }
}
