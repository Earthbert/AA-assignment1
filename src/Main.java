import edit_distance.ClassicAlgorithm;
import edit_distance.EditDistanceOutput;
import edit_distance.TrieAlgorithm;
import input.Input;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private final static String TESTS_DIR = "input/";

    public static void main(String[] args) throws IOException {
        Scanner testInput = new Scanner(new File(TESTS_DIR + args[0]));
        Input input = new Input(testInput);
        String method = args[1];

        long startTime = System.nanoTime();
        ArrayList<EditDistanceOutput> foundWords = switch (method) {
            case "classic" -> ClassicAlgorithm.calculateEditDistances(input);
            case "trie" -> TrieAlgorithm.calculateEditDistances(input);
            default -> {
                System.out.println("Invalid method");
                yield null;
            }
        };
        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);
        Comparator<EditDistanceOutput> comparator = Comparator.comparing(EditDistanceOutput::getDistance).
                thenComparing(EditDistanceOutput::getWord);
        assert foundWords != null;
        foundWords.sort(comparator);
        FileWriter file = new FileWriter("output");

        file.write(foundWords.size() + "\n");
        for (EditDistanceOutput output : foundWords) {
            file.write(output.getWord() + "\n");
        }

        file.close();
    }
}
