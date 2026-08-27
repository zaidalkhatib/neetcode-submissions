class Solution {
    int counter = 0;
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int count=4;
                    int above = i - 1;
                    int below = i + 1;
                    int left = j - 1;
                    int right = j + 1;
                    if (above >= 0 && grid[above][j] == 1) {
                        count -= 1;
                    }
                    if (below < grid.length && grid[below][j] == 1) {
                        count -= 1;
                    }
                    if (left >= 0 && grid[i][left] == 1) {
                        count -= 1;
                    }
                    if (right < grid[0].length && grid[i][right] == 1) {
                        count -= 1;
                    }
                    // System.out.println(count);
                    res+=count;
                }
            }
        }
        return res;
    }
}

// [1,1,0,0] 2 3
// [1,0,0,0]2 
// [1,1,1,0]2 2 2
// [0,0,1,1] 2 3