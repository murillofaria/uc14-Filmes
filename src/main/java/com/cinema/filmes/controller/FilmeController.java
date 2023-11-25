package com.cinema.filmes.controller;

import com.cinema.filmes.model.Analise;
import com.cinema.filmes.model.Filme;
import com.cinema.filmes.service.AnaliseService;
import com.cinema.filmes.service.FilmeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @Autowired
    AnaliseService analiseService;

    @GetMapping("/cadastro")
    public String exibirCadastro(Model model) {
        model.addAttribute("filme", new Filme());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarFilme(@ModelAttribute("filme") Filme filmePopulado, Model model) {
        filmeService.criarFilme(filmePopulado);
        return "redirect:/filme/lista";
    }

    @GetMapping("/lista")
    public String exibirLista(Model model) {
        model.addAttribute("filmes", filmeService.listarFilmes());
        return "lista";
    }

    @GetMapping("/edit/{filmeId}")
    public String exibirFilme(@PathVariable("filmeId") Integer filmeId, Model model) {
        List<Filme> listaFilmes = filmeService.listarFilmes();
        for (Filme objFilme : listaFilmes) {
            int idFilme = objFilme.getId();
            if (idFilme == filmeId) {
                model.addAttribute("filmeId", filmeId);
                model.addAttribute("filme", objFilme);
                return "edit";
            }
        }
        return "redirect:/filme/lista";
    }

    @PostMapping("/edit/{filmeId}")
    public String editarFilme(@ModelAttribute("filme") Filme filme) {
        filmeService.mudarFilme(filme.getId(), filme);
        return "redirect:/filme/lista";
    }

    @GetMapping("/edit/deletar/{filmeId}")
    public String deletarFilme(@PathVariable("filmeId") Integer filmeId) {
        List<Analise> listaAnalises = analiseService.listarAnalises();
        for (Analise objAnalise : listaAnalises) {
            int idAnaliseFilme = objAnalise.getFilme().getId();
            if (idAnaliseFilme == filmeId) {
                analiseService.excluirAnalise(objAnalise.getId());
                filmeService.excluirFilme(filmeId);
                return "redirect:/filme/lista";
            }
        }
        filmeService.excluirFilme(filmeId);
        return "redirect:/filme/lista";
    }
}
