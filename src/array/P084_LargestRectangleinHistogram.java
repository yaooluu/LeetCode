package array;
import java.util.*;

public class P084_LargestRectangleinHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(largestRectangleArea5(new int[]{2,1,5,6,2,3}));
		//System.out.println(largestRectangleArea5(new int[]{1,2,1,2,1,2,1,2,1,2}));
		//System.out.println(largestRectangleArea5(new int[]{1,1,1,2100000000,1,1}));
		
		int[] n = new int[30000];
		for(int i=0;i<n.length;i++) n[i] = 1;
		
		//System.out.println(largestRectangleArea5(n));
		
		int[] a = new int[10000];
		for(int i=0;i<a.length;i++) a[i] = i+1;
		System.out.println(largestRectangleArea5(a));
	}

    public static int largestRectangleArea(int[] height) {
        int[] mark = new int[height.length];
                
        int area = 0;
        int l, r;
        for(int i=0;i<height.length;i++) {
            if(mark[i] == height[i]) continue;
            l = i-1;
            r = i+1;
            while(l>=0 && height[l]>=height[i]) {
            	mark[l] = height[i];
            	l--;
            }
            while(r<height.length && height[r]>=height[i]) {
            	mark[r] = height[i];
            	r++;
            }
            int h = (r-l-1) * height[i]; 
            if(h > area) area = h;
        }
        return area;
    }
    
    public static int largestRectangleArea2(int[] height) {
        int area = 0, n = height.length;
        boolean quit = false;
        int h = 0;
        while(!quit) {quit = true;
            int l = 0, r = l;
            while(r < n) {
                while(l < n && height[l] < h) l++;
                if(l<n) quit = false;
                r = l;
                while(r < n && height[r] >= h) r++;
                if((r-l)*h > area) area = (r-l)*h;
                l = r;
            }
            h++;
        }
        return area;
    }
    
    public static int largestRectangleArea3(int[] height) {
        int[] mark = new int[height.length];
                
        int area = 0;
        int l, r;
        for(int i=0;i<height.length;i++) {
            if(mark[i] == height[i]) continue;
            l = i-1;
            r = i+1;
            while(l>=0 && height[l]>=height[i]) {
            	mark[l] = height[i];
            	l--;
            }
            while(r<height.length && height[r]>=height[i]) {
            	mark[r] = height[i];
            	r++;
            }
            int h = (r-l-1) * height[i]; 
            if(h > area) area = h;
        }
        return area;
    }
    
    public static int largestRectangleArea4(int[] height) {
        int area = 0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<height.length;i++) {
            
        	Map<Integer,Integer> tmp = new HashMap<Integer, Integer>();
            for(Integer key : map.keySet()) {                           
                if (key <= height[i]) {
                        tmp.put(key, map.get(key)+key);
                    if(tmp.get(key) > area) area = tmp.get(key);
                }
            }
            
        	if(map.containsKey(height[i]) == false){
            	tmp.put(height[i], height[i]);
            	if(height[i] > area) area = height[i];
            }
        	
        	map = tmp;
        }
        return area;
    }
    
    public static int largestRectangleArea5(int[] height) {
        int max = 0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<height.length;i++) {
            if(!map.containsKey(height[i]))
                map.put(height[i],height[i]);
            
            for(Integer key : map.keySet()) {
                if(key <= height[i]) {
                    int k = map.get(key);
                    map.put(key, k + key);
                    if(k > max) max = k;
                }
            }
        }
        return max;
    }
}
