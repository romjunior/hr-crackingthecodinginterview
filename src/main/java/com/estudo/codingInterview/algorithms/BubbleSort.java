package com.estudo.codingInterview.algorithms;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {3, 2 ,1};

        boolean naoOrdenado = true;
        int vezes = 0;

        while (naoOrdenado) {
            naoOrdenado = false;
            for(int i = 0;i<array.length-1; i++) {
                if(array[i] > array[i + 1]) {
                    swap(array, i, i+1);
                    naoOrdenado = true;
                    vezes++;
                }
            }
        }

        for (int i: array) {
            System.out.print(i + " ");
        }

        System.out.print("\n");

        System.out.println(vezes);

    }

    public static void swap(int[] array, int index, int prox) {
        int temp = array[index];
        array[index] = array[prox];
        array[prox] = temp;
    }
}
