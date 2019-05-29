package com.at.test.curso.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class BookDto(
        @NotNull val id: Int,
        @NotNull val isbn: String,
        val name: String,
        val synopsis: String,
        @Size(min = 1) val pages: Int
)
