package array;
import java.util.*;

public class P018_4Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
		//System.out.println(fourSum(new int[]{-493,-482,-482,-456,-427,-405,-392,-385,-351,-269,-259,-251,-235,-235,-202,-201,-194,-189,-187,-186,-180,-177,-175,-156,-150,-147,-140,-122,-112,-112,-105,-98,-49,-38,-35,-34,-18,20,52,53,57,76,124,126,128,132,142,147,157,180,207,227,274,296,311,334,336,337,339,349,354,363,372,378,383,413,431,471,474,481,492}, 6189));
		System.out.println(fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
	}
	
    public static List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
    
        List<String> k = new ArrayList<String>();
        List<Integer> v = new ArrayList<Integer>();
        Map<Integer, Integer> val = new HashMap<Integer, Integer>();
        int n = num.length;
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++) {
                k.add(i+","+j);
                v.add(num[i]+num[j]);
                val.put(num[i]+num[j],0);
            }
        //System.out.println(k);
        //System.out.println(v);
        Map<String, Integer> key = new HashMap<String, Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0;i<k.size();i++)  {  
        	if(val.containsKey(target - v.get(i)) == false) continue;
        	
            for(int j=i+1;j<k.size();j++) {
            	if (v.get(j) != target - v.get(i)) continue;
                String[] s = (k.get(i) +","+ k.get(j)).split(",");
                //System.out.println(Arrays.asList(s));
                if(Integer.parseInt(s[1]) < Integer.parseInt(s[2])) {
                	int n1 = num[Integer.parseInt(s[0])];
                	int n2 = num[Integer.parseInt(s[1])];
                	int n3 = num[Integer.parseInt(s[2])];
                	int n4 = num[Integer.parseInt(s[3])];
                	
                	if(key.containsKey(n1+","+n2+","+n3+","+n4) == false) {
	                	key.put(n1+","+n2+","+n3+","+n4, 0);
	                    List<Integer> l = new ArrayList<Integer>();
	                    l.add(n1);
	                    l.add(n2);
	                    l.add(n3);
	                    l.add(n4);
	                    result.add(l);
                	}
                }
            }
        }
        return result;
    }

}
