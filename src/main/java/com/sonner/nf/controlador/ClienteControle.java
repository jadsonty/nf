package com.sonner.nf.controlador;

import com.sonner.nf.modelo.Cliente;
import com.sonner.nf.servico.ClienteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteControle {

    @Autowired
    private ClienteServico servico;

    @PostMapping("/adicionar")
    public Cliente addCliente(@RequestBody Cliente cliente) {
        return servico.saveCliente(cliente);
    }

    @PostMapping("/adicionar-varios")
    public List<Cliente> addClientes(@RequestBody List<Cliente> clientes) {
        return servico.saveClientes(clientes);
    }

    @GetMapping
    public List<Cliente> findAllClientes() {
        return servico.getClientes();
    }

    @GetMapping("/pesquisar/{id}")
    public Cliente findClienteById(@PathVariable int id) {
        return servico.getClienteById(id);
    }

    @GetMapping("/listar/{nome}")
    public Cliente findClienteByName(@PathVariable String nome) {
        return servico.getClienteByNome(nome);
    }

    @PutMapping("/alterar")
    public Cliente updateCliente(@RequestBody Cliente cliente) {
        return servico.updateCliente(cliente);
    }

    @DeleteMapping("/deletar/{id}")
    public String deleteCliente(@PathVariable int id) {
        return servico.deleteCliente(id);
    }
}