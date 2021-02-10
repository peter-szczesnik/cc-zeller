package com.peter.zellerbankingapplication.domain.util

import org.junit.Test
import org.junit.jupiter.api.Assertions.*


class ValidationKtTest {

    @Test
    fun test1() {
        var isValid = isAmountValid("")
        assert(isValid)
        assert(isAmountValid("2.2"))
        assert(!isAmountValid("0.0"))
        assert(!isAmountValid("."))
    }

    @Test
    fun test2() {
        assert(getAmount("2.2") == 2.20)
        assert(getAmount("") == 0.0)
    }

}

