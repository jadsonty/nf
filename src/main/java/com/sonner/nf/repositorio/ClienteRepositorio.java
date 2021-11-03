package com.sonner.nf.repositorio;

import com.sonner.nf.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,Integer> {
    Cliente findByNome(String nome);
}
