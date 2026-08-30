class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // row
                if (board[i][j] != '.') {
                    if (!rows.add(board[i][j])) {
                        return false;
                    }

                    String key = i / 3 + " " + j / 3;
                    if (!map.containsKey(key)) {
                        map.put(key, new HashSet<>());
                    }

                    if (!map.get(key).add(board[i][j])) {
                        return false;
                    }
                }

                // column
                if (board[j][i] != '.') {
                    if (!cols.add(board[j][i])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
