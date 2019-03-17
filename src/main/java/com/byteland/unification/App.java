package com.byteland.unification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class App {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Validation validation = new Validation();
		String numberOfTestCasesString = br.readLine();
		validation.isNumberOfTestCasesValid(numberOfTestCasesString);

		int numberOfTestCases = Integer.parseInt(numberOfTestCasesString);
		while (numberOfTestCases != 0) {
			String cityCountString = br.readLine();

			validation.isNumberOfCitiesValid(cityCountString);

			Integer cityCount = Integer.parseInt(cityCountString);

			String roads = br.readLine();
			String[] items = roads.split("\\s");

			int[] p = Arrays.stream(items).mapToInt(Integer::parseInt).toArray();

			ByteLand byteLand = new ByteLand();
			int stepCount = byteLand.unify(cityCount, p);

			System.out.println("total step:" + stepCount);
			numberOfTestCases--;

		}
	}

}
