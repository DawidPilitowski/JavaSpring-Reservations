package com.dawid.reservation.service;

import com.dawid.reservation.model.ReservationEvent;
import com.dawid.reservation.repository.ReservationEventRepository;
import com.dawid.reservation.model.ReservationEvent;
import com.dawid.reservation.repository.ReservationEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationEventService {

    // powiązuje repozytorium
    @Autowired
    private ReservationEventRepository reservationEventRepository;

    // dodaje metode do dodawania wydarzenia
    public void add(ReservationEvent event) {
        // zapisuje nowe wydarzenie
        reservationEventRepository.save(event);
    }

    public List<ReservationEvent> getAllEvents() {
        return reservationEventRepository.findAll();
    }

    public void removeEvent(Long id) {
        reservationEventRepository.deleteById(id);
    }

    public Optional<ReservationEvent> find(Long id) {
        return reservationEventRepository.findById(id);
    }
}
