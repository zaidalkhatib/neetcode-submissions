class Solution {
    public int swimInWater(int[][] grid) {
        // grid[][]
        Queue<int[]> queue = new PriorityQueue<>((a,b)->(grid[a[0]][a[1]]-grid[b[0]][b[1]]));
        queue.add(new int[]{0,0});
        int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int res=0;
        Set<String> seen = new HashSet<>();
        while(!queue.isEmpty()){
            int [] currArr = queue.remove();
            int row = currArr[0];
            int col = currArr[1];
            String key = row+""+col;
            if(seen.contains(key)){
                continue;
            }
            seen.add(key);
            res=Math.max(grid[row][col],res);
            if(row==grid.length-1&&col==grid[0].length-1){
                return res;
            }
            for(int [] dir : dirs){
                int newRow = row+dir[0];
                int newCol = col+dir[1];
                if(newRow<0||newRow>=grid.length||newCol<0||newCol>=grid[0].length){
                    continue;
                }
                queue.add(new int []{newRow,newCol});
            }
        }
        
        return 0;
    }
}
