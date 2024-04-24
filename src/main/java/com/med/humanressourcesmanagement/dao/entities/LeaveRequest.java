package com.med.humanressourcesmanagement.dao.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    @ManyToOne
    private Employee employee;
}
