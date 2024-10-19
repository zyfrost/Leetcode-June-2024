/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<TreeNode> list;

    public TreeNode balanceBST(TreeNode root) {
        if (root == null)
            return null;
        list = new ArrayList();
        inOrder(root);
        return buildBST(0, list.size() - 1);

    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return ;

        inOrder(root.left);
        list.add(root);
        inOrder(root.right);

    }

    public TreeNode buildBST(int low, int high) {
        if (low > high)
            return null;

        int mid = low + (high - low) / 2;
        TreeNode root = list.get(mid);
        root.left = buildBST(low, mid - 1);
        root.right = buildBST(mid + 1, high);

        return root;

    }
}
