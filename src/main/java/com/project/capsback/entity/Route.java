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
    private String busStation;

    @Id
    private Date routeCoverageDate;

    @ManyToOne
    @JoinColumn(name = "routeNumber",referencedColumnName = "routeNumber")
    private BusAssignment busAssignment;

    @Column(nullable = false)
    private int arrivalTime;
}

