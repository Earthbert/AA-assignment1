package edit_distance;

import java.util.Arrays;

class Utils {
    static int minEdits(int... nums) {
        return Arrays.stream(nums).min().orElse(Integer.MAX_VALUE);
    }

    static int IfSame(char c1, char c2) {
        return c1 == c2 ? 0 : 1;
    }
}
