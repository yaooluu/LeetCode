package array;
import java.util.*;

public class P031_NextPermutation {

	public static void main(String[] args) {
		int[] num = {1,1};
		for(int j=0;j<25;j++) {		
			
			for(int i=0;i<num.length;i++)
				System.out.print(num[i] + ",");
			System.out.println();
			nextPermutation(num);
		}
	}

    public static void nextPermutation(int[] num) {
        int n = num.length;
        int i;
        for(i=n-2;i>=0;i--) {
        	int index = -1, leastMax = Integer.MAX_VALUE;
        	for(int j=i+1;j<n;j++) {
        		if(num[j] > num[i] && num[j] < leastMax) {
        			leastMax = num[j];
        			index = j;
            	}
        	}
        	if(index != -1) {
                int tmp = num[i];
                num[i] = num[index];
                num[index] = tmp;
                break;
        	}
        }
        Arrays.sort(num, i+1, n);
    }
}
