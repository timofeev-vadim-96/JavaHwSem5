// Реализовать алгоритм пирамидальной сортировки (HeapSort).
package HomeWorkTasks;

import java.util.ArrayList;
import java.util.Random;

public class HeapSort {
    public static void printSortedList() {
        System.out.println("\n*****Задача 4*****");
        ArrayList<Integer> numbList = createList(10, 0, 51);
        System.out.println(numbList);
        heapSort(numbList);
        System.out.println(numbList);
    }
    private static void heapSort(ArrayList<Integer> inputList) {
        buildMaxHeap(inputList);
        for (int i = inputList.size()-1; i > 0; i--) {
            int temp = inputList.get(0);
            inputList.set(0, inputList.get(i));
            inputList.set(i, temp);
            maxHeapify(inputList, 0,i);
        }
    }

    private static int parent(int inputInt) {
        return (inputInt - 1) / 2;
    }

    private static int left(int inputInt) {
        return 2 * inputInt + 1;
    }

    private static int right(int inputInt) {
        return 2 * inputInt + 2;
    }

    private static void buildMaxHeap(ArrayList<Integer> inputList) {
        int length = inputList.size();
        int start = parent(length - 1);
        while (start >= 0) {
            maxHeapify(inputList, start, length);
            start -= 1;
        }
    }

    private static void maxHeapify(ArrayList<Integer> inputList, int index, int size) {
        int l = left(index);
        int r = right(index);
        int largest = 0;
        if (l < size && inputList.get(l) > inputList.get(index)) {
            largest = l;
        } else {
            largest = index;
        }
        if (r < size && inputList.get(r) > inputList.get(largest)) largest = r;
        if (largest != index) {
            int temp = inputList.get(largest);
            inputList.set(largest, inputList.get(index));
            inputList.set(index, temp);
            maxHeapify(inputList, largest, size);
        }
    }
    private static ArrayList<Integer> createList(int N, int min, int max) {
        ArrayList<Integer> newList= new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            newList.add(rand.nextInt(min, max+1));
        }
        return newList;
    }
}
