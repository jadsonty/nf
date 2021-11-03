package com.sonner.nf.servico;

import com.sonner.nf.modelo.Cliente;
import com.sonner.nf.modelo.ItemNota;
import com.sonner.nf.modelo.NotaFiscal;
import com.sonner.nf.modelo.Produto;
import com.sonner.nf.repositorio.ClienteRepositorio;
import com.sonner.nf.repositorio.NotaFiscalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaFiscalServico {

    @Autowired
    private NotaFiscalRepositorio repository;

    @Autowired
    private ClienteServico clienteServico;

    @Autowired
    private ProdutoServico produtoServico;

    public NotaFiscal saveNotaFiscal(NotaFiscal notaFiscal){
        Cliente cliente = clienteServico.getClienteById(notaFiscal.getCliente().getId());

        notaFiscal.setCliente(cliente);

        for (ItemNota item : notaFiscal.getItens()) {
            Produto produto = produtoServico.getProdutoById(item.getProduto().getId());
            item.setProduto(produto);
            item.setNotaFiscal(notaFiscal);
        }

        return repository.save(notaFiscal);
    }

    public List<NotaFiscal> saveNotasFiscais(List<NotaFiscal> notasFiscais){
        return repository.saveAll(notasFiscais);
    }

    public List<NotaFiscal> getNotasFsicais() {
        return repository.findAll();
    }

    public NotaFiscal getNotaFiscalById(long id) {
        return repository.findById(id).orElse(null);
    }

    public NotaFiscal getNotaFiscalByNumero(String numero) {
        return repository.findByNumero(numero);
    }

    public String deleteNotaFiscal(long id) {
        repository.deleteById(id);
        return "Nota fiscal de id " + id + "removido";
    }

    public NotaFiscal updateNotaFiscal(NotaFiscal notaFiscal) {
        NotaFiscal existingNotaFiscal = repository.findById(notaFiscal.getId()).orElse(null);
        existingNotaFiscal.setNumero(notaFiscal.getNumero());
        existingNotaFiscal.setData(notaFiscal.getData());
        existingNotaFiscal.setCliente(notaFiscal.getCliente());
        existingNotaFiscal.setItens(notaFiscal.getItens());
        return repository.save(existingNotaFiscal);
    }
}
