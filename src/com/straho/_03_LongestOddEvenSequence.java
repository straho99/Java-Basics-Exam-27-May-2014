package com.straho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _03_LongestOddEvenSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbersAsString = input.split("[()\\s]+");

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < numbersAsString.length; i++) {
            if (numbersAsString[i].length() > 0) {
                numbers.add(Integer.parseInt(numbersAsString[i]));
            }
        }

        if (numbers.size() == 1) {
            System.out.println(1);
            return;
        }

        int maxLength = 1;
        int currentLength = 1;
        for (int i = 1; i < numbers.size(); i++) {
            String previousNumber = Math.abs(numbers.get(i - 1)) % 2 == 0 ? "even" : "odd";
            String currentNumber = Math.abs(numbers.get(i)) % 2 == 0 ? "even" : "odd";
            if (numbers.get(i - 1) == 0) {
                currentLength++;
                if (i == numbers.size() - 1) {
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                }
            } else {
                if (currentNumber.compareTo(previousNumber) != 0) {
                    currentLength++;
                    if (i == numbers.size() - 1) {
                        if (currentLength > maxLength) {
                            maxLength = currentLength;
                        }
                    }
                } else {
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                    currentLength = 1;
                }
            }
        }

        System.out.println(maxLength);
    }
}