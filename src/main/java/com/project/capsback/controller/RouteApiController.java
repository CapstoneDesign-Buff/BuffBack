package com.project.capsback.controller;


import com.project.capsback.domain.BusAssignmentRepository;
import com.project.capsback.domain.RouteRepository;
import com.project.capsback.entity.BusAssignment;
import com.project.capsback.entity.Route;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteApiController {

    private final RouteRepository routeRepository;
    private final BusAssignmentRepository busAssignmentRepository;

    public RouteApiController(final RouteRepository routeRepository
                            ,final  BusAssignmentRepository busAssignmentRepository){
        this.busAssignmentRepository=busAssignmentRepository;
        this.routeRepository=routeRepository;
    }
    @GetMapping("/{id}")
    public List<Route> showRoute(@PathVariable Long id){
        BusAssignment busAssignment=busAssignmentRepository.findByRouteNumber(id);
        return routeRepository.findAllByBusAssignment(busAssignment);
    }
}
