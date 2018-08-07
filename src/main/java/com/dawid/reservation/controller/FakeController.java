package com.dawid.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/index/")
public class FakeController {

    @GetMapping(path = "/multiplication")
    public String getMultiplicationTable(Model model,
                                         @RequestParam(name = "size") Integer size) {
        model.addAttribute("size", size);
        return "multiplicationTable";
    }

    @GetMapping(path = "/alphabet/{howMany}")
    public String getAlphabet(Model model, @PathVariable(name = "howMany") Integer howMany) {
        List<Character> characters = new ArrayList<>();

        for (char i = 'a'; i < 'z'; i++) {
            characters.add(i);
        }

        model.addAttribute("alphabet", characters);
        model.addAttribute("howMany", howMany);

        return "alphabet";
    }

}
