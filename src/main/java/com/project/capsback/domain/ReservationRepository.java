package com.project.capsback.domain;

import com.project.capsback.entity.Reservation;
import com.project.capsback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    Optional<Reservation> findById(Long id);
    List<Reservation> findReservationByUser(String userId);

    Optional<Reservation> findByUser(User user);
}
