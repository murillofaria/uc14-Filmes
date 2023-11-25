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

    public Filme criarFilme(Filme filme) {
        filme.setId(null);
        filmeRepository.save(filme);
        return filme;
    }

    public Filme mudarFilme(Integer filmeId, Filme filmeEnviado) {
        Filme filmeEncontrado = getFilmeId(filmeId);

        filmeEncontrado.setTitulo(filmeEnviado.getTitulo());
        filmeEncontrado.setSinopse(filmeEnviado.getSinopse());
        filmeEncontrado.setGenero(filmeEnviado.getGenero());
        filmeEncontrado.setAno_lancamento(filmeEnviado.getAno_lancamento());

        filmeRepository.save(filmeEncontrado);
        return filmeEncontrado;
    }

    public Filme getFilmeId(Integer filmeId) {
        return filmeRepository.findById(filmeId).orElseThrow();
    }

    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    public void excluirFilme(Integer filmeId) {
        Filme filmeExcluido = getFilmeId(filmeId);
        filmeRepository.deleteById(filmeExcluido.getId());
    }

}
