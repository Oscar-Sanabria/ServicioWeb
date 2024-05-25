package co.edu.uptc.distri1.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

import co.edu.uptc.distri1.model.Person;

@RestController
@RequestMapping("/persona")

public class PersonController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    private static final String podName = System.getenv("POD_NAME");

    @GetMapping("/calcular")
    public Map<String, Object> getResult(@RequestParam("p1") String p1, @RequestParam("p2") String p2) {
        Map<String, Object> response = new HashMap<>();
        try {
            double result = Double.parseDouble(p1) / Double.parseDouble(p2);
            response.put("result", result);
        } catch (NumberFormatException e) {
            logger.error("Error parsing input in pod: " + podName, e);
            response.put("error", "Invalid input");
        }
        response.put("podName", podName);
        return response;
    }

    
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
    public void getSqrt() {
        for (int i = 0; i <= 1000000; i++) {
            double raiz = Math.sqrt(i);
            System.out.println("La raíz cuadrada de " + i + " es: " + raiz);
        }
    }
}
