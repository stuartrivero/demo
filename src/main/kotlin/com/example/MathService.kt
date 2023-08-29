package com.example

import jakarta.inject.Singleton

interface MathService {
    fun compute(num: Int): Int
}

@Singleton
class MathServiceImpl : MathService {
    override fun compute(num: Int): Int = num * 4
}