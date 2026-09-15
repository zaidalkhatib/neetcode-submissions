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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals,(a,b)->(a.start-b.start));
        for(int i=1 ;i<intervals.size() ;i++){
            if(overLap(intervals.get(i-1),intervals.get(i))){
                return false;
            }
        }
        return true;
    }

    private boolean overLap(Interval a, Interval b){
        int start = Math.max(a.start,b.start);
        int end = Math.min(a.end,b.end); 
        return start<end;
    }
}
