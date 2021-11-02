package com.project.capsback.controller;

import com.project.capsback.entity.Reservation;
import com.project.capsback.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {

    private final ReservationService reservationService;

    public ReservationApiController(final ReservationService reservationService){this.reservationService=reservationService;}
    @GetMapping
    public List<Reservation> showAllReservation(){ //전체 사용자의 예약 내역 조회
       return reservationService.findReservationByAll();
    }

}
