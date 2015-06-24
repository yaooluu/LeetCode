package string;
import java.util.Stack;

public class P032_LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()()())"));
	}

	//wrong! e.g. "()(()"
    public static int longestValidParentheses(String s) {
        Stack<String> stack = new Stack<String>();
        int max = 0;
        int curMax = 0;
        for(int i=0;i<s.length();i++) {           
            String curStr = s.substring(i,i+1);
            if(curStr.equals("(")) {
                stack.push(curStr);
            }
            else {
                if(!stack.empty() && stack.peek().equals("(")) {
                    stack.pop();
                    curMax += 2;
                    if(curMax > max) max = curMax;
                }
                else curMax = 0;
            }
        }
        return max;
    }
}
