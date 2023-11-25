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

    public Analise criarAnalise(Analise analise) {
        analise.setId(null);
        analiseRepository.save(analise);
        return analise;
    }

    public Analise mudarAnalise(Integer analiseId, Analise analiseEnviada) {
        Analise analiseEncontrada = getAnaliseId(analiseId);
        
        analiseEncontrada.setAnalise_feita(analiseEnviada.getAnalise_feita());
        analiseEncontrada.setNota(analiseEnviada.getNota());

        analiseRepository.save(analiseEncontrada);
        return analiseEncontrada;
    }

    public Analise getAnaliseId(Integer analiseId) {
        return analiseRepository.findById(analiseId).orElseThrow();
    }

    public List<Analise> listarAnalises() {
        return analiseRepository.findAll();
    }

    public void excluirAnalise(Integer analiseId) {
        Analise analiseExcluida = getAnaliseId(analiseId);
        analiseRepository.deleteById(analiseExcluida.getId());
    }

}
