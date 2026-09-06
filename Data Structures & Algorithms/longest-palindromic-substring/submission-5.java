class Solution {
    public String longestPalindrome(String s) {
        int maxLen=0;
        int leftMax=-1;
        int rightMax=-1;
        for(int i=0 ;i<s.length() ;i++){
            int left=i;
            int right=i;
            while(right<s.length()&&left>=0&&s.charAt(left)==s.charAt(right)){
                if(right-left+1>maxLen){
                    maxLen=right-left+1;
                    leftMax=left;
                    rightMax=right;
                }
                left--;
                right++;
            }

            left=i;
            right=i+1;
            while(right<s.length()&&left>=0&&s.charAt(left)==s.charAt(right)){
                if(right-left+1>maxLen){
                    maxLen=right-left+1;
                    leftMax=left;
                    rightMax=right;
                }
                left--;
                right++;
            }
        }
        return s.substring(leftMax,rightMax+1);
    }
}
//ababdd 