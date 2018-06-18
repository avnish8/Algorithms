/*
    Implementation of strictly increasing Longest increasing sub-sequence
 */

import java.util.ArrayList;

public class LISNlogN {

    private static int search(ArrayList<Integer> arr, int element, int l, int r) {
        if (r - l < 0) return r;

        int mid = (l + r) / 2;

        if (arr.get(mid) == element) return mid;
        else if (arr.get(mid) > element) return search(arr, element, l, mid - 1);
        else return search(arr, element, mid + 1, r);
    }

    private static int binarySearch(ArrayList<Integer> arr, int element) {
        return search(arr, element, 0, arr.size() - 1);
    }

    static int lis(int[] arr) {
        ArrayList<Integer> aux = new ArrayList<>();
        int setCount = 0;

        for (int i : arr) {
            if (setCount == 0) {
                aux.add(i);
                setCount++;
            }
            else if (i < aux.get(0)) {
                aux.set(0, i);
            }
            else if (i > aux.get(setCount - 1)) {
                aux.add(i);
                setCount++;
            }
            else {
                int leftIndex = binarySearch(aux, i);
                aux.set(leftIndex + 1, i);
            }
        }
//        for (int i : aux)
//            System.out.print(i + " ");
//        System.out.println("");
        return setCount;
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15, 16};

        System.out.println(lis(arr));
    }
}
