package string;

public class P097_InterleavingString {

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		//s3 = "aadbbbaccc";
		
		//s1 = "cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc";
		//s2 = "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb";
		//s3 = "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb";
		
		System.out.println(isInterleave(s1, s2, s3));
	}
	
	//DP, non-recursive
    public static boolean isInterleave(String s1, String s2, String s3) {
    	int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
    	if(l1 + l2 != l3) return false;  	
    	boolean[][] b = new boolean[l1][l2];
    	b[l1][2] = true;
    	for(int j = l2-1;j>=0;j--) 
    		b[l1][j] = (s2.charAt(j) == s3.charAt(j+l1)) && b[l1][j+1];
    	
    	for(int i = l1-1;i>=0;i--) 
    		b[i][l2] = (s1.charAt(i) == s3.charAt(i+l2)) && b[i+1][l2];
    	
    	for(int i = l1-1;i>=0;i--) 
    		for(int j = l2-1;j>=0;j--) {
    			b[i][j] = (s1.charAt(i)==s3.charAt(i+j) && b[i+1][j]) ||
    					s2.charAt(j)==s3.charAt(i+j) && b[i][j+1];
    		}
    	
    	return b[0][0];
    }
	
	/*
	static char[] a, b, c;
	static int la, lb, lc;
    public static boolean isInterleave(String s1, String s2, String s3) {
    	a = s1.toCharArray();
    	b = s2.toCharArray();
    	c = s3.toCharArray();
    	la = a.length;
    	lb = b.length;
    	lc = c.length;
    	if(la + lb != lc) return false;
    	//return interleave(0,0,0);
    	interleave(0,0,0);
    	return find;
    }
    
    //TLE, because after found a solution, won't stop searching
    /*
    public static boolean interleave(int i, int j, int k) {  	
    	if(k<lc && (i<la || j<lb)) {System.out.println(i + "," + j +","+k);
    		boolean b1 = false, b2 = false;
    		if(i<la && a.charAt(i) == c.charAt(k))
    			b1 = interleave(i+1, j, k+1);
    		
    		if(j<lb && b.charAt(j) == c.charAt(k))
    			b2 = interleave(i, j+1, k+1);

    		return b1 || b2;
    	}
    	else {System.out.println("find");return true;}
    }
    */
    
    //still TLE...
    /*
    static boolean find = false;
    public static void interleave(int i, int j, int k) {  	
    	if(!find && k<lc && (i<la || j<lb)) {
    		if(i<la && a[i] == c[k])
    			interleave(i+1, j, k+1);
    		
    		if(!find && j<lb && b[j] == c[k])
    			interleave(i, j+1, k+1);
    	}
    	else find = true;
    }
    */

}
