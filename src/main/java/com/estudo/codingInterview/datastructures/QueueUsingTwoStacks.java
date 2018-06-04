package com.estudo.codingInterview.datastructures;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

    static class MyQueue<T>{
        private Stack<T> in = new Stack<>();
        private Stack<T> out = new Stack<>();

        public void enqueue(T v){
            in.push(v);
        }

        public T dequeue(){
            if(out.isEmpty()){
                while (!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        public T peek(){
            if(out.isEmpty()){
                while (!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            return out.peek();
        }



    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
