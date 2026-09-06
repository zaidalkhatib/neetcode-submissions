class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i=0 ;i<board.length ;i++){
            for(int j=0; j<board[i].length ;j++){
                if(board[i][j]==word.charAt(0)){
                    if(backTrack(board,i,j,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean backTrack(char [][]board, int i,int j,String word,int index){
        if(i<0||i>=board.length ||j<0||j>=board[i].length||board[i][j]!=word.charAt(index)){
            return false;
        }
        if(word.charAt(index)==board[i][j]&&index==word.length()-1){
            return true;
        }
        char temp=board[i][j];
        board[i][j]='/';
        boolean left=backTrack(board,i+1,j,word,index+1);
        boolean right=backTrack(board,i-1,j,word,index+1);
        boolean up = backTrack(board,i,j+1,word,index+1);
        boolean down = backTrack(board,i,j-1,word,index+1);
        board[i][j]=temp;
        return left||right||up||down;
    }
}