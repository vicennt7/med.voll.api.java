package com.vicen.crud_spring.pacientes;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paciente")
public class PacientesController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPaciente dados ){
    System.out.println("dados recebido: " +dados); // NOSONAR
    }
}
