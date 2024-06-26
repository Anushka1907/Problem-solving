class Solution {
    public List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = inorder(root);
        if (k > 0 && k <= result.size()) {
            return result.get(k - 1);
        }
        return -1;
    }
}    
