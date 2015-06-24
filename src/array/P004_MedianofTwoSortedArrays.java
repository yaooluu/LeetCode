package array;

public class P004_MedianofTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,3,4};
		int[] B = {4,5,6,7};
		System.out.println(findMedianSortedArrays(A,B));
	}

    public static double findMedianSortedArrays(int A[], int B[]) {
        int k = A.length + B.length;
        k = k/2 + k%2;
        int l1 = 0, r1 = A.length - 1, l2 = 0, r2 = B.length - 1;
        int m1, m2;
        while(true) {
            m1 = (l1 + r1) / 2;
            m2 = (l2 + r2) / 2;
            int half = (m1-l1+1) + (m2-l2+1);
            
            
            
            if(A[m1] < B[m2]) {
                if(half>k)
                    r2 = m2 - 1;
                else {
                    l1 = m1 + 1;
                    k = k - (m1 - l1 + 1);
                }
            } else {
                if(half > k) 
                	r1 = m1 - 1;
                else {
                    l2 = m2 + 1;
                    k = k - (m2 - l2 + 1);
                }
            }
            
            if(l1>r1 ||l2>r2) break;
        }
        System.out.println(l1+","+l2+","+k);
        if(l1 > r1) return 1.0 * B[l2+k-1];
        else return 1.0 * A[l1+k-1];
        //return -1;
        //return (A[l1+k-1]+B[l2+k-1]) / 2.0;
    }
}
