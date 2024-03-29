package Searching5;

import java.util.Scanner;

public class T_Sunduko {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int N = scanner.nextInt();
	        int M = scanner.nextInt();
	        long K = scanner.nextLong();
	        int[] A = new int[N];
	        int[] B = new int[M];
	        for (int i = 0; i < N; i++) {
	            A[i] = scanner.nextInt();
	        }
	        for (int i = 0; i < M; i++) {
	            B[i] = scanner.nextInt();
	        }
	        scanner.close();

	        long[] sumA = new long[N + 1];
	        for (int i = 1; i <= N; i++) {
	            sumA[i] = sumA[i - 1] + A[i - 1];
	        }

	        long maxBooks = 0;
	        for (int i = 0; i <= N; i++) {
	            long time = sumA[i];
	            if (time > K) {
	                break;
	            }
	            int remainingTime = (int) (K - time);
	            int count = i;
	            int left = 0;
	            int right = M;
	            while (left < right) {
	                int mid = left + (right - left) / 2;
	                if (B[mid] <= remainingTime) {
	                    left = mid + 1;
	                } else {
	                    right = mid;
	                }
	            }
	            count += left - 1;
	            maxBooks = Math.max(maxBooks, count);
	        }
	        System.out.println(maxBooks);
	    }

}
