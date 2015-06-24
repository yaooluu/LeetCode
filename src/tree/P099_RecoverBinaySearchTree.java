package tree;

public class P099_RecoverBinaySearchTree {

	//need to rethink, not correct
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public void recoverTree(TreeNode root) {
        if(root != null) {
            if(root.left != null && root.right != null && root.left.val > root.right.val) {
                swapNodeValue(root.left, root.right);
            }
            
            if(root.left!=null && root.val < root.left.val) {
                swapNodeValue(root, root.left);
            }
            
            if(root.right!=null && root.val < root.right.val) {
                swapNodeValue(root, root.right);
            }
            
            recoverTree(root.left);
            recoverTree(root.right);
        }
    }
    
    private void swapNodeValue(TreeNode n1, TreeNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
}
