class Solution{
  public static int matrix(int[] arr,int mid){
    int low=0;
    int high=a.length-1;
    while(low<=high){
      int mid1=(low+high)/2;
      if(arr[mid1]<=mid){
        low=mid+1;
      }else{
        high=mid-1;
      }
    }
    return low;
  }

public static findMedian(int[][] arr){
  int low=1;
  int high=Integer.MAX_VALUE;
  int n=arr.length;
  int m=arr[0].length;
  while(low<=high){
    int mid=low+(high-low)/2;
    int c=0;
    for(int i=0;i<n;i++){
      c+=matrix(arr[i],mid);
    }
    if(c<=(n*m)/2){
      low=mid+1;
    }else{
      hig=mid-1;
    }
  }
  return low;
}
}  
