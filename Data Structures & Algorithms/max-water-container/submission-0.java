class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j = heights.length-1;
        int max = 0;
        while(i<j){
            int height = Math.min(heights[i],heights[j]);
            int wedith = j-i;
            max = Math.max(max,height*wedith);
            if(heights[i]>heights[j]){
                j--;
            }else{
                i++;
            }
        }
        return max;
    }
}
