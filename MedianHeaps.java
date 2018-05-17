import java.io.*;
import java.util.*;

public class MedianHeaps {

    /*
     * Complete the runningMedian function below.
     */

    static void addInteger (int i, PriorityQueue <Integer> lower, PriorityQueue <Integer> higher) {
        if (lower.size() == 0 || i < lower.peek())
            lower.add(i);
        else higher.add(i);
    }

    static void rebalance (PriorityQueue <Integer> lower, PriorityQueue <Integer> higher) {
        PriorityQueue <Integer> smallerHeap = lower.size() < higher.size() ? lower : higher;
        PriorityQueue <Integer> biggerHeap = lower.size() < higher.size() ? higher : lower;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    static double getMedian (PriorityQueue <Integer> lower, PriorityQueue <Integer> higher) {
        PriorityQueue <Integer> smallerHeap = lower.size() < higher.size() ? lower : higher;
        PriorityQueue <Integer> biggerHeap = lower.size() < higher.size() ? higher : lower;

        if (smallerHeap.size() == biggerHeap.size()) { return (1.0 * biggerHeap.peek() + smallerHeap.peek()) / 2;}
        else return biggerHeap.peek();
    }

    static double[] runningMedian(int[] a) {
        PriorityQueue <Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue <Integer> higher = new PriorityQueue<>();

        double medians[] = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            addInteger(a[i], lower, higher);
            rebalance(lower, higher);
            medians[i] = getMedian(lower, higher);
        }

        return medians;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.println(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                System.out.println("\n");
            }
        }
    }
}
