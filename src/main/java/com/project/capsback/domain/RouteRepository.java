package com.project.capsback.domain;

import com.project.capsback.entity.BusAssignment;
import com.project.capsback.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
    List<Route> findAllByBusAssignment(BusAssignment busAssignment);
}
