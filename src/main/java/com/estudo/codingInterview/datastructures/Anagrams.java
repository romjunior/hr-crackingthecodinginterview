package com.estudo.codingInterview.datastructures;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Anagrams {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder a = new StringBuilder(scanner.nextLine());

        StringBuilder b = new StringBuilder(scanner.nextLine());

        scanner.close();

        int delecao = 0;

        List<Integer> ListA = a.chars().sorted().boxed().collect(Collectors.toList());
        List<Integer> ListB = b.chars().sorted().boxed().collect(Collectors.toList());

        for(int i = ListA.size()-1 ; i>=0 ; i--){

            if(i > ListA.size()-1)
                break;

            Integer value = ListA.get(i);

            int result = Collections.binarySearch(ListB, value);
            if(result >= 0){
                ListB.remove(result);
                ListA.remove(value);
            }
        }

        System.out.println(ListA.size() + ListB.size());
    }

}
