package array;

public class P189_RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{1,2,3,4,5,6,7};
		rotate(a,3);
		for(int i=0;i<a.length;i++) System.out.print(a[i]+",");
	}

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if(k == 0) return;
        int[] n = new int[len];
        for(int i=len-k;i<len;i++)
            n[i-(len-k)] = nums[i];
        for(int i=k;i<len;i++)
            n[i] = nums[i-k]; 
        for(int t=0;t<len;t++)
            nums[t] = n[t];
    }
}
