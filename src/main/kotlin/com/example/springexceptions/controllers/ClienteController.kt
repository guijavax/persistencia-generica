package com.example.springexceptions.controllers

import com.example.springexceptions.model.Cliente
import com.example.springexceptions.services.ClienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam


@RestController
@RequestMapping("/cliente")
class ClienteController {

    private lateinit var service : ClienteService

    @Autowired
    constructor(service: ClienteService) {
        this.service = service
    }

    @RequestMapping(value = ["/{id}"],method = [RequestMethod.GET])
    fun getClienteById(@PathVariable("id") idCliente : Long) : ResponseEntity<Any>{
        val cliente = service.findClienteById(idCliente)
        return if(!cliente.isEmpty) ResponseEntity.ok(cliente) else ResponseEntity.noContent().build()
    }

    @RequestMapping(method = [RequestMethod.POST])
    fun insertCliente(@RequestBody cliente : Cliente) : ResponseEntity<Cliente> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insere(cliente))
    }

    @RequestMapping(method = [RequestMethod.GET])
    fun getClientes() : ResponseEntity<Any>{
        val clientes = service.findAllClientes()
        return if(!clientes.isEmpty()) ResponseEntity.ok(clientes) else ResponseEntity.noContent().build()
    }

    @RequestMapping(method = [RequestMethod.PATCH])
    fun updateCliente(@RequestBody cliente : Cliente) : ResponseEntity<Cliente> {
        return ResponseEntity.status(HttpStatus.OK).body(service.insere(cliente))
    }

    @RequestMapping(value = ["/{id}"],method = [RequestMethod.DELETE])
    fun deleteClienteById(@PathVariable("id") idCliente : Long) : ResponseEntity<Any>{
        val cliente = service.deleCliente(idCliente)
        return ResponseEntity.noContent().build()
    }
}