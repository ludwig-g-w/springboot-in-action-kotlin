package com.ludwigwiren

import org.springframework.data.jpa.repository.JpaRepository


// Created by ludwi on date 2017-03-29
interface ReadingListRepo : JpaRepository<Book, Long> {
    fun findByReader(reader: String): List<Book>
}