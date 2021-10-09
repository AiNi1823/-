package com.company;

/**
 * 冒泡，选择，插入，快速，归并
 */
public class Sorts {

    //冒泡排序，a是数组，n是数组大小
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; ++i) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    //此次冒泡有数据交换
                    flag = true;
                }
            }
            //没有数据交换，提前结束循环
            if (!flag) break;
        }
    }

    /**
     * 冒泡排序改进：在每一轮结束后记录最后一次元素交换的位置，作为下次比较的边界
     * 对于外边界的元素，在下次循环中无需比较
     *
     * @param a
     * @param n
     */
    public static void bubbleSort2(int a[], int n) {
        if (n <= 1) return;
        //最后一次交换的位置
        int lastExchange = 0;
        //无数据的边界，每次只需要比较到这里即可退出
        int sortBorder = n - 1;
        for (int i = 0; i < n; ++i) {
            //提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; ++j) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    //此次循环有数据交换
                    flag = true;
                    //记录最后发生交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag) break;
        }
    }

    /**
     * 插入排序
     *
     * @param a,表示数组
     * @param n,表示数组大小
     */
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            //查找要插入的位置并移动数据
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 选择排序
     */
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n - 1; ++i) {
            //查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] a, int n) {
        //以数组的开头与结尾作为左右下标
        quickSortInternally(a, 0, n - 1);
    }

    //快速排序递归函数，p，r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p > r) return;
        //获取分区点
        int q = partition(a, p, r);
        System.out.println("区分点：" + q);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);

    }

    //获取分区点
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }

}
