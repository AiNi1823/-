package Queue;

import java.util.ArrayList;

/**
 * @author lando
 */
public class PriorityQueue {
    /**
     * Function to heapify the tree
     */
    void heapify(ArrayList<Integer> hT, int i) {
        int size = hT.size();
        //Find the largest amaong root,left child and right child.
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && hT.get(l) > hT.get(largest)) {
            largest = l;
        }
        if (r < size && hT.get(r) > hT.get(largest)) {
            largest = r;
        }

        //Swap and continue heapifying if root is not largest.
        if (largest != i) {
            int temp = hT.get(largest);
            hT.set(largest, hT.get(i));
            hT.set(i, temp);
            heapify(hT, largest);
        }
    }

    /**
     * Function to insert an element into the tree
     *
     * @param hT
     * @param newNum
     */
    void insert(ArrayList<Integer> hT, int newNum) {
        int size = hT.size();
        if (size == 0) {
            hT.add(newNum);
        } else {
            hT.add(newNum);
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(hT, i);
            }
        }
    }

    /**
     * Function to delete an element from the tree
     */
    void deleteNode(ArrayList<Integer> hT, int num) {
        int size = hT.size();
        int i;
        for (i = 0; i < size; i++) {
            if (num == hT.get(i)) {
                break;
            }
        }
        int temp = hT.get(i);
        hT.set(i, hT.get(size - 1));
        hT.set(size - 1, temp);

        hT.remove(size - 1);
        for (int j = size / 2 - 1; j >= 0; j--) {
            heapify(hT, j);
        }
    }

    void printArray(ArrayList<Integer> array, int size) {
        for (Integer i : array) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int size = array.size();

        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.insert(array, 3);
        priorityQueue.insert(array, 4);
        priorityQueue.insert(array, 9);
        priorityQueue.insert(array, 5);
        priorityQueue.insert(array, 2);

        System.out.println("Max-Heap array: ");
        priorityQueue.printArray(array, size);

        priorityQueue.deleteNode(array, 4);
        System.out.println("After deleting an element: ");
        priorityQueue.printArray(array, size);
    }
}
