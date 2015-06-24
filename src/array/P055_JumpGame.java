package array;

public class P055_JumpGame {

	public static void main(String[] args) {

	}

    public boolean canJump(int[] A) {
        int p = 0;
        for(int i=0;i<A.length;i++) {
            if(p>= i && i + A[i] > p) p = i + A[i];
            if(p >= A.length-1) return true;
        }
        return false;
    }
}
