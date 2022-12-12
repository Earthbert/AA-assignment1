package input;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {
    private final int maxDistance;
    private final String targetWord;
    private final String[] dictionary;

    public Input(Scanner testInput) throws FileNotFoundException {
        int numWords = testInput.nextInt();
        dictionary = new String[numWords];
        maxDistance = testInput.nextInt();
        targetWord = testInput.next();
        for (int i = 0; i < numWords; i++) {
            dictionary[i] = testInput.next();
        }
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public String getTargetWord() {
        return targetWord;
    }

    public String[] getDictionary() {
        return dictionary;
    }
}
