package com.dawid.reservation.repository;

import com.dawid.reservation.model.ReservationEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationEventRepository extends JpaRepository<ReservationEvent, Long> {
}
