import java.util.*;

public class TrieGridTraversal {
    private final char[][] grid;
    private final int m;
    private final int n;
    private final Trie trie; // The trie to store the words.
    private final List<String> foundWords; // The structure to store the words and their paths.

    private static final int[][] DIRECTIONS = {{-1,-1}, {-1, 0}, {-1, 1}, {0, -1}, {0,0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public TrieGridTraversal(char[][] grid, String[] words) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        this.trie = new Trie(); // Initialize the trie.
        foundWords = new ArrayList<>();
        // Add words to the trie.
        for (String word : words) {
            trie.insert(word);
        }
    }

    // Method to find and print all paths of all words in the grid.
    public void findWords() {
        // Start the grid traversal from each cell.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, trie.getRoot(), "", new StringBuilder());
            }
        }
        printWordsInOrder();
    }

    // The DFS method now also takes the current trie node and the current path.
    private void dfs(int i, int j, TrieNode currentNode, String currentWord, StringBuilder currentPath) {
        if (i < 0 || i >= m || j < 0 || j >= n || !currentNode.children.containsKey(grid[i][j])) {
            return;
        }

        char currentChar = grid[i][j];
        TrieNode nextNode = currentNode.children.get(currentChar);

        currentWord += currentChar;
        StringBuilder newPath = new StringBuilder(currentPath);
        newPath.append("(").append(i).append(",").append(j).append(")");

        if (nextNode.endOfWord) {
            foundWords.add(currentWord + " " + newPath);
        }


        for (int[] dir : DIRECTIONS) {
            dfs(i + dir[0], j + dir[1], nextNode, currentWord, new StringBuilder(newPath).append("->"));
        }
    }

    // Method to print words and their paths in alphabetical order.
    private void printWordsInOrder() {
        Collections.sort(foundWords);
        for (String wordWithPath : foundWords) {
            System.out.println(wordWithPath);
        }
    }

    private void printWords() {
        for (String wordWithPath : foundWords) {
            System.out.println(wordWithPath);
        }
    }


}

