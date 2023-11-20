package com.cinema.filmes.controller;

import com.cinema.filmes.model.Filme;
import com.cinema.filmes.service.FilmeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema")
public class FilmeAPIController {

    @Autowired
    FilmeService filmeService;

    @PostMapping("/cadastrar/filme")
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filmePopulado) {
        Filme filmeCadastrado = filmeService.criarFilme(filmePopulado);
        return new ResponseEntity<>(filmeCadastrado, HttpStatus.CREATED);
    }

    @GetMapping("/exibir/filme")
    public ResponseEntity<List> exibirFilmes() {
        List<Filme> filmes = filmeService.listarFilmes();
        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }
    
    @DeleteMapping("/deletar/filme/{id}")
    public ResponseEntity<?> deletarFilme(@PathVariable Integer id){
        filmeService.excluirFilme(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
