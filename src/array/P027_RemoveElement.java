package array;

public class P027_RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int removeDuplicates(int[] A) {
        if(A.length == 0) return 0;
        int i = 0;
        for(int j=0;j<A.length;j++) {
            if(A[j] != A[i]) {
                i++;
                A[i] = A[j];
            }
        }
        return i+1;
    }
}
