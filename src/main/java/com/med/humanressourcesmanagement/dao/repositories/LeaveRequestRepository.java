package com.med.humanressourcesmanagement.dao.repositories;

import com.med.humanressourcesmanagement.dao.entities.Employee;
import com.med.humanressourcesmanagement.dao.entities.LeaveRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {
    Page<LeaveRequest> findLeaveRequestsByStatusContainingIgnoreCase(String keyword, Pageable pageable);
}
