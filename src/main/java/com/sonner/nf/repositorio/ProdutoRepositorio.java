package com.sonner.nf.repositorio;

import com.sonner.nf.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto,Integer> {
    Produto findByNome(String nome);
}
