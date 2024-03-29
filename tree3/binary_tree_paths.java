class Solution {
    public void dfs(TreeNode root1,List<String> result,String str){
        str+="->"+root1.val;
        if(root1.left==null && root1.right==null){
            result.add(str);
            return;
        }
        if(root1.left!=null){
            dfs(root1.left,result,str);
        }
        if(root1.right!=null){
            dfs(root1.right,result,str);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        if(root==null) return result;
        String str=Integer.toString(root.val);
        if(root.left==null && root.right==null){
            result.add(str);
        }
        if(root.left!=null){
            dfs(root.left,result,str);
        }
        if(root.right!=null){
            dfs(root.right,result,str);
        }
        return result;
    }
}
