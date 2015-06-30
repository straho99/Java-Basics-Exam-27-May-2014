package com.straho;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class _02_ThreeLargestNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        BigDecimal[] numbers = new BigDecimal[n];
        HashMap<BigDecimal, String> numbersAsString = new HashMap<BigDecimal, String>();
        for (int i = 0; i < n; i++) {
            String numberAsString = scanner.nextLine();
            numbers[i] = new BigDecimal(numberAsString);
            numbersAsString.put(numbers[i], numberAsString);
        }
        Arrays.sort(numbers);
        for (int i = numbers.length - 1; i >= numbers.length - 3 ; i--) {
            if (i < 0) {
                continue;
            }
            System.out.println(numbersAsString.get(numbers[i]));
        }
    }
}
