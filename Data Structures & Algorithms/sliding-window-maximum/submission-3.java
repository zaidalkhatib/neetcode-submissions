class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int start = 0;
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int end = 0; end < nums.length; end++) {
            while (!queue.isEmpty() && nums[end] >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(end);
            if (k == end - start + 1) {
                res[start] = nums[queue.getFirst()];
                if (queue.getFirst() == start) {
                    queue.removeFirst();
                }
                start++;
            }
        }

        return res;
    }

    /*
    2,1

    */
}
