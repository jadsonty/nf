package com.sonner.nf.controlador;

import com.sonner.nf.modelo.ItemNota;
import com.sonner.nf.modelo.NotaFiscal;
import com.sonner.nf.modelo.Produto;
import com.sonner.nf.servico.NotaFiscalServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/notas-fiscais")
public class NotaFiscalControle {

    @Autowired
    private NotaFiscalServico servico;

    @PostMapping
    public NotaFiscal addNotaFiscal(@RequestBody NotaFiscal notaFiscal) {
        return servico.saveNotaFiscal(notaFiscal);
    }

    @PostMapping("/{idNota}/item-nota")
    public NotaFiscal adicionarItemNotaFiscal(@PathVariable Long idNota, @RequestBody ItemNota item) {
        NotaFiscal notaFiscal = servico.getNotaFiscalById(idNota);

        notaFiscal.adicionarItem(item);

        return servico.saveNotaFiscal(notaFiscal);
    }

    @DeleteMapping("/{idNota}/item-nota/{idItem}")
    public NotaFiscal deletarItemNotaFiscal(@PathVariable Long idNota, @PathVariable Long idItem) {
        NotaFiscal notaFiscal = servico.getNotaFiscalById(idNota);

        notaFiscal.deletarItem(idItem);

        return servico.saveNotaFiscal(notaFiscal);
    }

    @PostMapping("/adicionar-varios")
    public List<NotaFiscal> addNotasFiscais(@RequestBody List<NotaFiscal> notasFiscais) {
        return servico.saveNotasFiscais(notasFiscais);
    }

    @GetMapping
    public List<NotaFiscal> findAllNotasFiscais() {
        return servico.getNotasFsicais();
    }

    @GetMapping("/pesquisar/{id}")
    public NotaFiscal findNotaFiscalById(@PathVariable long id) {
        return servico.getNotaFiscalById(id);
    }

    @GetMapping("/listar/{nome}")
    public NotaFiscal findNotaFiscalByNumero(@PathVariable String numero) {
        return servico.getNotaFiscalByNumero(numero);
    }

    @PutMapping("/alterar")
    public NotaFiscal updateNotaFiscal(@RequestBody NotaFiscal notaFiscal) { return servico.updateNotaFiscal(notaFiscal);}

    @DeleteMapping("/deletar/{id}")
    public String deleteNotaFiscal(@PathVariable long id) {
        return servico.deleteNotaFiscal(id);
    }




}
