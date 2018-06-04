package com.estudo.codingInterview.datastructures;

import java.util.*;

public class RunningMedianHeap {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int array[] = new int[n];

        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            array[i] = aItem;
        }

        for(double v: getMedians(array)){
            System.out.println(v);
        }

        scanner.close();
    }

    public static double[] getMedians(int[] array) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        double[] medians = new double[array.length];
        for(int i = 0; i < array.length; i++) {
            int number = array[i];
            addNumber(number, max, min);
            rebalance(max, min);
            medians[i] = getMedian(max, min);
        }
        return medians;
    }

    public static double getMedian(PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
        PriorityQueue<Integer> biggerHeap = max.size() > min.size() ? max : min;
        PriorityQueue<Integer> smallerHeap = max.size() > min.size() ? min : max;

        if(biggerHeap.size() == smallerHeap.size()) {
            return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
        }else {
            return biggerHeap.peek();
        }
    }

    private static void rebalance(PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
        PriorityQueue<Integer> biggerHeap = max.size() > min.size() ? max : min;
        PriorityQueue<Integer> smallerHeap = max.size() > min.size() ? min : max;

        if(biggerHeap.size() - smallerHeap.size() >= 2){
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static void addNumber(int number, PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
        if(max.size() == 0 || number < max.peek()){
            max.add(number);
        }else{
            min.add(number);
        }
    }
}
