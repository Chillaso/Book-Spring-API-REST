package com.at.test.curso.controller

import com.at.test.curso.dto.BookDto
import com.at.test.curso.mapper.Mapper
import com.at.test.curso.model.Book
import com.at.test.curso.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.ResponseErrorHandler
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/book")
class BookController
{
    @Autowired lateinit var service: BookService
    @Autowired lateinit var mapper: Mapper<BookDto, Book>

    @GetMapping
    fun findAll(@RequestParam("name") name: String?,
                @RequestParam("size") size: Int?,
                @RequestParam("page") page: Int?): List<BookDto>
    {
        val pageable = PageRequest.of(page ?: 1,size ?: 1)
        //Si el nombre me viene vacio, no estoy filtrando, devuelvo todo
        return when(name.isNullOrBlank())
        {
            true -> service.findAll(pageable).let { mapper.mapEntityCollectionToDtoCollection(it).toList() }
            false -> findAllByName(name, pageable)
        }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Int): BookDto = service.findById(id).let { mapper.mapToDto(it.get())}

    @PostMapping
    fun create(@RequestBody bookDto: BookDto): BookDto = mapper.mapToEntity(bookDto)
                                                        .let { service.create(it) }
                                                        .let { mapper.mapToDto(it) }

    @PutMapping("/{id}")
    fun modify(@RequestBody bookDto: BookDto, @PathVariable("id") id: Int): BookDto =
             service.update(id, mapper.mapToEntity(bookDto)).let { mapper.mapToDto(it) }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int) = service.deleteById(id)

    private fun findAllByName(name: String, pageable: Pageable): List<BookDto> = service.findAllByName(name, pageable)
                                                        .let { mapper.mapEntityCollectionToDtoCollection(it).toList() }
}