package utils;

import java.util.Arrays;

public class Utils {
    public static int minEdits(int... nums) {
        return Arrays.stream(nums).min().orElse(Integer.MAX_VALUE);
    }

    public static int IfSame(char c1, char c2) {
        return c1 == c2 ? 0 : 1;
    }
}
