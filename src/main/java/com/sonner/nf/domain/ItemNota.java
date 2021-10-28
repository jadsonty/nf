package com.sonner.nf.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ItemNota implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double quantidade;
    private double valorTotal;

    public ItemNota() {

    }

    public ItemNota(Produto produto) {
        this.produto = produto;
    }

    public ItemNota(int id, double quantidade, double valorTotal, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.produto = produto;
    }

    @OneToOne
    private Produto produto;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemNota itemNota = (ItemNota) o;
        return id == itemNota.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
