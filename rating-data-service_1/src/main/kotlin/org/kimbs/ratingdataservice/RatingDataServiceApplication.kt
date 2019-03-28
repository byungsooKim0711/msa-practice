package org.kimbs.ratingdataservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RatingDataServiceApplication

fun main(args: Array<String>) {
	runApplication<RatingDataServiceApplication>(*args)
}
