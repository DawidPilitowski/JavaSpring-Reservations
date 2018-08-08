package com.dawid.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping(path = "/index/")
public class IndexController {
    @GetMapping(path = "/")
    public String getIndex() {
        return "index";
    }

    @GetMapping(path = "/hello")
    public String getHello(Model model,
                           @RequestParam(name = "name", required = false) String name) {
        model.addAttribute("clientsName", name);
        model.addAttribute("size", 20);
        model.addAttribute("list", Arrays.asList("Ala", "Ola", "Ela", "Kasia", "Basia"));
        return "hello";
    }
}
