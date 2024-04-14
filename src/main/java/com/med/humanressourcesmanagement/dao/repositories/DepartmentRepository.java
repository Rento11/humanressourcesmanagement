package com.med.humanressourcesmanagement.dao.repositories;

import com.med.humanressourcesmanagement.dao.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
