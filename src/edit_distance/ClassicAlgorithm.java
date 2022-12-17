package edit_distance;

import java.util.ArrayList;

import input.Input;

public class ClassicAlgorithm {
    private static int levenshteinDistance(String str1, String str2) {
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

    public static ArrayList<EditDistanceOutput> calculateEditDistances(Input input) {
        String[] dictionary = input.getDictionary();
        ArrayList<EditDistanceOutput> output = new ArrayList<>();

        for (final String s : dictionary) {
            int distance = levenshteinDistance(s, input.getTargetWord());
            if (distance <= input.getMaxDistance()) {
                output.add(new EditDistanceOutput(distance, s));
            }
        }
        return output;
    }
}
