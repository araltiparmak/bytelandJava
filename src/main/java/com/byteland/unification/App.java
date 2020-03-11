package com.byteland.unification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final Validation validation = new Validation();

        int numberOfTestCases = askNumberOfTestCases(br, validation);

        while (numberOfTestCases != 0) {

            int numberOfCities = askNumberOfCities(br, validation);

            int[] p = askRoadsBetweenCities(br, validation, numberOfCities);

            final ByteLand byteLand = new ByteLand();
            int stepCount = byteLand.unify(p);

            System.out.println("Total steps:" + stepCount);
            numberOfTestCases--;
        }
    }

    private static int askNumberOfTestCases(BufferedReader br, Validation validation) throws IOException {
        String numberOfTestCasesStr;
        do {
            System.out.print("Number of test cases: ");
            numberOfTestCasesStr = br.readLine();
        }
        while (!validation.isNumberOfTestCasesValid(numberOfTestCasesStr));

        return Integer.parseInt(numberOfTestCasesStr);
    }


    private static int askNumberOfCities(BufferedReader br, Validation validation) throws IOException {
        String numberOfCitiesStr;
        do {
            System.out.print("Number of cities: ");
            numberOfCitiesStr = br.readLine();
        }
        while (!validation.isNumberOfCitiesValid(numberOfCitiesStr));

        return Integer.parseInt(numberOfCitiesStr);
    }

    private static int[] askRoadsBetweenCities(BufferedReader br, Validation validation, Integer numberOfCities) throws IOException {
        String[] roadsArray;
        do {
            System.out.print("Roads between cities: ");
            String roads = br.readLine();
            roadsArray = roads.split("\\s");
        }
        while (!validation.isRoadsValid(roadsArray, numberOfCities));

        return Arrays.stream(roadsArray)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}