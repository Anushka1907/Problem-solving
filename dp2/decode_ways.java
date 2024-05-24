public class Solution {
    private int[] t;

    public int solve(int i, String s, int n) {
        if (t[i] != -1) {
            return t[i];
        }

        if (i == n) {
            return t[i] = 1;
        }

        if (s.charAt(i) == '0') {
            return t[i] = 0; 
        }

        int result = solve(i + 1, s, n);

        if (i + 1 < n) {
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))
                result += solve(i + 2, s, n);
        }

        return t[i] = result;
    }

    public int numDecodings(String s) {
        int n = s.length();
        t = new int[101];
        Arrays.fill(t, -1);
        return solve(0, s, n);
    }
}


//optimized
public class Solution {
    public int bottomUp1(String s, int n) {
        int[] t = new int[n + 1];
        Arrays.fill(t, 0);
        t[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                t[i] = 0;
            } else {
                t[i] = t[i + 1];
                if (i < n - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                    t[i] += t[i + 2];
                }
            }
        }
        return t[0];
    }

    public int numDecodings(String s) {
        int n = s.length();
        return bottomUp1(s, n);
    }
}
