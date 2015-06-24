package array;
import java.util.*;



public class P056_MergeIntervals {

	public static void main(String[] args) {
		
		int s[] = {10,1,2,8,9};
		int e[] = {20,1,6,10,18};
		
		List<Interval> intervals = new ArrayList<Interval>();
		for(int i=0;i<s.length;i++)
			intervals.add(new Interval(s[i],e[i]));
		
		List<Interval> list = merge(intervals);
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).start +","+ list.get(i).end);
	}


	public static class Interval {
	    int start;
	    int end;
	    Interval() { start = 0; end = 0; }
	    Interval(int s, int e) { start = s; end = e; }
	}

	 
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
        intervals.sort(new MyComparator());
        for(int i=0;i<intervals.size();i++) {
            Interval in = intervals.get(i);
            if(list.size() == 0) list.add(in);
            else {
            	Interval pop = list.get(list.size()-1);
                if(in.start <= pop.end && in.end > pop.end)
                	pop.end = in.end;
                else if(in.start > pop.end)
                    list.add(in);
            }
        }
        return list;
    }
    
    public static class MyComparator implements Comparator<Interval> {		
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
    }
}
