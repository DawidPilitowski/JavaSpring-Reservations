package com.dawid.reservation.controller;

import com.dawid.reservation.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    @GetMapping(path = "/personForm")
    public String getPersonForm(Model model) {
        Person person = new Person();

        model.addAttribute("person", person);

        return "personForm";
    }

    @PostMapping(path = "/personForm")
    public String showPerson(Person person) {
        System.out.println(person);
        // 1 - przekieruje na inną stronę
        // 2 - stworzenie widoku i wyświetlenie wpisanych danych
        return "hello";
    }
}
