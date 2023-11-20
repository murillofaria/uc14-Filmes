package com.cinema.filmes.controller;

import com.cinema.filmes.model.Analise;
import com.cinema.filmes.service.AnaliseService;
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
public class AnaliseAPIController {

    @Autowired
    AnaliseService analiseService;

    @PostMapping("/cadastrar/analise")
    public ResponseEntity<Analise> cadastrarAnalise(@RequestBody Analise analise) {
        Analise analiseFeita = analiseService.criarAnalise(analise);
        return new ResponseEntity<>(analiseFeita, HttpStatus.CREATED);
    }

    @GetMapping("/exibir/analise")
    public ResponseEntity<List> exibirAnalises() {
        List<Analise> analises = analiseService.listarAnalises();
        return new ResponseEntity<>(analises, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/analise/{id}")
    public ResponseEntity<?> deletarAnalise(@PathVariable Integer id) {
        analiseService.excluirAnalise(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
