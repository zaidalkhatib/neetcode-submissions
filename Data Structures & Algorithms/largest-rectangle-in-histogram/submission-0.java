class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max=0;
        for(int i=0 ;i<heights.length ;i++){
            int index =i;
            while(!stack.isEmpty()&&stack.peek()[1]>heights[i]){
                int [] top = stack.pop();
                int height = top[1];
                index = top[0];
                max=Math.max(max,(i-index)*height);
            }
            stack.push(new int []{index,heights[i]});
        }


        while(!stack.isEmpty()){
            int [] top = stack.pop();
            max=Math.max(max,(heights.length-top[0])*top[1]);
        }
        return max;
    }
}
