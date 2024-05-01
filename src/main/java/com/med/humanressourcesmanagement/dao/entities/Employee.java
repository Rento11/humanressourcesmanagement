package com.med.humanressourcesmanagement.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee extends User{
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private double salary;
    @ManyToOne
    private Department department;
    @OneToOne
    private Position position;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private Collection<LeaveRequest> leaveRequests = new ArrayList<>();
}
