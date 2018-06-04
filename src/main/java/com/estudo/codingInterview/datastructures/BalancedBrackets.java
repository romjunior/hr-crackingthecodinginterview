package com.estudo.codingInterview.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedBrackets {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
            System.out.println(testBalance(expression));
        }

        scanner.close();
    }

    static String testBalance(String expression){
        char[] array = expression.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        for (char anArray : array) {
            switch (anArray){
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if (!stack.isEmpty() && anArray == stack.peek()) {
                        stack.pop();
                    } else {
                        return "NO";
                    }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }
}

