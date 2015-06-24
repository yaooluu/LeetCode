package array;
import java.util.*;

public class P041_FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
	}
	
    public static int firstMissingPositive(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        int min = 1;
        for(int i=0;i<A.length;i++) {
            if(A[i]>0 && A[i]<min) min = A[i];
            set.add(A[i]);
        }
        
        for(int i=0;i<set.size();i++) {
            if(set.contains(min) == false) break;
            min++;
        }
        return min;
    }

}
