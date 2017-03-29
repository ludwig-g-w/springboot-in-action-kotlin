package com.ludwigwiren

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


// Created by ludwi on date 2017-03-29
@Entity
class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var reader: String = "",
        var isbn: String = "",
        var title: String = "",
        var author: String = "",
        var description: String = ""
)


