package com.platzi.javatests.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DateUtilLeapYearShould {

    @Test
    void returnTrueWhenYearIsDivisibleBy400() {
        Assertions.assertTrue(DateUtil.isLeapYear(1600));
        Assertions.assertTrue(DateUtil.isLeapYear(2000));
        Assertions.assertTrue(DateUtil.isLeapYear(2400));
    }

    @Test
    public void returnFalseWhenYearIsDivisibleBy100ButNotBy400() {
        Assertions.assertFalse(DateUtil.isLeapYear(1700));
        Assertions.assertFalse(DateUtil.isLeapYear(1800));
        Assertions.assertFalse(DateUtil.isLeapYear(1900));
    }

    @Test
    void returnTrueWheYearIsDivisibleBy4ButNotBy100() {
        Assertions.assertTrue(DateUtil.isLeapYear(1996));
        Assertions.assertTrue(DateUtil.isLeapYear(2004));
        Assertions.assertTrue(DateUtil.isLeapYear(2008));
    }

    @Test
    void returnFalseIfYearIsNotDivisibleBy4() {
        Assertions.assertFalse(DateUtil.isLeapYear(2017));
        Assertions.assertFalse(DateUtil.isLeapYear(2018));
        Assertions.assertFalse(DateUtil.isLeapYear(2019));
    }
}