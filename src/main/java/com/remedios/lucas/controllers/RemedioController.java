package com.remedios.lucas.controllers;

import com.remedios.lucas.remedio.DadosCadastroRemedio;
import com.remedios.lucas.remedio.DadosListagemRemedio;
import com.remedios.lucas.remedio.Remedio;
import com.remedios.lucas.remedio.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
        repository.save(new Remedio(dados));
    }

    @GetMapping
    public List<DadosListagemRemedio> listar (){
        return repository.findAll().stream().map(DadosListagemRemedio::new).toList();
    }
}
