package string;
import java.util.*;

public class P003_LongestSubstringWithoutRepeatingCharacters {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring4("bbbbbbbbbbbbb"));
	}

	//TLE
    public static int lengthOfLongestSubstring(String s) {
        int len = 0;
        for(int i=0;i<s.length();i++) {
            Set<String> set = new HashSet<String>();
            int curLen = 0;
            for(int j=i;j<s.length();j++) {
                String ch = s.substring(j,j+1);
                if(set.contains(ch) == false) {
                    set.add(ch);
                    curLen++;
                }
            }
            if(curLen > len) len = curLen;
        }
        return len;
    }
    
    //TLE
    public static int lengthOfLongestSubstring2(String s) {
        int len = 0;
        for(int i=0;i<s.length();i++) {
            Map<String, Integer> map = new HashMap<String, Integer>();
            int curLen = 0;
            for(int j=i;j<s.length();j++) {
                String ch = s.substring(j,j+1);
                if(map.containsKey(ch) == false) {
                    map.put(ch, j);
                    curLen++;
                }
                else {
                	i = map.get(ch);
                	break;
                }
            }
            if(curLen > len) len = curLen;
        }
        return len;
    }
    
    //TLE
    public static int lengthOfLongestSubstring3(String s) {
        int len = 0, curLen = 0, i = 0, j = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        while(i<s.length() && j<s.length()) {
        	String ch = "" + s.charAt(j);
        	if(map.containsKey(ch) == false) {
        		map.put(ch, j);
        		j++;
        		curLen++;
        		if(curLen > len) len = curLen;
        	}else {
        		i = map.get(ch) + 1;
        		j = i;
        		curLen = 0;
        		map = new HashMap<String, Integer>();
        	}
        }
        return len;
    }

    public static int lengthOfLongestSubstring4(String s) {
        int len = 0, curLen = 0, i = 0, j = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        while(i<s.length() && j<s.length()) {
        	String ch = "" + s.charAt(j);
        	if(map.containsKey(ch) == false) {
        		map.put(ch, j);
        		j++;
        		curLen++;
        		if(curLen > len) len = curLen;
        	}else {
        		int k = map.get(ch);
        		while(i <= k) {			
        			map.remove(s.charAt(i)+"");
        			curLen--;
        			i++;
        		}
        	}
        }
        return len;
    }
}
