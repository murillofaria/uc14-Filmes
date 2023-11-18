package com.cinema.filmes.controller;

import com.cinema.filmes.model.Analise;
import com.cinema.filmes.model.Filme;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FilmeController {

    private List<Filme> filmes = new ArrayList<>();

    @GetMapping("/cadastro")
    public String exibirCadastro(Model model) {
        model.addAttribute("filme", new Filme());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarFilme(@ModelAttribute Filme filme, Model model) {
        filme.setId(filmes.size() + 1);
        filmes.add(filme);
        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public String exibirLista(Model model) {
        model.addAttribute("filmes", filmes);
        return "lista";
    }

    @GetMapping("/detalhe/{id}")
    public String exibirDetalhe(@PathVariable("id") int id, Analise analise, Model model) {
        for (Filme procurarFilme : filmes) {
            if (procurarFilme.getId() == id) {
                analise.setFilme(procurarFilme);
                analise.setId(procurarFilme.getId());
                model.addAttribute("analise", analise);
            }
        }
        return "detalhe";
    }

    @PostMapping("/detalhe/{id}")
    public String analisarFilme() {
        return "redirect:/lista";
    }
}
