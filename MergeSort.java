public class MergeSort {

    public static int unsortedArray[] = {744, 183, 864, 349, 665, 174, 560, 563, 393, 382, 24, 128, 166, 220, 735, 529, 778, 537, 879, 807};

    public static void mergeSortUtil(int[] unsortedArray, int l, int r) {
        if (r - l <= 1) return;

        int mid = l + (r-l) / 2;

        mergeSortUtil(unsortedArray, l, mid);
        mergeSortUtil(unsortedArray, mid, r);

        // one hand pointing algorithm

        int lp = l;
        int rp = mid;
        int sortedArrayPointer = 0;

        boolean loop = true;
        int sortedArray[] = new int[r-l];

        while (loop){
            if (lp == mid){
                while ( rp != r) {
                    sortedArray[sortedArrayPointer] = unsortedArray[rp];
                    rp++; sortedArrayPointer++;
                }
            }
            else if (rp == r){
                while ( lp != mid) {
                    sortedArray[sortedArrayPointer] = unsortedArray[lp];
                    lp++; sortedArrayPointer++;
                }
            }
            else if ( unsortedArray[lp] <= unsortedArray[rp]){
                sortedArray[sortedArrayPointer] = unsortedArray[lp];
                lp++; sortedArrayPointer++;
            }
            else if ( unsortedArray[lp] > unsortedArray[rp]){
                sortedArray[sortedArrayPointer] = unsortedArray[rp];
                rp++; sortedArrayPointer++;
            }

            if (sortedArrayPointer >= r - l)
                loop = false;
        }

        for (int i = l, sap = 0; i < r; i++, sap++){
            unsortedArray[i] = sortedArray[sap];
        }
    }

    public static void mergeSort(int[] unsortedArray) {
        mergeSortUtil(unsortedArray, 0, unsortedArray.length);
    }

    public static void main(String[] args) {
        mergeSort(unsortedArray);
        for (int i : unsortedArray)
            System.out.print(i + " ");
    }
}

