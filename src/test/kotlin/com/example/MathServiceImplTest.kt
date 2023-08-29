package com.example

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals

@MicronautTest
class MathServiceTest {

    @Inject
    lateinit var mathService: MathService


    @ParameterizedTest
    @CsvSource("2,8", "3,12")
    fun testComputeNumToSquare(num: Int, square: Int) {
        val result = mathService.compute(num)

        assertEquals(square, result)
    }
}