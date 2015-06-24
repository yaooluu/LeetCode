package array;

public class P026_RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int removeElement(int[] A, int elem) {
        int n = A.length;
        int i = -1;
        for(int j=0;j<n;j++) {
            if(A[j]!=elem) {
                i++;
                int tmp = A[j];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return i+1;
    }
}
