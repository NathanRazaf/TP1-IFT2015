public class GridTraversal {
    private final char[][] grid; // The 2D grid of characters representing the word search.
    private final int m;
    private final int n; // Dimensions of the grid: m rows and n columns.

    private static final int[][] DIRECTIONS = {{-1,-1}, {-1, 0}, {-1, 1}, {0, -1}, {0,0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public GridTraversal(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
    }

    // Method to find and print all paths of a given word in the grid.
    public void findWord(String word) {
        // Iterate through every cell in the grid.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the first character of the word matches the current cell,
                // start a depth-first search from this cell.
                if (grid[i][j] == word.charAt(0)) {
                    dfs(i, j, word, 0, "");
                }
            }
        }
    }

    // Method to find and print all paths of all words provided in the grid.
    public void findWords(String[] words) {
        for (String word : words) {
            findWord(word);
        }
    }

    // Recursive depth-first search method to find a word in the grid from a starting point (i, j)
    private void dfs(int i, int j, String word, int wordIndex, String currentPath) {
        // Base case: Check if the current cell is out of the grid bounds or if the character
        // in the current cell does not match the corresponding character in the word
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != word.charAt(wordIndex)) {
            return; // If any of these conditions are true, this path is invalid
        }

        // Append the current cell's coordinates to the path
        currentPath += "(" + i + "," + j + ")";

        // If we have reached the last character of the word, we've found a complete path
        if (wordIndex == word.length() - 1) {
            System.out.println(word + " " + currentPath); // Print the found word and its path
            return; // Exit the recursion for this path since the word is fully matched
        }

        // Recur in all possible directions.
        for (int[] dir : DIRECTIONS) {
            // Move to the next cell in the direction specified by 'dir'
            // Increase the 'wordIndex' to match the next character in the word
            // Append an arrow and continue building the 'currentPath'
            dfs(i + dir[0], j + dir[1], word, wordIndex + 1, currentPath + "->");
        }
        // After trying all directions, the method call for this cell will end
        // going back to the previous cell in the path (backtracking)
    }
}
