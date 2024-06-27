package com.med.humanressourcesmanagement.service;

import com.med.humanressourcesmanagement.dao.entities.Employee;
import com.med.humanressourcesmanagement.dao.entities.LeaveRequest;
import com.med.humanressourcesmanagement.dao.repositories.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaveRequestManagerImplementation implements LeaveRequestManager {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Override
    public LeaveRequest addLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    @Override
    public LeaveRequest updateLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    @Override
    public boolean deleteLeaveRequest(LeaveRequest leaveRequest) {
        try{
            leaveRequestRepository.delete(leaveRequest);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteLeaveRequestById(Integer leaveRequestId) {
        try{
            leaveRequestRepository.deleteById(leaveRequestId);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public LeaveRequest getLeaveRequestById(Integer leaveRequestId) {
        return leaveRequestRepository.findById(leaveRequestId).get();
    }

    @Override
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    @Override
    public Page<LeaveRequest> getLeaveRequestsByLeaveId(int page, int taille) {
        return leaveRequestRepository.findAll(PageRequest.of(page, taille));
    }

    @Override
    public Page<LeaveRequest> searchLeaveRequestByLeaveStatus(String keyword, int page, int taille) {
        return leaveRequestRepository.findLeaveRequestsByStatusContainingIgnoreCase(keyword, PageRequest.of(page,taille));
    }

}