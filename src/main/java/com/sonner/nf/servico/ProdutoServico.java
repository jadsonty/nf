package com.sonner.nf.servico;

import com.sonner.nf.modelo.Produto;
import com.sonner.nf.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio pr;

    public Produto saveProduto(Produto produto){
        return pr.save(produto);
    }

    public List<Produto> saveProdutos(List<Produto> produtos) {
        return pr.saveAll(produtos);
    }

    public List<Produto> getProdutos() {
        return pr.findAll();
    }

    public Produto getProdutoById(int id) {
        return pr.findById(id).orElse(null);
    }

    public Produto getProdutoByNome(String nome) {
        return pr.findByNome(nome);
    }

    public String deleteProduto(int id) {
        pr.deleteById(id);
        return "Produto de id " + id + "removido";
    }

    public Produto updateProduto(Produto produto) {
        Produto existingProduto = pr.findById(produto.getId()).orElse(null);
        existingProduto.setCodigo(produto.getCodigo());
        existingProduto.setNome(produto.getNome());
        existingProduto.setPreco(produto.getPreco());
        return pr.save(existingProduto);
    }



}
