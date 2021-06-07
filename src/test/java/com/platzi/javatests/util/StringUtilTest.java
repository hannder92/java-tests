package com.platzi.javatests.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    void repeatStringOnce() {
        Assertions.assertEquals("hola", StringUtil.repeat("hola", 1));
    }


    @Test
    void repeatStringMultipleTimes() {
        Assertions.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    void repeatStringZeroTimes() {
        Assertions.assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test
    void repeatStringNegativeTimes() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            StringUtil.repeat("hola", -1);
        });
    }

}