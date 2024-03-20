import java.util.*;
class Maximum_size_for_subarray{
    public static int box(int a[],int s,int mid){
        int total = 0;
        int n = a.length;
        int sum = 0;
        for(int i=0;i<mid;i++) {
            sum = sum + a[i];
        }
        if(sum <= s) total++;
        int sum2 = 0;
        for(int i=mid;i<n;i++){
            sum = (sum - a[sum2]) + a[i];
            if(sum<=s)total++;
            sum2++;
        }
        return total;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
          a[i] = in.nextInt();
        }
        int s = in.nextInt();
        int low = 1;
        int high = n;
        int max = 0;
        int ans = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            int res = box(a,s,mid);
            if(res != 0){
                if(res > max){
                    max = res;
                    ans = mid;
                    low = mid + 1;
                }
            }
            else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
