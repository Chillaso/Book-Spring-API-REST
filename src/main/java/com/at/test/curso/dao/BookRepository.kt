package com.at.test.curso.dao

import com.at.test.curso.model.Book
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Int>
{
    /**
     * Busca todos los libros cuyo nombre contenga @param name
     * @return List<Book> libros - Lista de libros coincidentes
     */
    fun findAllByNameContainingIgnoreCase(name: String, page: Pageable): Page<Book>
}
