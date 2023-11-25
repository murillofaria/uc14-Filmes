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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FilmeAPIController {

    @Autowired
    FilmeService filmeService;

    @PostMapping("/cadastrar/filme")
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filmePopulado) {
        Filme filmeCadastrado = filmeService.criarFilme(filmePopulado);
        return new ResponseEntity<>(filmeCadastrado, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/filme/{filmeId}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Integer filmeId, @RequestBody Filme filme) {
        Filme filmeAtualizado = filmeService.mudarFilme(filmeId, filme);
        return new ResponseEntity<>(filmeAtualizado, HttpStatus.OK);
    }

    @GetMapping("/exibir/filme")
    public ResponseEntity<List> exibirFilmes() {
        List<Filme> filmes = filmeService.listarFilmes();
        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/filme/{filmeId}")
    public ResponseEntity<?> deletarFilme(@PathVariable Integer filmeId) {
        filmeService.excluirFilme(filmeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
