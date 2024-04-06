class Solution {
    private TreeNode createBst(int nums[], int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]); 
        root.left = createBst(nums, l, mid - 1);                                  
        root.right = createBst(nums, mid + 1, r);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBst(nums, 0, nums.length - 1);
    }
}
