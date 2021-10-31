package com.sonner.nf.repositorio;

import com.sonner.nf.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto,Integer> {
    Produto findByNome(String nome);
}
