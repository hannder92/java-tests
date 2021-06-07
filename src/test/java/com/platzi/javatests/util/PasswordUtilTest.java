package com.platzi.javatests.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest {

    @Test
    void weakWhenHasLessThan8Letters() {
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("123!as7"));
    }

    @Test
    void weakWhenHasOnlyLetters() {
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("abcdefghi"));
    }

    @Test
    void mediumWhenHasLettersAndNumbers() {
        assertEquals(PasswordUtil.SecurityLevel.MEDIUM, PasswordUtil.assessPassword("abcdef12345ghi"));
    }

    @Test
    void strongWhenHasLettersAndNumbersAndSymbols() {
        assertEquals(PasswordUtil.SecurityLevel.STRONG, PasswordUtil.assessPassword("abcdef12345ghi!"));
    }
}