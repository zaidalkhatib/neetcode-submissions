class Solution {
    
    public int uniquePaths(int m, int n) {
        int [][] map = new int [m][n];
        for(int [] arr : map){
            Arrays.fill(arr,-1);
        }
        return helper(0,0,m,n,map);
    }

    private int helper(int i,int j,int m,int n,int [][] map){

        if(i<0||i>=m||j<0||j>=n){
            return 0;
        }
        if(map[i][j]!=-1){
            return map[i][j];
        }
        if(i==m-1&&j==n-1){
            return 1;
        }

        int res= helper(i+1,j,m,n,map)+helper(i,j+1,m,n,map);
        map[i][j]=res;
        return res;
    }
}
