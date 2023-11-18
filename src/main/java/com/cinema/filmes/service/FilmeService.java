package com.cinema.filmes.service;

import com.cinema.filmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    
    @Autowired
    FilmeRepository filmeRepository;
    
}