package com.at.test.curso.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

/**
 * Interface basica para un CRUD sencillo.
 * @param S - Tipo de objeto sobre el que estamos operando.
 * @param ID - Tipo del identificador de S
 */
interface BasicCrudService<S,ID> {

    fun findAll(pageable: Pageable): Page<S>
    fun findById(id: ID): Optional<S>
    fun create(s: S): S
    fun update(id: ID, s: S): S
    fun deleteById(id: ID)
}