package com.example

import io.micronaut.context.annotation.Requires
import io.micronaut.core.util.StringUtils
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

import kotlin.math.pow
import kotlin.math.roundToInt

@MicronautTest
@Requires(property = "mockito.test.enabled", defaultValue = StringUtils.TRUE, value = StringUtils.TRUE)
class MathMockServiceTest {

    @Inject
    lateinit var mathService: MathService

    @ParameterizedTest
    @CsvSource("2,4", "3,9")
    fun testComputeNumToSquare(num: Double, square: Int) {
        whenever(mathService.compute(10))
            .then{ num.pow(2.0).roundToInt() }

        val result = mathService.compute(10)

        assertEquals( square, result )
        verify(mathService).compute(10)
    }

    @MockBean(MathServiceImpl::class)
    fun mathService() : MathService {
        return mock<MathService>{}
    }

}