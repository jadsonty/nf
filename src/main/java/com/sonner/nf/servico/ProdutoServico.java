package com.sonner.nf.servico;

import com.sonner.nf.modelo.Produto;
import com.sonner.nf.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio repository;

    public Produto saveProduto(Produto produto){
        return repository.save(produto);
    }

    public List<Produto> saveProdutos(List<Produto> produtos) {
        return repository.saveAll(produtos);
    }

    public List<Produto> getProdutos() {
        return repository.findAll();
    }

    public Produto getProdutoById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Produto getProdutoByNome(String nome) {
        return repository.findByNome(nome);
    }

    public String deleteProduto(int id) {
        repository.deleteById(id);
        return "Produto de id " + id + "removido";
    }

    public Produto updateProduto(Produto produto) {
        Produto existingProduto = repository.findById(produto.getId()).orElse(null);
        existingProduto.setCodigo(produto.getCodigo());
        existingProduto.setNome(produto.getNome());
        existingProduto.setPreco(produto.getPreco());
        return repository.save(existingProduto);
    }



}
