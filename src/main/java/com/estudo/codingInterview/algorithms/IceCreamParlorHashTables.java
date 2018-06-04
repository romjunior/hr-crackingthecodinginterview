package com.estudo.codingInterview.algorithms;

import java.util.HashMap;
import java.util.Scanner;

public class IceCreamParlorHashTables {

    // Complete the solve function below.
    static void solve(int[] arr, int money) {
        if (arr == null || arr.length < 1) {
            System.out.println(-1 + " " + -1);
            return;
        }

        HashMap<Integer, Integer> complementos = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < money) {
                if (complementos.containsKey(money - arr[i])) {
                    int index = complementos.get(money - arr[i]);
                    System.out.println((index + 1) + " " + (i + 1));
                    return;
                }

                if (!complementos.containsKey(arr[i])) {
                    complementos.put(arr[i], i);
                }
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            solve(arr, money);
        }

        scanner.close();
    }

}
