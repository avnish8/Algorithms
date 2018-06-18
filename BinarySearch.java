/*
    returns index of element just less than E if E not found
    i.e returns -1 if E would have been the smallest element in the array
    else
    returns index of E if found
 */

public class BinarySearch {

    private static int search(int[] arr, int element, int l, int r) {
        if (r - l < 0) return r;

        int mid = (l + r) / 2;

        if (arr[mid] == element) return mid;
        else if (arr[mid] > element) return search(arr, element, l, mid - 1);
        else return search(arr, element, mid + 1, r);
    }

    public static int binarySearch(int[] arr, int element) {
        return search(arr, element, 0, arr.length - 1);
    }
}
