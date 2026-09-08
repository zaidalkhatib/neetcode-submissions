class KthLargest {
    Queue<Integer> queue = new PriorityQueue<>((a, b) -> (a - b));
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int val : nums) {
            queue.add(val);
            if (queue.size() >k) {
                queue.remove();
            }
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > k) {
            queue.remove();
        }
        return queue.peek();
    }
}

/*



5
6
7

*/