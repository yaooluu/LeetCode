package array;

public class P042_TrappingRainWater {

	public static void main(String[] args) {
		int A[] = {1,0,0,1};
		//int A[] = {1,2,3,4,5};
		//int A[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A));
	}
	
    public static int trap(int[] A) {
    	if(A.length <= 2) return 0;
    	int sum = 0, i = 0, j = A.length - 1;
        int level = 0;
        while(i<j) {
            level++;
            i = 0;
            j = A.length - 1;
            while(i<j && A[i]<level) i++;
            while(i<j && A[j]<level) j--;
            
            if(i<j && A[i]>= level && A[j]>=level)
            	sum += j - i + 1;
        }
        for(int k=0;k<A.length;k++) {
            if(A[k] >= level ) sum -= (level-1);
            else sum -= A[k];
        }
        return sum;
    }

}
