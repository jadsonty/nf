package com.sonner.nf.controlador;

import com.sonner.nf.modelo.ItemNota;
import com.sonner.nf.modelo.NotaFiscal;
import com.sonner.nf.modelo.Produto;
import com.sonner.nf.servico.ClienteServico;
import com.sonner.nf.servico.NotaFiscalServico;
import com.sonner.nf.servico.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/notas-fiscais")
public class NotaFiscalControle {

    @Autowired
    private NotaFiscalServico servico;

    @Autowired
    private ProdutoServico produtoServico;

    @Autowired
    private ClienteServico clienteServico;

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

    @PutMapping("/{idNota}/item-nota/{idItem}")
    public NotaFiscal alterarItemNotaFiscal(@PathVariable Long idNota, @PathVariable Long idItem, @RequestBody ItemNota novoItem) {
        ItemNota itemNotaBD = servico.getItemNotaById(idNota, idItem);

        if (itemNotaBD != null) {
            Produto produto = produtoServico.getProdutoById(novoItem.getProduto().getId());
            itemNotaBD.setProduto(produto);
            itemNotaBD.setQuantidade(novoItem.getQuantidade());
        }

        return servico.saveNotaFiscal(itemNotaBD.getNotaFiscal());

    }

    @PostMapping("/adicionar-varios")
    public List<NotaFiscal> addNotasFiscais(@RequestBody List<NotaFiscal> notasFiscais) {
        return servico.saveNotasFiscais(notasFiscais);
    }

    @GetMapping
    public List<NotaFiscal> findAllNotasFiscais() {
        return servico.getNotasFsicais();
    }

    @GetMapping("/{id}")
    public NotaFiscal findNotaFiscalById(@PathVariable long id) {
        return servico.getNotaFiscalById(id);
    }

    @GetMapping("/listar/{nome}")
    public NotaFiscal findNotaFiscalByNumero(@PathVariable String numero) {
        return servico.getNotaFiscalByNumero(numero);
    }

    @PutMapping("/alterar")
    public NotaFiscal updateNotaFiscal(@RequestBody NotaFiscal notaFiscal) {
        return servico.updateNotaFiscal(notaFiscal);
    }

    @DeleteMapping("/deletar/{id}")
    public String deleteNotaFiscal(@PathVariable long id) {
        return servico.deleteNotaFiscal(id);
    }


}
