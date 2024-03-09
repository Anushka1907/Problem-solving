package searching2;

public class Sqrt_of_a_number {
    public int mySqrt(int x) {
        long s = 0, e = Integer.MAX_VALUE, ans = 0;
        while (s <= e) {
            long mid = s + (e - s) / 2;
            if (mid * mid <= x) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return (int) ans;
    }
}
