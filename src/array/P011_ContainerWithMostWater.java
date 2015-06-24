package array;
import java.util.*;

public class P011_ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea2(new int[]{1,1,1,1,1}));
	}
	
	//low efficiency
    public static int maxArea(int[] height) {
        int max = 0;
        Map<Integer, Integer> mapI = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mapA = new HashMap<Integer, Integer>();
        
        for(int i=0;i<height.length;i++) {
            if(mapI.containsKey(height[i]) == false) {
                mapI.put(height[i], i);
                mapA.put(height[i], 0);
            }
            for(Integer key : mapI.keySet()) {
                if(height[i] >= key) {
                    int tmp = key * (i - mapI.get(key));
                    if(tmp > mapA.get(key)) mapA.put(height[i], tmp);
                    if(tmp > max) max = tmp;
                }
            }
        }
        return max;
    }
    
    //pretty smart for i,j idea:
    //if h[i] <= h[j], then the max at h[i] is found.
    //if h[j] <= h[i], then the max at h[j] is found.
    public static int maxArea2(int[] height) {
        int max = 0, i = 0, j = height.length-1;
        while(i<j) {
        	int min = i;
        	if(height[j] < height[i]) min = j;
        	if(height[min] * (j-i) > max) max = height[min] * (j-i);
        	
        	if(height[i] <= height[j]) i++;
        	else j--;
        }
        return max;
    }
}
