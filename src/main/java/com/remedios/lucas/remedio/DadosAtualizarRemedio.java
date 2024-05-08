package com.remedios.lucas.remedio;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizarRemedio(
        @NotNull
        Long id,
        String nome,
        Via via,
        Laboratorio laboratorio){

}
