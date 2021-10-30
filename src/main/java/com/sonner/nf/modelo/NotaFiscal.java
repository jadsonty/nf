package com.sonner.nf.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class NotaFiscal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private Date data;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "notaFiscal")
    private List<ItemNota> itens = new ArrayList<>();

}
