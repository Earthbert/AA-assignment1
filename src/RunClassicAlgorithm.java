import edit_distance.ClassicAlgorithm;
import edit_distance.EditDistanceOutput;
import input.Input;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RunClassicAlgorithm {
    private final static String INPUT_FILE = "in/test6.in";
    private final static String OUTPUT_FILE = "output/test6.out";

    public static void main(String[] args) throws IOException {
        Scanner testInput = new Scanner(new File(INPUT_FILE));
        Input input = new Input(testInput);

        long startTime = System.nanoTime();
        ArrayList<EditDistanceOutput> foundWords = ClassicAlgorithm.calculateEditDistances(input);
        long endTime = System.nanoTime();

        System.out.println(TimeUnit.NANOSECONDS.toMillis(endTime - startTime));

        Comparator<EditDistanceOutput> comparator = Comparator.comparing(EditDistanceOutput::getDistance).
                thenComparing(EditDistanceOutput::getWord);

        foundWords.sort(comparator);
        FileWriter file = new FileWriter(OUTPUT_FILE);

        file.write(foundWords.size() + "\n");
        for (EditDistanceOutput output : foundWords) {
            file.write(output.getWord() + "\n");
        }

        file.close();
    }
}
