class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        LinkedList<int[]> list2 = new LinkedList<>();
        int count=0;
        for (int[] interval : intervals) {
            if (list2.isEmpty()) {
                list2.addLast(interval);
            } else if (isOverLap(list2.getLast(), interval)) {
                list2.getLast()[0] = Math.max(list2.getLast()[0], interval[0]);
                list2.getLast()[1] = Math.min(list2.getLast()[1], interval[1]);
                count++;
            } else {
                list2.addLast(interval);
            }
        }
        return count++;
    }

    private static boolean isOverLap(int[] a, int[] b) {
        int start = Math.max(a[0], b[0]);
        int end = Math.min(a[1], b[1]);
        return start<end;
    }
}
