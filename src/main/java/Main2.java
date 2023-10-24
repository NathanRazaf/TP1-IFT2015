import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {

        ArrayList<GridAndWords> wholeFile = readFile(args[0]);
        int i=1;
        assert wholeFile != null;

        long startTime = System.nanoTime();

        for (GridAndWords gridAndWords : wholeFile) {
            System.out.println("Query "+i+":");
            i++;
            new TrieGridTraversal(gridAndWords.getChars(), gridAndWords.getWords()).findWords();
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Trie execution time in nanoseconds: " + timeElapsed);
        System.out.println("Trie execution time in milliseconds: " + timeElapsed / 1000000);
    }

    public static ArrayList<GridAndWords> readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int height;
            int width;
            ArrayList<GridAndWords> wholeFile = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {  // Check if line is not null here
                // Skip empty lines or lines with just whitespaces
                if (line.trim().isEmpty()) {
                    continue;
                }

                height = Integer.parseInt(line.split(" ")[0]);
                width = Integer.parseInt(line.split(" ")[1]);
                char[][] matrix = new char[height][width];

                for (int i = 0; i < height; i++) {
                    line = br.readLine();
                    while (line != null && line.trim().isEmpty()) {  // Skip empty lines
                        line = br.readLine();
                    }
                    for (int j = 0; j < width; j++) {
                        matrix[i][j] = line.split(" ")[j].charAt(0);
                    }
                }

                line = br.readLine();
                while (line != null && line.trim().isEmpty()) {  // Skip empty lines
                    line = br.readLine();
                }
                String[] wordsLine = line.split(" ");

                GridAndWords charsAndWords = new GridAndWords(matrix, wordsLine);
                wholeFile.add(charsAndWords);
            }

            return wholeFile;
        } catch (IOException e) {
            System.out.println("Unable to read file " + fileName);
        }
        return null;
    }

}
