package tree;
import java.util.*;

public class P117_PopulatingNextRightPointersinEachNodeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	//AC, but doesn't use constant space
    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
        if(root!=null) list.add(root);

        while(list.size()>0) {
            List<TreeLinkNode> l = new ArrayList<TreeLinkNode>();
            for(int j=0;j<list.size();j++) {
                TreeLinkNode node = list.get(j);
                if(node.left!=null) l.add(node.left);
                if(node.right!=null) l.add(node.right);
            }
            
            for(int j=0;j<l.size()-1;j++)
                l.get(j).next = l.get(j+1);

            list = l;
        }
    }

}
