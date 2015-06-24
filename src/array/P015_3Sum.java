package array;
import java.util.*;

public class P015_3Sum {
	
	public static void main(String[] args) {
		System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
	}

    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = num.length;
        for(int i=0;i<n;i++) {//System.out.print(num[i]+",");
            map.put(num[i], i);
        }
        //System.out.println();
        
        Set<String> set = new HashSet<String>();
        for(int i=0;i<n;i++) {
            if(num[i] > 0) break;
            for(int j=i+1;j<n;j++) {
                int sum = num[i] + num[j];
                if(sum > 0) break;
                //System.out.println("finding "+num[i]+", "+num[j]);
                if(map.containsKey(-1*sum) && map.get(-1*sum) > j) {  //find a triple <i, j, -1*(i+j)>
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(num[i]);
                    l.add(num[j]);
                    l.add(-1*sum);
                    if(set.contains(num[i]+""+num[j]) == false) {
                    	result.add(l);
                    	set.add(num[i]+""+num[j]);
                    }
                }
            }
        }
        return result;
    }
    
    
}
