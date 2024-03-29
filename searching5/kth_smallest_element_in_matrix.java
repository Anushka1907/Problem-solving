class Solution {
    public int countOfMid(int[][] matrix,int mid){
        int count=0;
        int c=matrix[0].length-1;
        for(int i=0;i<matrix.length;i++){
            while(c>=0 && matrix[i][c]>mid) --c;
            count+=(c+1);
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int low=matrix[0][0];
        int n=matrix[0].length;
        int high=matrix[matrix.length-1][n-1];
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(countOfMid(matrix,mid)<k){
                low=mid+1;
            }
            else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
}
