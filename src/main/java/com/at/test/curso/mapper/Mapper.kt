package com.at.test.curso.mapper

import org.springframework.data.domain.Page
import java.util.*

/**
 * Interfaz que mapea entidades a DTOs y DTOs a entidades
 * @param T - Tipo de entrada
 * @param S - Tipo de salida
 */
interface Mapper<T, S> {

    fun mapToEntity(t: T): S
    fun mapToDto(s: S): T
    fun mapDtoCollectionToEntityCollection(t: Page<T>): Collection<S>
    fun mapEntityCollectionToDtoCollection(s: Page<S>): Collection<T>
}