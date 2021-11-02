package com.project.capsback.domain;

import com.project.capsback.entity.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservationResponse {
    private int boardingTime;
    private String boardingPosition;
    private String dropOffPosition;

    @Builder
    public ReservationResponse(int boardingTime, String boardingPosition, String dropOffPosition){
        this.boardingPosition=boardingPosition;
        this.boardingTime=boardingTime;
        this.dropOffPosition=dropOffPosition;
    }

    public static ReservationResponse from(Reservation reservation) {
        ReservationResponse reservationResponse = ReservationResponse.builder()
                .boardingPosition(reservation.getBoardingPosition())
                .boardingTime(reservation.getBoardingTime())
                .dropOffPosition(reservation.getDropOffPosition())
                .build();

        return reservationResponse;
    }
}
