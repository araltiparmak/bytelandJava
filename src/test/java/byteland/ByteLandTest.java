package byteland;

import com.byteland.unification.ByteLand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByteLandTest {

    private final int[][] ROUTES = {new int[]{0, 1}, new int[]{0, 1, 2, 0, 0, 3, 3},
            new int[]{0, 1, 1, 1, 1, 0, 2, 2}, new int[]{0, 1, 1, 1, 0, 1, 0, 1, 2, 3, 1, 1, 1},
            new int[]{0, 1, 0, 1, 0, 1, 0}, new int[]{0, 2, 1, 0, 1, 0, 0, 2, 2, 2, 1, 1},
            new int[]{0, 1, 2, 2, 2, 2, 2, 2, 1, 1}, new int[]{2, 0, 4, 0, 0, 4, 5, 5, 2},
            new int[]{0, 11, 6, 6, 4, 1, 11, 1, 7, 3, 0, 10, 7, 4, 2, 10}};

    private final int[] EXPECTED_RESULTS = {2, 4, 5, 9, 4, 5, 7, 5, 5};

    @Test
    public void unifyTest() {

        int j = 0;
        for (int[] i : ROUTES) {

            ByteLand byteLand = new ByteLand();

            assertEquals(byteLand.unify(i.length + 1, i), EXPECTED_RESULTS[j++]);

        }

    }
}
