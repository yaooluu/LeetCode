package bitmanipulation;

public class P190_ReverseBits {
public static void main(String[] args) {
		
		System.out.println(reverseBits(43261596));
	}

    // you need to treat n as an unsigned value
    public static int reverseBits(int n) {
        int mask = Integer.MAX_VALUE + 1;
        int x = 0, low = 1;;
        while(n!=0) {
            if((n & mask) == mask) x += low;
            n = n << 1;
            low = low << 1;
        }
        return x;
    }
}
