package com.vicen.crud_spring.pacientes;

import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco) {

}
