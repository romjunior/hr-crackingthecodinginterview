package com.estudo.codingInterview.algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergeSortCountingInvertions {

    private static long countInversions(int[] arr) {
        return countInversions(arr, 0, arr.length - 1, arr.clone());
    }

    private static long countInversions(int[] arr, int left, int right, int[] temp) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;

        long count = 0;
        count += countInversions(temp, left, mid, arr);
        count += countInversions(temp, mid + 1, right, arr);
        count += merge(arr, left, mid, right, temp);
        return count;
    }

    private static long merge(int[] arr, int left, int mid, int right, int[] temp) {
        long count = 0;
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
                count += mid + 1 - i;
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            System.out.println(result);
        }

        scanner.close();
    }
}
