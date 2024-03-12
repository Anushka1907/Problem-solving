public class Aggressive_cows {
    public static boolean canWePlace(int[] stalls, int dist, int cows) {
        int countCows = 1;
        int lastPlaced = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlaced >= dist) {
                countCows++;
                lastPlaced = stalls[i];
            }
        }
        if (countCows >= cows) {
            return true;
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, mid, k) == true) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
