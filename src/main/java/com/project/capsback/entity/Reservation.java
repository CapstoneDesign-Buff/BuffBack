package com.project.capsback.entity;

import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long reservationIdx;

    @Column(nullable = true)
    private int boardingTime;

    @Column(nullable = false)
    private String boardingPosition;

    @Column(nullable = false)
    private String dropOffPosition;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;

    @Builder
    public Reservation(int boardingTime,String boardingPosition,String dropOffPosition){

        this.boardingTime=boardingTime;
        this.boardingPosition=boardingPosition;
        this.dropOffPosition=dropOffPosition;
    }
}
