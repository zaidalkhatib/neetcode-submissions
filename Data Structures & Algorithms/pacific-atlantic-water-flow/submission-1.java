class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                Queue<int[]> queue = new LinkedList<>();
                Set<String> seen = new HashSet<>();
                queue.add(new int[] {i, j});
                boolean atlanticFound = false;
                boolean pecificFound = false;
                while (!queue.isEmpty()) {
                    int[] curr = queue.remove();
                    int row = curr[0];
                    int col = curr[1];
                    String key = row + " " + col;
                    if (seen.contains(key)) {
                        continue;
                    }
                    seen.add(key);

                    for (int[] dir : dirs) {
                        int newRow = dir[0] + row;
                        int newCol = dir[1] + col;
                        if (newRow < 0 || newCol < 0) {
                            pecificFound = true;
                        }
                        if (newRow >= heights.length || newCol >= heights[0].length) {
                            atlanticFound = true;
                        }
                        if (newRow < 0 || newRow >= heights.length || newCol < 0
                            || newCol >= heights[0].length
                            || heights[row][col] < heights[newRow][newCol]) {
                            continue;
                        }
                        queue.add(new int[] {newRow, newCol});
                    }
                    if (atlanticFound && pecificFound) {
                        res.add(List.of(i, j));
                        break;
                    }
                }
            }
        }
        return res;
    }
}
