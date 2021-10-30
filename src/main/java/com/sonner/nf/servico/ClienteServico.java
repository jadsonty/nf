package com.sonner.nf.servico;

import com.sonner.nf.modelo.Cliente;
import com.sonner.nf.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServico {
    @Autowired
    private ClienteRepositorio repository;

    public Cliente saveCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> saveClientes(List<Cliente> clientes) {
        return repository.saveAll(clientes);
    }

    public List<Cliente> getClientes() {
        return repository.findAll();
    }

    public Cliente getClienteById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Cliente getClienteByNome(String nome) {
        return repository.findByNome(nome);
    }

    public String deleteCliente(int id) {
        repository.deleteById(id);
        return "Cliente de id " + id + "removido";
    }

    public Cliente updateCliente(Cliente cliente) {
        Cliente existingCliente = repository.findById(cliente.getId()).orElse(null);
        existingCliente.setCodigo(cliente.getCodigo());
        existingCliente.setNome(cliente.getNome());
        return repository.save(existingCliente);
    }


}
