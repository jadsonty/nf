package com.sonner.nf.controlador;

import com.sonner.nf.modelo.Produto;
import com.sonner.nf.servico.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoControle {

    @Autowired
    private ProdutoServico servico;

    @PostMapping("/adicionar")
    public Produto addProduto(@RequestBody Produto produto) {
        return servico.saveProduto(produto);
    }

    @PostMapping("/adicionar-varios")
    public List<Produto> addProdutos(@RequestBody List<Produto> produtos) {
        return servico.saveProdutos(produtos);
    }

    @GetMapping
    public List<Produto> findAllProdutos() {
        return servico.getProdutos();
    }

    @GetMapping("/pesquisar/{id}")
    public Produto findProdutoById(@PathVariable int id) {
        return servico.getProdutoById(id);
    }

    @GetMapping("/listar/{nome}")
    public Produto findProdutoByName(@PathVariable String nome) {
        return servico.getProdutoByNome(nome);
    }

    @PutMapping("/alterar")
    public Produto updateProduto(@RequestBody Produto produto) {
        return servico.updateProduto(produto);
    }

    @DeleteMapping("/deletar/{id}")
    public String deleteProduto(@PathVariable int id) {
        return servico.deleteProduto(id);
    }
}
