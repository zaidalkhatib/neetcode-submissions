class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int ones=0;
        for(int i=0 ;i<grid.length ;i++){
            for(int j=0 ;j<grid[i].length ;j++){
                if(grid[i][j]==2){
                queue.add(new int []{i,j,0});
                }else if(grid[i][j]==1){
                    ones++;
                }
            }
        }
        if(queue.isEmpty()){
            if(ones>0){
                return -1;
            }
            return 0;
        }
        Set<String> seen = new HashSet<>();
        int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int res=-1;
        while(!queue.isEmpty()){
            int [] curr = queue.remove();
            int row = curr[0];
            int col = curr[1];
            int min = curr[2];
            res=min;
            for(int [] dir : dirs){
                int newRow = row +dir[0];
                int newCol = col +dir[1];
                if(newRow<0||newRow>=grid.length||newCol<0||newCol>=grid[0].length||grid[newRow][newCol]!=1){
                    continue;
                }
                grid[newRow][newCol]=2;
                ones--;
                queue.add(new int []{newRow,newCol,min+1});
            }
        }

        return ones==0?res:-1;
    }
}
