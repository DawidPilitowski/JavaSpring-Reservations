package com.dawid.reservation.service;

import com.dawid.reservation.model.CreateReservationDTO;
import com.dawid.reservation.model.Reservation;
import com.dawid.reservation.model.ReservationEvent;
import com.dawid.reservation.model.ReservationStatus;
import com.dawid.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationEventService reservationEventService;

    public void addReservation(CreateReservationDTO createReservationDTO) {
        Optional<ReservationEvent> eventOptional =
                reservationEventService.find(createReservationDTO.getEventId());

        if (eventOptional.isPresent()) {
            ReservationEvent event = eventOptional.get();

            Reservation reservation = new Reservation(null,
                    createReservationDTO.getParticipantName(),
                    event,
                    ReservationStatus.UNCONFIRMED);
            saveReservation(reservation);
        }
        // TODO: 8/6/18 Brak obsługi wyjątku kiedy nie odnaleźliśmy eventu!
    }

    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> find(Long id) {
        return reservationRepository.findById(id);
    }

    public void removeReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
