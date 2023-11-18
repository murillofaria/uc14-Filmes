package com.cinema.filmes.controller;

import com.cinema.filmes.service.AnaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnaliseAPIController {

    @Autowired
    AnaliseService analiseService;

}
