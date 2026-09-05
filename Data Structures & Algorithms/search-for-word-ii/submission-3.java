class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();

        // Build Trie from words
        for (String word : words) {
            Node curr = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (curr.letters[index] == null) {
                    curr.letters[index] = new Node();
                }

                curr = curr.letters[index];
            }

            curr.word = word;
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }

        return res;
    }

    private void dfs(
        char[][] board,
        int i,
        int j,
        Node curr,
        List<String> res
    ) {

        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            board[i][j] == '#') {
            return;
        }

        char ch = board[i][j];

        // No word starts with this path
        if (curr.letters[ch - 'a'] == null) {
            return;
        }

        curr = curr.letters[ch - 'a'];

        // Found a complete word
        if (curr.word != null) {
            res.add(curr.word);

            // Prevent duplicate result
            curr.word = null;
        }

        // mark visited
        board[i][j] = '#';

        dfs(board, i + 1, j, curr, res);
        dfs(board, i - 1, j, curr, res);
        dfs(board, i, j + 1, curr, res);
        dfs(board, i, j - 1, curr, res);

        // backtrack
        board[i][j] = ch;
    }

    static class Node {
        Node[] letters = new Node[26];
        String word;
    }
}