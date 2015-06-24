package array;
import java.util.*;

public class P039_CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(combinationSum(new int[]{10,1,2,7,6,1,5}, 8));
		System.out.println(combinationSum(new int[]{1,1,1,1,1,1,2}, 4));
	}

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
        int n = candidates.length, p = 0, sum = 0;
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
        Set<String> set = new HashSet<String>();
        Stack<Integer> stack = new Stack<Integer>();
        while(!stack.isEmpty() || p < n) {
            if(p < n && sum + candidates[p] < target) {
                stack.push(p);
                sum += candidates[p];
                //p++;
            } else {
            	if (p < n && sum + candidates[p] == target) {
            		List<Integer> l = stackToList(stack, set, candidates, candidates[p]);
            		if(l != null) list.add(l);
            	}
        		if(!stack.isEmpty()) {
        			p = stack.peek() + 1;
        			sum -= candidates[stack.pop()];
        		}else p++;
            }       
        }
        return list;
    }
    
    private static List<Integer> stackToList(Stack<Integer> stack, Set<String> set, int[] num, int last) {
    	String hash = "";
        List<Integer> l = new ArrayList<Integer>();
        for(int i=0;i<stack.size();i++) {
        	l.add(num[stack.get(i)]);
        	hash += num[stack.get(i)] + ",";;
        }
        l.add(last);
        hash += last;
        if(set.contains(hash)) return null;
        set.add(hash);
        return l;
    }
}
