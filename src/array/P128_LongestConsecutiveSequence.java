package array;
import java.util.*;

public class P128_LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
	}

    public static int longestConsecutive(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<num.length;i++)
            map.put(num[i],i);
        
        int max = 0;
        for(int i=0;i<num.length;i++) {
            int curVal = num[i];
            while(map.containsKey(curVal)) curVal++;
            if((curVal-num[i]) > max) max = curVal-num[i];
        }
        return max;
    }
}
