package com.at.test.curso.service

import com.at.test.curso.dao.BookRepository
import com.at.test.curso.model.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookServiceImpl: BookService
{
    @Autowired lateinit var repo: BookRepository

    private fun modifyBookData(old: Book, new: Book): Book
    {
        new.name = old.name
        new.pages = old.pages
        new.synopsis = old.synopsis
        return new
    }

    override fun findAll(pageable: Pageable): Page<Book> = repo.findAll(pageable)

    override fun findById(id: Int): Optional<Book> = repo.findById(id)

    override fun findAllByName(name: String, pageable: Pageable): Page<Book> =
            repo.findAllByNameContainingIgnoreCase(name, pageable)

    override fun create(s: Book): Book = repo.save(s)

    override fun update(id: Int, s: Book): Book = repo.findById(id)
                                                .map { modifyBookData(it, s) }
                                                .map { repo.save(it) }
                                                .get()

    override fun deleteById(id: Int) = repo.deleteById(id)
}