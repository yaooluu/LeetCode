package bitmanipulation;

public class P191_Numberof1Bits {

	public static void main(String[] args) {
		
		//this test case is -2147483648 in int, so need while(n!=0), rather 
		//than while(n>-0)
		int n = Integer.MAX_VALUE + 1;
		System.out.println(n);
		
		System.out.println(hammingWeight(n));
	}

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        while(n!=0) {
            if((n & 1) == 1) count++;
            n = n >>> 1;
        }
        return count;
    }
}
