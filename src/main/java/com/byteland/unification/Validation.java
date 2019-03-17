package com.byteland.unification;

public class Validation {
    private static final int MIN_TEST_CASE_COUNT = 1;
    private static final int MAX_TEST_CASE_COUNT = 1000;
    private static final int MIN_CITY_COUNT = 2;
    private static final int MAX_CITY_COUNT = 600;

    public void isNumberOfTestCasesValid(String numberOfTestCases) {
        if (!(isInt(numberOfTestCases) && isNumberOfTestCaseIsInLimit(numberOfTestCases))) {
            System.out.println("Number of test cases value can be in " + MIN_TEST_CASE_COUNT + "-" + MAX_TEST_CASE_COUNT);
            System.exit(0);
        }
    }

    public void isNumberOfCitiesValid(String numberOfTestCases) {
        if (!(isInt(numberOfTestCases) && isNumberOfCitiesIsInLimit(numberOfTestCases))) {
            System.out.println("Number of cities value can be in " + MIN_CITY_COUNT + "-" + MAX_CITY_COUNT);
            System.exit(0);
        }
    }

    private boolean isNumberOfCitiesIsInLimit(String numberOfCities) {
        int numberOfCitiesIntVal = Integer.parseInt(numberOfCities);
        return MIN_CITY_COUNT < numberOfCitiesIntVal && MAX_CITY_COUNT > numberOfCitiesIntVal;
    }

    private boolean isNumberOfTestCaseIsInLimit(String numberOfTestCases) {
        int numberOfTestCasesIntVal = Integer.parseInt(numberOfTestCases);
        return MIN_TEST_CASE_COUNT <= numberOfTestCasesIntVal && MAX_TEST_CASE_COUNT >= numberOfTestCasesIntVal;
    }

    private boolean isInt(String numberOfTestCases) {
        if (numberOfTestCases.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(numberOfTestCases);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
