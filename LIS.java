public class LIS {

    private static class ArrayInt {
        int[] array;
        int integer;
    }

    static ArrayInt lis(int[] arr, int n) {
        int[] iLis = new int[n];
        for (int i = 0; i < n; i++) {
            int maxLis = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && iLis[j] > maxLis) {
                    maxLis = iLis[j];
                }
            }
            iLis[i] = maxLis + 1;
        }

        int m = 0;
        for (int k : iLis) {
            if (k > m) m = k;
        }

        ArrayInt ai = new ArrayInt();
        ai.integer = m;

        int[] lis = new int[m];
        int currentElement = Integer.MAX_VALUE;
        for (int j = n - 1; j >= 0; j--) {
            if (iLis[j] == m && arr[j] < currentElement) {
                m--;
                lis[m] = arr[j];
                currentElement = arr[j];
            }
        }
        ai.array = lis;
        return ai;
    }

    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        ArrayInt ai = lis(arr, n);
        System.out.println("Length of lis is " + ai.integer);
        for (int i : ai.array) {
            System.out.print(i + " ");
        }
    }
}
