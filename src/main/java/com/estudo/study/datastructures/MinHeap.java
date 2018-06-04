package com.estudo.study.datastructures;

import java.util.Arrays;

public class MinHeap {

    static class MinIntHeap{
        private int capacity = 10;
        private int size = 0;

        int[] itens = new int[capacity];

        private int getLeftChildIndex(int parentIndex) {
            return 2 * parentIndex + 1;
        }

        private int getRightChildIndex(int parentIndex) {
            return 2 * parentIndex + 2;
        }

        private int getParentIndex(int childIndex) {
            return (childIndex - 1) / 2;
        }


        private boolean hasLeftChild(int index) {
            return getLeftChildIndex(index) < size;
        }

        private boolean hasRightChild(int index) {
            return getRightChildIndex(index) < size;
        }

        private boolean hasParent(int index) {
            return getParentIndex(index) >= 0;
        }


        private int leftChild(int index) {
            return itens[getLeftChildIndex(index)];
        }

        private int rightChild(int index) {
            return itens[getRightChildIndex(index)];
        }

        private int parent(int index) {
            return itens[getParentIndex(index)];
        }

        private void swap(int indexOne, int indexTwo) {
            int temp = itens[indexOne];
            itens[indexOne] = itens[indexTwo];
            itens[indexTwo] = temp;
        }

        private void ensureExtraCapacity() {
            if(size == capacity) {
                itens = Arrays.copyOf(itens, capacity * 2);
                capacity *= 2;
            }
        }

        public int peek() {
            if(size == 0) throw new IllegalStateException();
            return itens[0];
        }

        public int poll() {
            if(size == 0) throw new IllegalStateException();
            int item = itens[0];
            itens[0] = itens[size -1];
            size--;
            heapifyDown();
            return item;
        }

        public void add(int item) {
            ensureExtraCapacity();
            itens[size] = item;
            size++;
            heapifyUp();
        }

        public void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && parent(index) > itens[index]){
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }

        public void heapifyDown() {
            int index = 0;
            while (hasLeftChild(index)) {
                int smallerChildIndex = getLeftChildIndex(index);
                if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                    smallerChildIndex = getRightChildIndex(index);
                }

                if(itens[index] < itens[smallerChildIndex]){
                    break;
                }else {
                    swap(index, smallerChildIndex);
                }
                index = smallerChildIndex;
            }

        }
     }
}
