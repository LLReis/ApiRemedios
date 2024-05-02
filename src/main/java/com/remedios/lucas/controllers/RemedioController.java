package com.remedios.lucas.controllers;

import com.remedios.lucas.remedio.DadosCadastroRemedio;
import com.remedios.lucas.remedio.Remedio;
import com.remedios.lucas.remedio.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroRemedio dados) {
        repository.save(new Remedio(dados));
    }
}
