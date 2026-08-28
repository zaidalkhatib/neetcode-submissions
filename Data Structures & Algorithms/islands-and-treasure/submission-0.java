class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int []> queue = new LinkedList<>();
        
        for(int i=0 ;i<grid.length ;i++){
            for(int j=0 ;j<grid[i].length ;j++){
                if(grid[i][j]==0){
                queue.add(new int []{i,j,0});
                }
            }
        }


        Set<String> seen = new HashSet<>();
        int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int [] curr = queue.remove();
            int row = curr[0];
            int col = curr[1];
            int dis = curr[2];
            String key = row + " "+ col;
            if(seen.contains(key)){
                continue;
            }
            seen.add(key);
            if(grid[row][col]==2147483647){
                grid[row][col]=dis;
            }
            for(int [] dir : dirs){
                int newRow = row+dir[0];
                int newCol = col+dir[1];
                if(newRow<0||newRow>=grid.length||newCol<0||newCol>=grid[0].length||grid[newRow][newCol]==-1){
                    continue;
                }
                queue.add(new int []{newRow,newCol,dis+1});
            }
        }
    }
}
