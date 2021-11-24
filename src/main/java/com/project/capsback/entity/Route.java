package com.project.capsback.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Route implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long RouteIdx;

    private String busStation;

    @Column(nullable = false)
    private Date routeCoverageDate;

    @OneToOne
    @JoinColumn(name = "routeNumber",referencedColumnName = "routeNumber",nullable = false)
    private BusAssignment busAssignment;

    @Column(nullable = false)
    private int arrivalTime;
}

