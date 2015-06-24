package tree;

import java.util.*;

public class P106ConstructBinaryTreefromInorderandPostorderTraversal {
	
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		int[] postorder = {3,5,4,2,7,6,1};
		int[] inorder = {3,2,5,4,1,6,7};
		TreeNode root = buildTree(inorder, postorder);
		
		inTrav(root);
		System.out.println();
		postTrav(root);
	}

  	static int p = 0;
  	static int[] post = null, in = null;
  	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder.length == 0) return null;
        in = inorder;
        post = postorder;
        p = post.length - 1;
        
        for(int i=0;i<in.length;i++)
            map.put(in[i], i);
        
        TreeNode root = new TreeNode(0);
        construct(0, post.length - 1, root);
        return root;
    }
    
    private static void construct(int l, int r, TreeNode node) {
        if(l>r) return;
        
        int mid = map.get(post[p]);
        if(l<=mid && mid<=r) {
            node.val = post[p];
            p--;
                   
            int tmp = p;
            node.right = new TreeNode(0);
            construct(mid+1, r, node.right);
            if(p == tmp) node.right = null;
            
            tmp = p;        
            node.left = new TreeNode(0);
            construct(l, mid-1, node.left);
            if(p == tmp) node.left = null;
        }
    }
    
    
    private static void inTrav(TreeNode node) {
    	if(node!=null) {
    		inTrav(node.left);
    		System.out.print(node.val + ",");
    		inTrav(node.right);
    	}
    }
    
    private static void postTrav(TreeNode node) {
    	if(node!=null) {
    		postTrav(node.left);
    		postTrav(node.right);
    		System.out.print(node.val + ",");
    	}
    }

}
