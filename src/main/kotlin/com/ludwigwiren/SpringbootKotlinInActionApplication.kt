package com.ludwigwiren

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringbootKotlinInActionApplication {

    @Bean
    fun init(repo: ReadingListRepo) = CommandLineRunner {
        repo.save(Book(reader = "craig", isbn = "123515", author = "someone", title = "title", description = "nothing special"))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(SpringbootKotlinInActionApplication::class.java, *args)
}
