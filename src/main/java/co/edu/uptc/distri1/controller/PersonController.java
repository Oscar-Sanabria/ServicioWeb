package co.edu.uptc.distri1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.distri1.model.Person;

@RestController
@RequestMapping("/persona")

public class PersonController {
    @GetMapping("/all")
    public Person getPersonRandom() {
        Person person = new Person();
        person.setName("Oscar");
        person.setLastname("Sanabria");
        return person;
    }
}
