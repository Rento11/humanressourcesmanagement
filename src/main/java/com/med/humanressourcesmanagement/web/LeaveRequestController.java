package com.med.humanressourcesmanagement.web;


import com.med.humanressourcesmanagement.dao.entities.Department;
import com.med.humanressourcesmanagement.dao.entities.LeaveRequest;
import com.med.humanressourcesmanagement.service.LeaveRequestManager;
import com.med.humanressourcesmanagement.service.LeaveRequestManagerImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class LeaveRequestController {
    @Autowired
    private LeaveRequestManager leaveRequestManager;

    @GetMapping("leaveRequestsList")
    public String leaveRequestsList(Model model, @RequestParam(name = "page", defaultValue = "0")int page,@RequestParam(name = "taille", defaultValue = "3")int taille, @RequestParam(name="search", defaultValue = "")String keyword ){
       Page<LeaveRequest> leaveRequests = leaveRequestManager.searchLeaveRequestByLeaveStatus(keyword,page,taille);
       model.addAttribute("leaveRequests", leaveRequests.getContent());
       int[] pages = new int[leaveRequests.getTotalPages()];
       for(int i = 0 ; i < leaveRequests.getTotalPages() ; i++){
           pages[i] = i;
       }
       model.addAttribute("pages", pages);
       model.addAttribute("page", page);
       model.addAttribute("keyword", keyword);
       return "leaveRequestsList";

    }

    @GetMapping("/addLeaveRequest")
    public String addLeaveRequest(Model model) {
        model.addAttribute("leaveRequest", new LeaveRequest());
        return "addLeaveRequest";
    }

    @PostMapping("/addLeaveRequest")
    public String addLeaveRequest(Model model, @Valid  LeaveRequest leaveRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addLeaveRequest";
        }
        leaveRequestManager.addLeaveRequest(leaveRequest);
        return "redirect:/leaveRequestsList";
    }


    @GetMapping("/deleteLeaveRequest")
    public String deleteLeaveRequest(Model model, @RequestParam(name ="id")Integer leaveId, Integer page, String search) {
        if(leaveRequestManager.deleteLeaveRequestById(leaveId)){
            return "redirect:/leaveRequestsList";
        }else{
            return "error";
        }
    }

    @GetMapping("/updateLeaveRequest")
    public String updateLeaveRequest(Model model, @RequestParam(name = "id") Integer leaveId) {
        LeaveRequest leaveRequest = leaveRequestManager.getLeaveRequestById(leaveId);
        if(leaveRequest != null){
            model.addAttribute("leaveRequest", leaveRequest);
            return "updateLeaveRequest";
        } else {
            return "error";
        }
    }

    @PostMapping("/updateLeaveRequest")
    public String updateLeaveRequest(Model model, @RequestParam(name = "id") Integer leaveId, @RequestParam(name = "status") String status, @RequestParam(name = "startDate") LocalDate startDate, @RequestParam(name="endDate") LocalDate endDate) {
        LeaveRequest leaveRequest = leaveRequestManager.getLeaveRequestById(leaveId);
        leaveRequest.setStatus(status);
        leaveRequest.setStartDate(startDate);
        leaveRequest.setEndDate(endDate);
        if (leaveRequest != null) {
            leaveRequestManager.updateLeaveRequest(leaveRequest);
            return "redirect:/leaveRequestsList";
        } else {
            return "error";
        }
    }


}
