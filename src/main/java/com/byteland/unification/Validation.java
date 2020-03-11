package com.byteland.unification;

import java.util.Arrays;
import java.util.stream.IntStream;

class Validation {

    static final int MIN_TEST_CASE_COUNT = 1;
    static final int MAX_TEST_CASE_COUNT = 1000;
    static final int MIN_CITY_COUNT = 2;
    static final int MAX_CITY_COUNT = 600;

    boolean isNumberOfTestCasesValid(String numberOfTestCases) {
        if (isInteger(numberOfTestCases) && isNumberOfTestCaseIsInLimit(numberOfTestCases)) {
            return true;
        }
        System.out.println("Number of test cases value can be in " + MIN_TEST_CASE_COUNT + "-" + MAX_TEST_CASE_COUNT);
        return false;
    }

    boolean isNumberOfCitiesValid(String numberOfCities) {
        if (isInteger(numberOfCities) && isNumberOfCitiesIsInLimit(numberOfCities)) {
            return true;
        }
        System.out.println("Number of cities value can be in " + MIN_CITY_COUNT + "-" + MAX_CITY_COUNT);
        return false;
    }

    private boolean isNumberOfTestCaseIsInLimit(String numberOfTestCases) {
        int numberOfTestCasesIntVal = Integer.parseInt(numberOfTestCases);
        return MIN_TEST_CASE_COUNT <= numberOfTestCasesIntVal && MAX_TEST_CASE_COUNT >= numberOfTestCasesIntVal;
    }

    private boolean isNumberOfCitiesIsInLimit(String numberOfCities) {
        int numberOfCitiesIntVal = Integer.parseInt(numberOfCities);
        return MIN_CITY_COUNT <= numberOfCitiesIntVal && MAX_CITY_COUNT >= numberOfCitiesIntVal;
    }

    private boolean isInteger(String numberOfTestCases) {
        try {
            Integer.parseInt(numberOfTestCases);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isRoadsValid(String[] roads, Integer numberOfCities) {
        boolean containsNotValidIntegerValue = Arrays.stream(roads)
                .anyMatch(item -> (!isInteger(item) || numberOfCities <= Integer.parseInt(item)));
        if (!containsNotValidIntegerValue && numberOfCities.equals(roads.length + 1)) {
            return IntStream.range(0, roads.length - 1).
                    noneMatch(r -> String.valueOf(r + 1).equals(roads[r]));
        }
        System.out.println("Number of roads must be (Number of Cities -1)");
        return false;
    }
}
