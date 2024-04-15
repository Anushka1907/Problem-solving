class Solution {
    public int countTriplets(int[] arr) {
        int res = 0;
        for(int i=0;i<arr.length-1;i++){
            int a = arr[i];
            for(int j=i+1;j<arr.length;j++){
                a ^= arr[j];
                res += a==0 ? j-i:0;
            }
        }
        return res;
    }
}