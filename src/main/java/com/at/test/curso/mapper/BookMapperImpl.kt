package com.at.test.curso.mapper

import com.at.test.curso.dto.BookDto
import com.at.test.curso.model.Book
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
class BookMapperImpl: Mapper<BookDto, Book>
{
    override fun mapToEntity(t: BookDto): Book = Book(t.id, t.isbn, t.name, t.synopsis, t.pages)

    override fun mapToDto(s: Book): BookDto = BookDto(s.id, s.isbn, s.name, s.synopsis, s.pages)

    override fun mapDtoCollectionToEntityCollection(t: Page<BookDto>): Collection<Book>
    {
        val result = mutableListOf<Book>()
        t.forEach { result.add(Book(it.id, it.isbn, it.name, it.synopsis, it.pages)) }
        return result
    }

    override fun mapEntityCollectionToDtoCollection(s: Page<Book>): Collection<BookDto>
    {
        val result = mutableListOf<BookDto>()
        s.forEach { result.add(BookDto(it.id, it.isbn, it.name, it.synopsis, it.pages)) }
        return result
    }
}