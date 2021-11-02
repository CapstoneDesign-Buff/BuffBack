package com.project.capsback.service;

import com.project.capsback.domain.ReservationRepository;
import com.project.capsback.domain.ReservationRequest;
import com.project.capsback.domain.UserRepository;
import com.project.capsback.entity.Reservation;
import com.project.capsback.entity.User;
import com.project.capsback.exception.ReservationDeleteException;
import com.project.capsback.exception.SignUpException;
import com.project.capsback.exception.UserDeleteException;
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
    private final UserRepository userRepository;

    public ReservationService(final ReservationRepository reservationRepository,
                              final UserRepository userRepository){
        this.reservationRepository=reservationRepository;
        this.userRepository=userRepository;
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

    public List<Reservation> findReservationById(String userId) {
        if(reservationRepository.findReservationByUser(userId).isEmpty())
            throw new EntityNotFoundException(NOT_FOUND_RESERVATION_MESSAGE);

        return reservationRepository.findReservationByUser(userId);
    }

    public List<Reservation> findReservationByAll(){
        return reservationRepository.findAll();
    }

    public String update(String id, ReservationRequest reservationRequest) {
        User user=userRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        Reservation reservation = reservationRepository.findByUser(user).orElseThrow(
                () -> new IllegalArgumentException("예약이 존재하지 않습니다.")
        );
        reservation.update(reservationRequest);
        return reservation.getUser().getUserId();
    }

    public void delete(final Long idx) {
        try {
            reservationRepository.deleteById(idx);
        } catch (Exception e) {
            throw new ReservationDeleteException();
        }
    }

}
