package com.estudo.study.algorithms;

public class MergeSort {

    private static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1, arr.clone());
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        sort(temp, left, mid, arr);
        sort(temp, mid + 1, right, arr);
        merge(arr, left, mid, right, temp);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid || j <= right) {
            if (i > mid) {
                arr[k++] = temp[j++];
            } else if (j > right) {
                arr[k++] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
    }

    public static void main(String[] args) {

        int[] test = new int[]{1, 6, 4, 3, 7, 5};

        sort(test);

        for(int i : test)
            System.out.print(i + " ");

    }

}
