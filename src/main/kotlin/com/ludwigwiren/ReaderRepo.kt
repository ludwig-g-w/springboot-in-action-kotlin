package com.ludwigwiren

import org.springframework.data.jpa.repository.JpaRepository
import java.io.Reader


// Created by ludwi on date 2017-03-29
interface ReaderRepo : JpaRepository<Reader, String> {
}