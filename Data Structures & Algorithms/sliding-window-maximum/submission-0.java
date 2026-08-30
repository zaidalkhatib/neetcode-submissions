class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a,b)->(nums[b]-nums[a]));
        int start = 0;
        List<Integer> list = new ArrayList<>();
        for (int end = 0; end < nums.length; end++) {
            queue.add(end);
            if((end-start+1)==k){
                list.add(nums[queue.peek()]);
                queue.remove(start++);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}


/*
queue = [2,1,1]


*/