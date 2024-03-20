class Solution{
  public static search(int[][] arr,int target){
    int n=arr.length;
    int m=arr[0].length;
    int low=0;
    int high=(n*m)-1;
    while(low<=high){
      int mid=low+(high-low)/2;
      if(arr[mid/m][mid%m]==target){
        return true;
      }
      else if(arr[mid/m][mid%m]>target){
        high=mid-1;
      }
      else{
        low=mid+1;
      }
    }
    return false;
  }
}
