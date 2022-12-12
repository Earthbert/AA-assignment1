package edit_distance;

import java.util.ArrayList;

import input.Input;
import utils.Utils;

public class ClassicAlgorithm {
    private static int levenshteinDistance(String str1, String str2) {
        // Create distances matrix
        int[][] dm = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) {
                    dm[i][j] = j;
                } else if (j == 0) {
                    dm[i][j] = i;
                } else {
                    dm[i][j] = Utils.minEdits(
                            (dm[i - 1][j - 1] + Utils.IfSame(str1.charAt(i - 1), str2.charAt(j - 1))), // replace
                            (dm[i - 1][j] + 1), // delete
                            (dm[i][j - 1] + 1) // insert
                    );
                }
            }
        }
        return dm[str1.length()][str2.length()];
    }

    public static ArrayList<String> calculateEditDistances(Input input) {
        String[] dictionary = input.getDictionary();
        ArrayList<String> output = new ArrayList<>();

        for (final String s : dictionary) {
            if (levenshteinDistance(s, input.getTargetWord()) <= input.getMaxDistance()) {
                output.add(s);
            }
        }
        return output;
    }
}
