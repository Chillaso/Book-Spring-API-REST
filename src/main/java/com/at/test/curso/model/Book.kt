package com.at.test.curso.model

import org.hibernate.validator.constraints.ISBN
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Book(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int = 0,
        val isbn: String = "",
        var name: String = "",
        var synopsis: String = "",
        var pages: Int = 0
)
