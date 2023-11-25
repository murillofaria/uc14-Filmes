package com.cinema.filmes.controller;

import com.cinema.filmes.model.Analise;
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
@RequestMapping("/filme/analise")
public class AnaliseController {

    @Autowired
    AnaliseService analiseService;

    @Autowired
    FilmeService filmeService;

    @GetMapping("/{filmeId}")
    public String exibirAnalise(@PathVariable("filmeId") Integer filmeId, Model model) {
        List<Analise> listaAnalises = analiseService.listarAnalises();
        for (Analise objAnalise : listaAnalises) {
            int idAnalise = objAnalise.getFilme().getId();
            if (idAnalise == filmeId) {
                model.addAttribute("analise", objAnalise);
                model.addAttribute("filmeId", filmeId);
                return "analise";
            }
        }
        model.addAttribute("analise", new Analise());
        model.addAttribute("filmeId", filmeId);
        return "analise";
    }

    @PostMapping("/{filmeId}")
    public String analisarFilme(@ModelAttribute("analise") Analise analise, @PathVariable("filmeId") Integer filmeId, Model model) {
        analise.setFilme(filmeService.getFilmeId(filmeId));
        List<Analise> listaAnalises = analiseService.listarAnalises();
        for (Analise objAnalise : listaAnalises) {
            int idAnalise = objAnalise.getFilme().getId();
            if (idAnalise == analise.getFilme().getId()) {
                analiseService.mudarAnalise(objAnalise.getId(), analise);
                return "redirect:/filme/lista";
            }
        }
        analiseService.criarAnalise(analise);
        return "redirect:/filme/lista";
    }

    @GetMapping("/deletar/{filmeId}")
    public String deletarAnalise(@PathVariable("filmeId") Integer filmeId) {
        List<Analise> listaAnalises = analiseService.listarAnalises();
        for (Analise objAnalise : listaAnalises) {
            int idAnalise = objAnalise.getFilme().getId();
            if (idAnalise == filmeId) {
                analiseService.excluirAnalise(objAnalise.getId());
                return "redirect:/filme/lista";
            }
        }
        return "redirect:/filme/lista";
    }
}
