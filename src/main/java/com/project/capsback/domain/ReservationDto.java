package com.project.capsback.domain;

import com.project.capsback.entity.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservationDto {
    int boardingTime;
    String boardingPosition;
    String dropOffPosition;

    @Builder
    public ReservationDto(int boardingTime,String boardingPosition,String dropOffPosition){
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
