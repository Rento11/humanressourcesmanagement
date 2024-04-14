package com.med.humanressourcesmanagement.dao.repositories;

import com.med.humanressourcesmanagement.dao.entities.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {
}
