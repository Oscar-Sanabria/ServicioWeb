package co.edu.uptc.distri1.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
        String coname = "";
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            coname = localHost.getHostName();
        } catch (UnknownHostException e) {
            System.err.println("No se pudo obtener el nombre del equipo: " + e.getMessage());
            return null;
        }
        Person person = new Person();
        person.setName("Oscar");
        person.setLastname(coname);
        return person;
    }
    @GetMapping("/test")
    public void getPersonRandom() {
        for (int i = 0; i <= 1000000; i++) {
            double raiz = Math.sqrt(i);
            System.out.println("La raíz cuadrada de " + i + " es: " + raiz);
        }
    }
}
