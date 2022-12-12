import edit_distance.ClassicAlgorithm;
import edit_distance.TrieAlgorithm;
import input.Input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final static String TESTS_DIR = "input/";

    public static void main(String[] args) {
        System.out.println("Type name of input file:");
        Scanner stdInput = new Scanner(System.in);
        String inputFileName = stdInput.next();
        Input input;
        try {
            Scanner testInput = new Scanner(new File(TESTS_DIR + inputFileName));
            input = new Input(testInput);
            System.out.println("Chose preferred method(trie or classic):");
            String method = stdInput.next();
            ArrayList<String> foundWords = switch (method) {
                case "classic" ->
                    ClassicAlgorithm.calculateEditDistances(input);
                case "trie" ->
                    TrieAlgorithm.calculateEditDistances(input);
                default -> {
                    System.out.println("Invalid method");
                    yield null;
                }
            };
            System.out.println(foundWords);
        } catch (FileNotFoundException e) {
            System.err.println("FILE INPUT ERROR");
            System.exit(-1);
        }
    }
}
