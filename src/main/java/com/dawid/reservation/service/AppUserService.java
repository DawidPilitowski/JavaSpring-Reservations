package com.dawid.reservation.service;

import com.dawid.reservation.model.RegisterAppUserDTO;
import com.dawid.reservation.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AppUserRepository appUserRepository;

    public boolean registerUser(RegisterAppUserDTO dto) {
        return false;
    }
}
