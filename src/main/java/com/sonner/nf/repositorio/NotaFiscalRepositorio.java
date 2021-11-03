package com.sonner.nf.repositorio;

import com.sonner.nf.modelo.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaFiscalRepositorio extends JpaRepository<NotaFiscal,Long> {
    NotaFiscal findByNumero(String numero);
}
