package com.ludwigwiren

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


// Created by ludwi on date 2017-03-29
@Controller
@RequestMapping("/")
open class ReadingListController(var repo: ReadingListRepo) {

    @GetMapping(value = "/{reader}")
    fun readersBooks(@PathVariable("reader") reader: String,
                     model: Model): String {
        val readingList: List<Book> = repo.findByReader(reader)

        model.addAttribute("books", readingList)

        return "readingList"
    }

    @PostMapping(value = "/{reader}")
    fun addToReadingList(
            @PathVariable("reader") reader: String,
            book: Book): String {
        book.reader = reader
        repo.save(book)
        return "redirect:/{reader}"
    }
}