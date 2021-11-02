package com.project.capsback.domain;

import com.project.capsback.entity.Reservation;
import com.project.capsback.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ReservationRequest {
    private int boardingTime;
    private String boardingPosition;
    private String dropOffPosition;

    @Builder
    public ReservationRequest(int boardingTime, String boardingPosition, String dropOffPosition){
        this.boardingPosition=boardingPosition;
        this.boardingTime=boardingTime;
        this.dropOffPosition=dropOffPosition;
    }

    public Reservation toEntity(){
        return Reservation.builder()
                .boardingPosition(boardingPosition)
                .boardingTime(boardingTime)
                .dropOffPosition(dropOffPosition)
                .build();
    }


}
