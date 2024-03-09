package searching1;

public class find_rotation_count {
    public int searchPeak(int a[], int low, int high) {
        int mid = low + (high - low) / 2;
        if (a[low] <= a[mid] && a[mid] <= a[high])
            return low; // Returning index instead of element if found
        else if (a[mid] >= a[low])
            return searchPeak(a, mid + 1, high);
        else
            return searchPeak(a, low, mid);
    }

    // calling function
    public int findKRotation(int arr[], int n) {
        return searchPeak(arr, 0, n - 1);
    }
}
