package tree;

import java.util.*;

public class P105ConstructBinaryTreefromPreorderandInorderTraversal {

	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		int[] preorder = {1,2,3,4,5,6,7};
		int[] inorder = {3,2,5,4,1,6,7};
		TreeNode root = buildTree(preorder, inorder);
		
		preTrav(root);
		System.out.println();
		inTrav(root);
	}

  	static int p = 0;
  	static int[] pre = null, in = null;
  	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder.length == 0) return null;
        pre = preorder;
        in = inorder;
        p = 0;
        
        for(int i=0;i<in.length;i++)
            map.put(in[i], i);
        
        TreeNode root = new TreeNode(0);
        construct(0, pre.length - 1, root);
        return root;
    }
    
    private static void construct(int l, int r, TreeNode node) {
        if(l>r) return;
        
        int mid = map.get(pre[p]);
        if(l<=mid && mid<=r) {
            node.val = pre[p];
            p++;
            
            int tmp = p;        
            node.left = new TreeNode(0);
            construct(l, mid-1, node.left);
            if(p == tmp) node.left = null;
            
            tmp = p;
            node.right = new TreeNode(0);
            construct(mid+1, r, node.right);
            if(p == tmp) node.right = null;
        }
    }
    
    private static void preTrav(TreeNode node) {
    	if(node!=null) {
    		System.out.print(node.val + ",");
    		preTrav(node.left);
    		preTrav(node.right);
    	}
    }
    
    private static void inTrav(TreeNode node) {
    	if(node!=null) {
    		inTrav(node.left);
    		System.out.print(node.val + ",");
    		inTrav(node.right);
    	}
    }

}
