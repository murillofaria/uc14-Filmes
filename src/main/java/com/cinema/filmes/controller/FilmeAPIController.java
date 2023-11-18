package com.cinema.filmes.controller;

import com.cinema.filmes.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmeAPIController {

    @Autowired
    FilmeService filmeService;

}
