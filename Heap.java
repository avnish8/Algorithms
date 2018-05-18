import java.util.Arrays;

public class Heap {

    int[] array;
    int size = 0;
    int capacity = 1;

    Heap() { array = new int[capacity]; }

    int findParentIndex(int index) { return (index - 1 ) / 2; }

    int findLeftChildIndex(int parentIndex) { return parentIndex * 2 + 1; }

    int findRightChildIndex(int parentIndex) { return parentIndex * 2 + 2; }

    void swap(int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    void heapifyUp(int index) {
        if (index == 0) return;
        int parentIndex = findParentIndex(index);
        if (array[parentIndex] < array[index]) {
            swap(parentIndex, index);
            heapifyUp(parentIndex);
        }
    }

    void heapifyDown(int index) {
        int lChildIndex = findLeftChildIndex(index);
        int rChildIndex = findRightChildIndex(index);

        if (lChildIndex < size) {
            int lChild = array[lChildIndex];
            if (rChildIndex < size) {
                int rChild = array[rChildIndex];
                if (lChild > rChild && lChild > array[index]) {
                    swap(lChildIndex, index);
                    heapifyDown(lChildIndex);
                }
                else if (rChild > lChild && rChild > array[index]) {
                    swap(rChildIndex, index);
                    heapifyDown(rChildIndex);
                }
            }
            if (lChild > array[index]) {
                swap(lChildIndex, index);
                heapifyDown(lChildIndex);
            }

        }
        else return;
    }

    void tableDouble() {
        capacity *= 2;
        int[] newArray;
        newArray = Arrays.copyOf(this.array, capacity);
        array = newArray;
    }

    void insert(int t) {
        if (size == capacity) tableDouble();
        array[size] = t;
        size++;
        heapifyUp(size - 1);
    }

    int extractMax() {
        int tip = array[0];
        array[0] = array[size-1];
        size--;
        heapifyDown(0);
        return tip;
    }

    void decreaseKey(int newVal) {
        array[0] = newVal;
        heapifyDown(0);
    }

    public static void main(String[] args) {
        Heap maxHeap = new Heap();


        maxHeap.insert(1);
        maxHeap.insert(83);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(24);
        maxHeap.insert(-4);
        maxHeap.insert(23);
        maxHeap.decreaseKey(-8);

        int size = maxHeap.size;
        for (int i = 0; i < size; i++) System.out.print(maxHeap.extractMax() + " ");
    }

}
