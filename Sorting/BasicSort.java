import java.util.*;

public class BasicSort {
    private int[] arr;
    public BasicSort(int[] arr) {
        this.arr = arr;
    }

    public void printArray() {
        for (int i = 0; i < this.arr.length; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
    
    private void switch_two(int i, int j) {
        int temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }

    public void bubbleSort() {
        int[] arr = this.arr;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] >= arr[j]) {
                    switch_two(i, j);
                }
            }
        }
    }

    public void selectionSort() {
        int[] arr = this.arr;
        for (int i = 0; i < arr.length; i++) {
            int smallest = arr[i];
            int smallest_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < smallest) {
                    smallest = arr[j];
                    smallest_index = j;
                }
            }
            switch_two(i, smallest_index);
        }
    }

    public void mergeSort() {
        this.arr = mergeSort(this.arr);
    }

    private int[] mergeSort(int[] array) {
        if (array.length == 2) {
            if (array[0] > array[1]) {
                int temp = array[0];
                array[0] = array[1];
                array[1] = temp;
            }
            return array;
        }

        if (array.length == 1) {
            return array;
        }

        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
        left = mergeSort(left);
        right = mergeSort(right);
        array = merge(left, right);
        return array;
    }

    private int[] merge(int[] l, int[] r) {
        int mergedArray[] = new int[l.length + r.length];
        int leftCursor = 0;
        int rightCursor = 0;
        int cursor = 0;

        while (leftCursor < l.length && rightCursor < r.length) {
            if (l[leftCursor] < r[rightCursor]) {
                mergedArray[cursor] = l[leftCursor];
                leftCursor++;
            } else if (r[rightCursor] < l[leftCursor]) {
                mergedArray[cursor] = r[rightCursor];
                rightCursor++;
            }
            cursor++;
        }


        while (leftCursor != l.length) {
            mergedArray[cursor] = l[leftCursor];
            leftCursor++;
            cursor++;
        }

        while (rightCursor != r.length) {
            mergedArray[cursor] = r[rightCursor];
            rightCursor++;
            cursor++;
        }

        return mergedArray;
    }

    public void quickSort(int low, int high) {
        int pivotIndex = partition(low, high);
        if (pivotIndex - 1 > low) {
            quickSort(low, pivotIndex - 1);
        }
        if (pivotIndex < high) {
            quickSort(pivotIndex, high);
        }
    }

    private int partition(int low, int high) {
        int reference = this.arr[(high + low) / 2];
        int leftCursor = low; 
        int rightCursor = high;
        while (leftCursor <= rightCursor) {
            while (this.arr[leftCursor] < reference) {
                leftCursor++;
            }
            while (this.arr[rightCursor] > reference) {
                rightCursor--;
            }
            if (leftCursor <= rightCursor) {
                switch_two(leftCursor, rightCursor);
                leftCursor++;
                rightCursor--;
            }
        }
        return leftCursor;
    }

    // public void radixSort() {
    //     LinkedList[] buckets = new LinkedList[9];
    //     for (int i = 0; i < this.arr.length; i++) {
    //         buckets[this.arr[i] / 10].add(this.arr[i % 10])
    //     }
    // }

    public static void main(String[] args) {
        int[] x = {4, 2, 3, 1, 10, 15, 13, 12, 11, 23};
        BasicSort basic = new BasicSort(x);
        basic.quickSort(0, x.length - 1);
        basic.printArray();
    }
}