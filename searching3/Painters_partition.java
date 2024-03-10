package searching3;

import java.util.ArrayList;

public class Painters_partition {
    public static int countPainters(ArrayList<Integer> boards,int mid){
        int painter=1;
        long total=0;
        for(int i=0;i<boards.size();i++){
            if(total+boards.get(i)<=mid){
                total+=boards.get(i);
            }else{
                painter++;
                total=boards.get(i);
            }
        }
        return painter;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int low=boards.get(0);
        int high=0;
        for(int i=0;i<boards.size();i++){
            low=Math.max(low,boards.get(i));
            high+=boards.get(i);

        }
        while(low<=high){
            int mid=(low+high)/2;
            int painter=countPainters(boards,mid);
            if(painter>k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}
