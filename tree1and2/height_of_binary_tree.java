class Solution{
  public static int height(Treenode root){
    if(root==null){
      return null;
    }
    int left=height(root.left);
    int right=height(root.right);
    return Math.max(left,right)+1;
  }
}
