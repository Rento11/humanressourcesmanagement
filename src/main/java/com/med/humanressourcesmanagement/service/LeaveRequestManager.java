package com.med.humanressourcesmanagement.service;

import com.med.humanressourcesmanagement.dao.entities.LeaveRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LeaveRequestManager {
    public LeaveRequest addLeaveRequest(LeaveRequest leaveRequest);
    public LeaveRequest updateLeaveRequest(LeaveRequest leaveRequest);
    public boolean deleteLeaveRequest(LeaveRequest leaveRequest);
    public boolean deleteLeaveRequestById(Integer leaveRequestId);
    public LeaveRequest getLeaveRequestById(Integer leaveRequestId);
    public List<LeaveRequest> getAllLeaveRequests();
    public Page<LeaveRequest> getLeaveRequestsByLeaveId(int page, int taille);
    public Page<LeaveRequest> searchLeaveRequestByLeaveStatus(String leaveStatus, int page, int taille);
}
