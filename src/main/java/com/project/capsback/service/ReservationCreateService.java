package com.project.capsback.service;

import com.project.capsback.domain.ReservationRequest;
import com.project.capsback.domain.ReservationResponse;
import com.project.capsback.entity.Reservation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationCreateService {
    private final ReservationService reservationService;
    public ReservationCreateService(final ReservationService reservationService){ this.reservationService=reservationService;}

    public ReservationResponse create(ReservationRequest reservationRequest){
        Reservation reservation=reservationService.save(reservationRequest);
        return ReservationResponse.from(reservation);
    }
}
