package tree;
import java.util.*;

public class P116_PopulatingNextRightPointersinEachNode {

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
        int i=0;
        while(i<list.size()) {
            TreeLinkNode node = list.get(i);
            if(node.left!=null) list.add(node.left);
            if(node.right!=null) list.add(node.right);
            i++;
        }
        int base = 2;
        for(i=0;i<list.size();i++) {
            if(i!=base-2) list.get(i).next = list.get(i+1);
            else base = base * 2;
        }
    }

}
