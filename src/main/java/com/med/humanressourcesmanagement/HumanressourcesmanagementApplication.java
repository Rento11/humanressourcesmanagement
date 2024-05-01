package com.med.humanressourcesmanagement;

import com.med.humanressourcesmanagement.dao.entities.Department;
import com.med.humanressourcesmanagement.dao.entities.LeaveRequest;
import com.med.humanressourcesmanagement.dao.entities.Position;
import com.med.humanressourcesmanagement.service.DepartmentManager;
import com.med.humanressourcesmanagement.service.LeaveRequestManager;
import com.med.humanressourcesmanagement.service.PositionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HumanressourcesmanagementApplication {
    @Autowired
    DepartmentManager departmentManager;
    @Autowired
    PositionManager positionManager;
    @Autowired
    LeaveRequestManager leaveRequestManager;

    public static void main(String[] args) {
        SpringApplication.run(HumanressourcesmanagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(){
        return args -> {
            Department department1 = new Department(null,"Finance","Finance department description",null);
            Department department2 = new Department(null,"Audit","Audit department description",null);
            Department department3 = new Department(null,"Marketing","Marketing department description",null);
            Department department4 = new Department(null,"Production","Production department description",null);
            Department department5 = new Department(null,"Administration","Administration department description",null);
            Department department6 = new Department(null,"PURCHASE  ","Purchase department description",null);
            departmentManager.addDepartment(department1);
            departmentManager.addDepartment(department2);
            departmentManager.addDepartment(department3);
            departmentManager.addDepartment(department4);
            departmentManager.addDepartment(department5);
            departmentManager.addDepartment(department6);
            Position position1 = new Position(null,"FINANCE Manager","Responsible for financial planning and reporting.",null);
            Position position2 = new Position(null,"Senior Auditor","Conduct audits and ensure compliance with regulations.",null);
            Position position3 = new Position(null,"Marketing Specialist","Develop marketing strategies and execute campaigns.",null);
            Position position4 = new Position(null,"Production Supervisor","Oversee production activities and ensure efficiency.",null);
            positionManager.addPosition(position1);
            positionManager.addPosition(position2);
            positionManager.addPosition(position3);
            positionManager.addPosition(position4);

            LeaveRequest leaveRequest1 = new LeaveRequest(null, LocalDate.of(2024,05,01),LocalDate.of(2024,05,10),"pending",null);
            LeaveRequest leaveRequest2 = new LeaveRequest(null, LocalDate.of(2024,05,01),LocalDate.of(2024,05,10),"pending",null);
            LeaveRequest leaveRequest3 = new LeaveRequest(null, LocalDate.of(2024,05,01),LocalDate.of(2024,05,10),"pending",null);
            LeaveRequest leaveRequest4 = new LeaveRequest(null, LocalDate.of(2024,05,01),LocalDate.of(2024,05,10),"pending",null);
            leaveRequestManager.addLeaveRequest(leaveRequest1);
            leaveRequestManager.addLeaveRequest(leaveRequest2);
            leaveRequestManager.addLeaveRequest(leaveRequest3);
            leaveRequestManager.addLeaveRequest(leaveRequest4);
        };
    }
}
