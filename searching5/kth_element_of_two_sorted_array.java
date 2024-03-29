package Searching5;

import java.util.Arrays;

public class Kth_Element_of_Two_Sorted_Array {

	public static int kthElement(int[] arr1, int[] arr2, int k) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int i = 0, j = 0, index = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArray[index++] = arr1[i++];
            } else {
                mergedArray[index++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            mergedArray[index++] = arr1[i++];
        }
        while (j < arr2.length) {
            mergedArray[index++] = arr2[j++];
        }
        Arrays.sort(mergedArray);
        return mergedArray[k - 1];
    }

}
