package com.dawid.reservation.controller;

import com.dawid.reservation.model.CreateReservationDTO;
import com.dawid.reservation.model.Reservation;
import com.dawid.reservation.model.ReservationEvent;
import com.dawid.reservation.service.ReservationEventService;
import com.dawid.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/reservation/")
public class ReservationController {

    @Autowired
    private ReservationEventService reservationEventService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping(path = "/add")
    public String add(Model model) {
        CreateReservationDTO reservation = new CreateReservationDTO();

        List<ReservationEvent> events = reservationEventService.getAllEvents();

        model.addAttribute("reservation", reservation);
        model.addAttribute("events", events);

        return "reservationAdd";
    }

    @PostMapping(path = "/add")
    public String add(CreateReservationDTO reservation) {
        reservationService.addReservation(reservation);

        return "redirect:/event/add";
    }

    @GetMapping(path = "/list")
    public String list(Model model) {
        List<Reservation> reservations = reservationService.getReservations();

        model.addAttribute("reservationList", reservations);

        return "reservationList";
    }

    @GetMapping(path = "/details/{id}")
    public String details(@PathVariable(name = "id") Long id,
                          Model model) {
        Optional<Reservation> reservationOptioanl = reservationService.find(id);
        if (reservationOptioanl.isPresent()) {
            model.addAttribute("reservation", reservationOptioanl.get());
            return "reservationDetails";
        }

        return "redirect:/error";
    }

    @PostMapping(path = "/save")
    public String save(Reservation reservation) {
        reservationService.saveReservation(reservation);

        return "redirect:/reservation/list";
    }

    @GetMapping(path = "/about")
    public String about(@PathVariable(name = "id") Long id, Model model) {
        Optional<Reservation> reservationOptional = reservationService.find(id);
        if (reservationOptional.isPresent()) {
            model.addAttribute("reservation", reservationOptional.get());
            return "reservationDetails";
        }
        return "redirect:/error";

    }
    @GetMapping(path = "/remove/{id}")
    public String remove(@PathVariable(name = "id") Long id) {
        reservationService.removeReservation(id);

        return "redirect:/reservation/list";
    }
}
