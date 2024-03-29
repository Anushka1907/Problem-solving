public class Solution {
    public boolean help(TreeNode root,ArrayList<Integer> result, int B){
        if(root==null) return false;
        result.add(root.val);
        if(root.val==B) return true;
        if(help(root.left,result,B) || help(root.right,result,B)){
           return true;
        }
        result.remove(result.size()-1);
        return false;
    }
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(A==null) return result;
        help(A,result,B);
        return result;
    }
}
