package com.sonner.nf.resources;

import com.sonner.nf.domain.Cliente;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Cliente> listar(){
        Cliente cli1 = new Cliente(1, "0001", "Jadson");
        Cliente cli2 = new Cliente(2, "0002", "Roberta");

        List<Cliente> lista = new ArrayList<>();
        lista.add(cli1);
        lista.add(cli2);

        return lista;

   }

}
