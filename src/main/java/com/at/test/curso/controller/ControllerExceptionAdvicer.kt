package com.at.test.curso.controller

import javassist.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@ControllerAdvice(basePackages = ["com.at.test.curso.controller"])
class ControllerExceptionAdvicer
{
    @ExceptionHandler(NotFoundException::class, NullPointerException::class, NoSuchElementException::class)
    fun notFoundException():  ResponseEntity<String> = ResponseEntity("Not Found", HttpStatus.NOT_FOUND)
}