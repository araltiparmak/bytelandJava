package com.byteland.unification;

import java.util.Arrays;
import java.util.stream.Stream;

class Validation {
    static final int MIN_TEST_CASE_COUNT = 1;
    static final int MAX_TEST_CASE_COUNT = 1000;
    static final int MIN_CITY_COUNT = 2;
    static final int MAX_CITY_COUNT = 600;

    boolean isNumberOfTestCasesValid(String numberOfTestCases) {
        if (isInt(numberOfTestCases) && isNumberOfTestCaseIsInLimit(numberOfTestCases)) {
            return true;
        }
        System.out.println("Number of test cases value can be in " + MIN_TEST_CASE_COUNT + "-" + MAX_TEST_CASE_COUNT);
        return false;
    }

    boolean isNumberOfCitiesValid(String numberOfCities) {
        if (isInt(numberOfCities) && isNumberOfCitiesIsInLimit(numberOfCities)) {
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

    private boolean isInt(String numberOfTestCases) {
        try {
            Integer.parseInt(numberOfTestCases);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isRoadsValid(String[] roadsArray, Integer numberOfCities) {
        Stream<String> roadsStream = Arrays.stream(roadsArray);
        boolean containsNotValidIntegerValue = roadsStream.anyMatch(item -> (!isInt(item) || numberOfCities <= Integer.valueOf(item)));
        if (!containsNotValidIntegerValue && numberOfCities.equals(roadsArray.length + 1)) {
            return true;
        }
        System.out.println("Number of roads must be (Number of Cities -1)");
        return false;
    }
}
