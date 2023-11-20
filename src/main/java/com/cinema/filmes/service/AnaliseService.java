package com.cinema.filmes.service;

import com.cinema.filmes.model.Analise;
import com.cinema.filmes.repository.AnaliseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {

    @Autowired
    AnaliseRepository analiseRepository;
    
    public Analise criarAnalise(Analise analise){
        analise.setId(null);
        analiseRepository.save(analise);
        return analise;
    }
    
    public List<Analise> listarAnalises(){
        return analiseRepository.findAll();
    }
    
    public Analise exibirAnalisePorId(Integer id){
        return analiseRepository.findById(id).orElseThrow();
    }
    
    public void excluirAnalise(Integer id){
        Analise analiseExcluida = exibirAnalisePorId(id);
        analiseRepository.deleteById(analiseExcluida.getId());
    }
    
}
