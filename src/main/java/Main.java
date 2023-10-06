import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<GridAndWords> wholeFile = readFile(args[0]);
        for (GridAndWords gridAndWords : wholeFile) {
            System.out.println("\u001b[34m"+gridAndWords.toString()+"\u001b[0m"); //color text in blue
        }

    }

    public static ArrayList<GridAndWords> readFile(String fileName) { // reads the file provided with a buffer line by line
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int height;
            int width;
            ArrayList<GridAndWords> wholeFile = new ArrayList<>();
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                height = Integer.parseInt(line.split(" ")[0]);
                width = Integer.parseInt(line.split(" ")[1]);
                char[][] matrix = new char[height][width];
                for (int i = 0; i < height; i++) {
                    line = br.readLine();
                    for (int j = 0; j < width; j++) {
                        matrix[i][j] = line.split(" ")[j].charAt(0);
                    }
                }
                String[] wordsLine = br.readLine().split(" ");
                GridAndWords charsAndWords = new GridAndWords(matrix, wordsLine);
                wholeFile.add(charsAndWords);
            }

            return wholeFile;
        } catch(IOException e) {
            System.out.println("Unable to read file " + fileName);
        }
        return null;
    }
}