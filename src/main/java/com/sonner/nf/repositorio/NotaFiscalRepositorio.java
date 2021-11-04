package com.sonner.nf.repositorio;

import com.sonner.nf.modelo.ItemNota;
import com.sonner.nf.modelo.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotaFiscalRepositorio extends JpaRepository<NotaFiscal,Long> {
    NotaFiscal findByNumero(String numero);

    @Query("select i from NotaFiscal nf join nf.itens i where nf.id=:idNota and i.id=:idItem")
    Optional<ItemNota> findByItemNotaById(@Param("idNota") Long idNota, @Param("idItem") Long idItem);
}
