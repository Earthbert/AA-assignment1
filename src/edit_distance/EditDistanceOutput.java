package edit_distance;

public class EditDistanceOutput {
    private final int distance;
    private final String word;

    public EditDistanceOutput(final int distance, final String word) {
        this.distance = distance;
        this.word = word;
    }

    public int getDistance() {
        return distance;
    }

    public String getWord() {
        return word;
    }
}
