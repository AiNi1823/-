package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] array = {5, 8, 10, 64, 77, 120, 33, 777, 20, 55, 7, 2, 153, 23, 10};
        Sorts.quickSort(array, array.length);
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }
}
