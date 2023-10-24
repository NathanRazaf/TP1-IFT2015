import java.util.Arrays;

public class GridAndWords {
    private final char[][] chars;
    private final String[] words;

    public GridAndWords(char[][] chars, String[] words) {
        this.chars = chars;
        this.words = words;
    }

    public char[][] getChars() {
        return chars;
    }

    public String[] getWords() {
        return words;
    }

    @Override
    public String toString() {
        return "GridAndWords {" +
                "chars=" + Arrays.deepToString(chars) +
                ", words=" + Arrays.toString(words) +
                '}';
    }

}
