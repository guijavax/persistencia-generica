package com.example.springexceptions.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Table

@Entity
@Table(name = "cliente")
data class Cliente (

    @Id
    @GeneratedValue
    val idCliente: Long = 0L,

    @Column
    @JsonProperty(value = "nome_cliente")
    val nomeCliente: String = "",

    @Column
    val idade: Int = 0

)