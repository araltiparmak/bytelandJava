package com.byteland.unification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidationTest {

    Validation validation = new Validation();

    @Test
    void isNumberOfTestCasesValid() {

        assertTrue(validation.isNumberOfTestCasesValid(String.valueOf(Validation.MIN_TEST_CASE_COUNT)));
        assertTrue(validation.isNumberOfTestCasesValid(String.valueOf(Validation.MAX_TEST_CASE_COUNT)));
        assertTrue(validation.isNumberOfTestCasesValid("2"));
        assertTrue(validation.isNumberOfTestCasesValid("500"));

        assertFalse(validation.isNumberOfTestCasesValid(String.valueOf(Validation.MIN_TEST_CASE_COUNT - 1)));
        assertFalse(validation.isNumberOfTestCasesValid(String.valueOf(Validation.MAX_TEST_CASE_COUNT + 1)));
        assertFalse(validation.isNumberOfTestCasesValid("0"));
        assertFalse(validation.isNumberOfTestCasesValid("-1"));
        assertFalse(validation.isNumberOfTestCasesValid("1001"));
        assertFalse(validation.isNumberOfTestCasesValid("abc"));
        assertFalse(validation.isNumberOfTestCasesValid("1abc2"));
    }

    @Test
    void isNumberOfCitiesValid() {
        assertTrue(validation.isNumberOfCitiesValid(String.valueOf(Validation.MIN_CITY_COUNT)));
        assertTrue(validation.isNumberOfCitiesValid(String.valueOf(Validation.MAX_CITY_COUNT)));
        assertTrue(validation.isNumberOfCitiesValid("300"));

        assertFalse(validation.isNumberOfCitiesValid(String.valueOf(Validation.MIN_CITY_COUNT - 1)));
        assertFalse(validation.isNumberOfCitiesValid(String.valueOf(Validation.MAX_CITY_COUNT + 1)));
        assertFalse(validation.isNumberOfCitiesValid("0"));
        assertFalse(validation.isNumberOfCitiesValid("-2"));
        assertFalse(validation.isNumberOfCitiesValid("601"));
    }

    @Test
    void isRoadsValid() {
        assertTrue(validation.isRoadsValid(new String[]{"0", "1", "2"}, 4));
        assertTrue(validation.isRoadsValid(new String[]{"0", "1", "2", "0", "0", "3", "3"}, 8));

        assertFalse(validation.isRoadsValid(new String[]{"0", "2"}, 4));
        assertFalse(validation.isRoadsValid(new String[]{"0", "a"}, 3));

        //todo: fix this
        assertFalse(validation.isRoadsValid(new String[]{"1", "1"}, 3));
    }
}