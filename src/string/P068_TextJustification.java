package string;
import java.util.*;

public class P068_TextJustification {

	public static void main(String[] args) {
		List<String> list = null;
		
		String[] s = {"This", "is", "an", "example", "of", "text", "justification."};
		//list = fullJustify(s,16);
		
		String[] s2 = {"Whataaaaaa", "do", "you", "think", "is", "the", "complexity", "of", "this", "algorithm?"};
		list = fullJustify(s2,11);
		
		String[] s3 = {"What","must","be","shall","be."};
		//list = fullJustify(s3,50);
		
		for(int i=0;i<list.size();i++)
			System.out.println("["+list.get(i)+"]");
	}

	 public static List<String> fullJustify(String[] words, int L) {
	        List<String> list = new ArrayList<String>();
	        for(int i=0;i<words.length;) {
	            int len = words[i].length(), pre = i;
	            while(i+1<words.length && len <= L) {
	            	i++;
	                len += 1 + words[i].length();
	            }
	            if(len > L) len -= (words[i].length() + 1);
	            else if(i == words.length-1) i++;

	            //System.out.println(pre+","+i+","+len+","+(i-pre-1));
	            /*
	                all words append a base num of spaces: ts/ti
	                first ts%ti words append 1 extra space
	            */
	            int ti = i - pre - 1;	//total intervals
	            int ts = L - len + ti;	//total spaces
	            
	            String line = words[pre];
	            if(i == words.length) {	//last line is left-justified 
	            	for(int j=pre+1;j<i;j++) line += " " + words[j];
	            	for(int k=0;k<ts-ti;k++) line += " ";
	            } else if(ti == 0) {	//if only one word
	            	for(int k=0;k<ts;k++) line += " ";
	            } else {
		            for(int j=pre+1;j<i;j++) {
		                for(int k=0;k<ts/ti;k++) line += " ";
		                if(j<=pre+ts%ti) line += " ";
		                line += words[j];
		            }
	            }	            
	            list.add(line);
	        }
	        return list;
	    }
}
