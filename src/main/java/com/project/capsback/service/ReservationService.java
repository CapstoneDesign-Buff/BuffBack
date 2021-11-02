package com.project.capsback.service;

import com.project.capsback.domain.ReservationRepository;
import com.project.capsback.domain.ReservationRequest;
import com.project.capsback.entity.Reservation;
import com.project.capsback.entity.User;
import com.project.capsback.exception.SignUpException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class ReservationService {
    public static final String NOT_FOUND_USER_MESSAGE = "유저를 찾을수 없습니다.";
    public static final String NOT_FOUND_RESERVATION_MESSAGE="예약을 찾을수 없습니다.";

    private final ReservationRepository reservationRepository;

    public ReservationService(final ReservationRepository reservationRepository){
        this.reservationRepository=reservationRepository;
    }

    @Transactional(readOnly = true)
    public Reservation findById(final Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_FOUND_RESERVATION_MESSAGE));
    }

    public Reservation save(final ReservationRequest reservationRequest) {
        try {
            return reservationRepository.save(reservationRequest.toEntity());
        } catch (Exception e) {
            throw new SignUpException(e.getMessage());
        }


    }

    public List<Reservation> findReservationById(User user) {
        return reservationRepository.findReservationByUser(user);
    }

    public List<Reservation> findReservationByAll(){
        return reservationRepository.findAll();
    }

}
