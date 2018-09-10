package com.dawid.reservation.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;

    private String name;

    public AppUser() {
    }

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @OneToMany
    private List<Reservation> reservations;
}