package searching2;

import java.util.*;

public class Single_element_in_a_sorted_array {
    public int singleNonDuplicate(int[] arr) {
        if(arr.length==1) return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        int s=0;
        int e=arr.length-1;
        int ans;
        while(s<=e)
        {
            int mid=(s+e)/2;
        //case1
            if(arr[mid]!=arr[mid-1]&&arr[mid]!=arr[mid+1])
            {
                ans=mid;
                break;
            }
        //case2
            if(mid%2==0)
            {
                if(arr[mid]==arr[mid+1])
                s=mid+1;
                else
                e=mid-1;
            }
        //case3
            else
            {
                if(arr[mid]==arr[mid+1])
                e=mid-1;
                else
                s=mid+1;
            }
        }
        return arr[ans];
    }
}
