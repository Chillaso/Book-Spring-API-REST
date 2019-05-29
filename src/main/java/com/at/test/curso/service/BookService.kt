package com.at.test.curso.service

import com.at.test.curso.model.Book
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface BookService: BasicCrudService<Book, Int>
{
    fun findAllByName(name: String, pageable: Pageable): Page<Book>
}
