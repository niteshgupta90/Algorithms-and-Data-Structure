/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

//Given a collection of intervals, merge all overlapping intervals.
public class Solution{
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2){
                if(o1.start == o2.start)
                    return 0;
                return o1.start < o2.start ? -1 : 1;
            }
        });
        
        for(int i = 0; i<intervals.size(); i++){
            Interval val = new Interval(intervals.get(i).start,intervals.get(i).end);
            while(i<intervals.size()-1 && val.end >= intervals.get(i+1).start){
                val = new Interval(val.start,Math.max(val.end,intervals.get(i+1).end));
                i++;
                if(i==intervals.size()-1)
                    break;
            }
            res.add(val);
        }
        
        return res;
    }
}
