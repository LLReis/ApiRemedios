package com.remedios.lucas.controllers;

import com.remedios.lucas.remedio.*;
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
        return repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarRemedio dados){
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
    }
    @PutMapping("Ativar/{id}")
    @Transactional
    public void AtualizarParaAtivo(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.ativar();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public void inativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.inativar();
    }
}
