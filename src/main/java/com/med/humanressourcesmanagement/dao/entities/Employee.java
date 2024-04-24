package com.med.humanressourcesmanagement.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private double salary;
    @ManyToOne
    private Department department;
    @OneToOne
    private Position position;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private Collection<LeaveRequest> leaveRequests = new ArrayList<>();
}
