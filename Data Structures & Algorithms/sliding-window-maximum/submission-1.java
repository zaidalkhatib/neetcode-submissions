class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> queue = new LinkedList<>();
        int start = 0;
        List<Integer> list = new ArrayList<>();
        for (int end = 0; end < nums.length; end++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[end]) {
                queue.removeLast();
            }
            queue.add(end);
            if (queue.getFirst() < start) {
                queue.removeFirst();
            }
            if ((end - start + 1) == k) {
                list.add(nums[queue.getFirst()]);
                start++;
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
[1,5,2,3]k=3
5,2,3,1
*/