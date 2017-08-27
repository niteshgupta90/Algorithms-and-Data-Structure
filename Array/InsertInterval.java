/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
//Given a set of non-overlapping intervals, insert a new interval into the intervals.
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int size = intervals.size();
        boolean isProcessed = false;
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval temp;
        if(newInterval==null)
            return intervals;
        if(newInterval.start>newInterval.end){
            int a =  newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = a;
        }
        if(size==0){
            result.add(newInterval);
            return result;
        }
        intervals.add(newInterval);
        result =  merge(intervals);
        return result;
    }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
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
