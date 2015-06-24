package string;
import java.util.*;

public class P030_SubstringwithConcatenationofAllWords {
 
	public static void main(String[] args) {
		//String S = "barfoothefoobarman";
		//String L[] = {"foo", "bar"};
		
		//"aaa", ["aa","aa"]
		//String S = "aaa";
		//String L[] = {"aa","aa"};
		
		//"lingmindraboofooowingdingbarrwingmonkeypoundcake", ["fooo","barr","wing","ding","wing"]
		//String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		//String L[] = {"fooo","barr","wing","ding","wing"};

		String S = "";
		String L[] = new String[5000];
		for(int i=0;i<5000;i++) {
			S += "a";
			L[i] = "a";
		}
		//L[5000] = "a";	
		
		System.out.println(findSubstring(S,L));
	}

    public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> list = new ArrayList<Integer>();
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        
    	int lenS = S.length(), lenL = L[0].length(), lenTotal = lenL * L.length;
        for(int i=0;i<L.length;i++) {
        	List<Integer> l = new ArrayList<Integer>();
        	if(map.containsKey(L[i])) 
        		l = map.get(L[i]);
        	l.add(-1);
        	map.put(L[i],l);
        }
        
        for(int i=0;i<lenS-lenTotal+1;i++) {
            int match = 0;
            for(int j=i;j<lenS-lenL+1;j+=lenL) {
                String sub = S.substring(j, j+lenL);
                if(map.containsKey(sub)) {
                	List<Integer> l = map.get(sub);
                	int k = 0;
                	for(k=0;k<l.size();k++) {
                		if(l.get(k) < i) {
                            l.set(k, i);                   
                            match++;
                            break;
                		}
                	}
                	if(k == l.size()) break;
                }
                else break;
            }
            if(match == L.length) list.add(i);
        }
        return list;
    }
}
