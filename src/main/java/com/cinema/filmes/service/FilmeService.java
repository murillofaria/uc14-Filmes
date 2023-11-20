package com.cinema.filmes.service;

import com.cinema.filmes.model.Filme;
import com.cinema.filmes.repository.FilmeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    
    @Autowired
    FilmeRepository filmeRepository;
    
    public Filme criarFilme(Filme filme){
        filme.setId(null);
        filmeRepository.save(filme);
        return filme;
    }
    
    public List<Filme> listarFilmes(){
        return filmeRepository.findAll();
    }
    
    public Filme exibirFilmePorId(Integer id){
        return filmeRepository.findById(id).orElseThrow();
    }
    
    public void excluirFilme(Integer id){
        Filme filmeExcluido = exibirFilmePorId(id);
        filmeRepository.deleteById(filmeExcluido.getId());
    }
    
}