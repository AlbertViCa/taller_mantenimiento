package com.taller.mantenimiento;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")//Esta clase responderé al request de saludar
public class HolaMundoCotroller {

    @GetMapping("/hola")//Este método responderá al request de hola
    public String saludar(){
        return "Hola, mundo!";
    }
}
