import java.util.Arrays;

public class GridAndWords {
    private char[][] chars;
    private String[] words;

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

    public void setChars(char[][] chars) {
        this.chars = chars;
    }

    public void setWords(String[] words) {
        this.words = words;
    }
}
