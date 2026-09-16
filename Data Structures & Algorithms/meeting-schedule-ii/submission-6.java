/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals,(a,b)->(a.start-b.start));
        Queue<Interval> queue = new PriorityQueue<>((a,b)->(a.end-b.end));
        for(int i=0 ;i<intervals.size() ;i++){
            if(!queue.isEmpty()&&queue.peek().end<=intervals.get(i).start){
                queue.remove();
            }
            queue.add(intervals.get(i));
        }
        return queue.size();
    }
}

/*

(0,40),(5,10),(15,20)
*/