package com.byteland.unification;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ByteLandTest {

    final ByteLand byteLand = new ByteLand();

    @Test
    public void unifyTest() {
        for (int i = 0; i < ROUTES.length; i++) {
            assertEquals(byteLand.unify(ROUTES[i]), EXPECTED_RESULTS[i]);
        }
    }

    private final int[][] ROUTES = {
            new int[]{0, 1},
            new int[]{0, 1, 2, 0, 0, 3, 3},
            new int[]{0, 1, 1, 1, 1, 0, 2, 2},
            new int[]{0, 1, 1, 1, 0, 1, 0, 1, 2, 3, 1, 1, 1},
            new int[]{0, 1, 0, 1, 0, 1, 0},
            new int[]{0, 2, 1, 0, 1, 0, 0, 2, 2, 2, 1, 1},
            new int[]{0, 1, 2, 2, 2, 2, 2, 2, 1, 1},
            new int[]{2, 0, 4, 0, 0, 4, 5, 5, 2},
            new int[]{0, 11, 6, 6, 4, 1, 11, 1, 7, 3, 0, 10, 7, 4, 2, 10}};

    private final int[] EXPECTED_RESULTS = {2, 4, 5, 9, 4, 5, 7, 5, 5};
}