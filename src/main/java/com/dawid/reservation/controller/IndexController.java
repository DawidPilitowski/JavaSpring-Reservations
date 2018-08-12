package com.dawid.reservation.controller;

import com.dawid.reservation.model.RegisterAppUserDTO;
import com.dawid.reservation.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IndexController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping(path = "/")
    public String index() {
        return "home";
    }

    @GetMapping(path = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(path = "/register")
    public String register(Model model) {
        model.addAttribute("user_dto", new RegisterAppUserDTO());
        return "userRegister";
    }

    @PostMapping(path = "/register")
    public String register(Model model, RegisterAppUserDTO dto) {
        if (!dto.getConfirm_password().equals(dto.getPassword())) {
            model.addAttribute("user_dto", dto);

            model.addAttribute("error_message", "Passwords do not match!");
            return "userRegister";
        }
        if (!appUserService.registerUser(dto)) {
            model.addAttribute("user_dto", dto);

            model.addAttribute("error_message", "This username is taken!");
            return "userRegister";
        }
        return "redirect:/login";
    }
}
