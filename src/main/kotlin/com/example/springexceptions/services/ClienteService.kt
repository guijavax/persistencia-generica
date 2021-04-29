package com.example.springexceptions.services

import com.example.springexceptions.model.Cliente
import com.example.springexceptions.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClienteService {

    @Autowired
    lateinit var repository : ClienteRepository

    fun findClienteById(id: Long) = repository.findById(id)

    fun findAllClientes() = repository.findAll()

    fun changeCliente(cliente: Cliente) = repository.saveAndFlush(cliente)

    fun deleCliente(id: Long) { repository.deleteById(id) }

    fun insere(cliente: Cliente) : Cliente{
       return repository.save(cliente)
    }
}