package com.produtos.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.produtos.produto.model.Produto;
import com.produtos.produto.model.ProdutoRepository;

@Controller // Utilizado para quando fazemos a conexão do Front
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/")
    private String listarProdutos(Model model) {
        model.addAttribute("produtos", repository.findAll());
        return "lista";
    }

    @GetMapping("/cadastro")
    private String mostrarFormulario(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    private String cadastrar(Produto produto) {
        repository.save(produto);
        return "redirect:/";

    }

}
