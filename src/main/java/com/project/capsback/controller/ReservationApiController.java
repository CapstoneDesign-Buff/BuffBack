package com.project.capsback.controller;

import com.project.capsback.domain.ReservationRequest;
import com.project.capsback.domain.ReservationResponse;
import com.project.capsback.entity.Reservation;
import com.project.capsback.service.ReservationCreateService;
import com.project.capsback.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {

    private final ReservationService reservationService;
    private final ReservationCreateService reservationCreateService;

    private HttpServletRequest request;

    HttpSession httpSession = request.getSession(false);
    String userId=httpSession.getAttribute("LoginUser").toString();

    public ReservationApiController(final ReservationService reservationService,
                                    final ReservationCreateService reservationCreateService){
        this.reservationService=reservationService;
        this.reservationCreateService=reservationCreateService;
    }
    @GetMapping
    public List<Reservation> showAllReservation(){ //전체 사용자의 예약 내역 조회
       return reservationService.findReservationByAll();
    }

    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(@RequestBody ReservationRequest reservationRequest){//예약 생성
        ReservationResponse reservationResponse=reservationCreateService.create(reservationRequest);
        reservationResponse.setUserId(userId);
        return ResponseEntity.ok().body(reservationResponse);
    }

    @GetMapping("/{id}")
    public List<Reservation> showReservation(@PathVariable String id){ //특정 사용자의 예약 목록 조회
        return reservationService.findReservationById(id);
    }

    @PutMapping("/{id}")
    public String updateReservation(@PathVariable String id,@RequestBody ReservationRequest reservationRequest){
        reservationService.update(id,reservationRequest);
        return id;
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<ReservationResponse> deleteReservation(@PathVariable Long idx){
        reservationService.delete(idx);
        return ResponseEntity.noContent().build();
    }
}
