package com.dawid.reservation.service;

import com.dawid.reservation.model.AppUser;
import com.dawid.reservation.model.RegisterAppUserDTO;
import com.dawid.reservation.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AppUserRepository appUserRepository;

    public boolean registerUser(RegisterAppUserDTO dto) {
        // 1. czy istnieje uzytkownik o takim username
        Optional<AppUser> appUser = appUserRepository.findByUsername(dto.getUsername());
        if (appUser.isPresent()) {
            // istnieje
            return false;
        }
        AppUser nowyUzytkownik = new AppUser(dto.getUsername(),
                bCryptPasswordEncoder.encode(dto.getPassword()));

        appUserRepository.save(nowyUzytkownik);

        return true;
    }
}
