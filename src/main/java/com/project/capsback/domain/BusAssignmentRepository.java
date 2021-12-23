package com.project.capsback.domain;

import com.project.capsback.entity.BusAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusAssignmentRepository extends JpaRepository<BusAssignmentRepository,Long> {
    @Query()
    BusAssignment findByRouteNumber(Long id);

}