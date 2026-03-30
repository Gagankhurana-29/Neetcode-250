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
       intervals.sort((a,b) -> Integer.compare(a.start,b.start));
        boolean ans = true;
        for(int i=0;i<intervals.size()-1;i++){
            Interval preInterval = intervals.get(i);
            Interval currInterval = intervals.get(i+1);
            if(preInterval.end > currInterval.start){
                return false;
            }
        }

        return true;

    }
}
