package com.estudo.codingInterview.datastructures;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RansomNote {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] ransom = new String[n];

        String[] ransomItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String ransomItem = ransomItems[i];
            ransom[i] = ransomItem;
        }

        List<String> ListRansom = Arrays.stream(ransom).sorted().collect(Collectors.toList());
        List<String> ListMagazine = Arrays.stream(magazine).sorted().collect(Collectors.toList());

        for(int i = ListRansom.size()-1;i>=0;i--){
            if(i > ListRansom.size()-1)
                continue;

            String word = ListRansom.get(i);
            int result = Collections.binarySearch(ListMagazine, word);
            if(result >= 0){
                ListMagazine.remove(result);
                ListRansom.remove(word);
            }
        }

        System.out.println(ListRansom.isEmpty() ? "Yes" : "No");

        scanner.close();
    }

}
