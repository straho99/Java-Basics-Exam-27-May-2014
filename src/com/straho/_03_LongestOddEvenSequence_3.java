package com.straho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _03_LongestOddEvenSequence_3 {
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

        for (int i = 0; i < numbers.size() - 1; i++) {
            String thisNumber = "";
            if (numbers.get(i) == 0) {
                thisNumber = "both";
            } else {
                thisNumber = (Math.abs(numbers.get(i)) % 2 == 0 ? "even" : "odd");
            }
            String nextNumber = "";
            int j = i + 1;
            if (numbers.get(j) == 0) {
                nextNumber = "both";
            } else {
                nextNumber = (Math.abs(numbers.get(j)) % 2 == 0 ? "even" : "odd");
            }

            while (!(thisNumber.equals("even") && nextNumber.equals("odd")) &&
                    !(thisNumber.equals("odd") && nextNumber.equals("even"))) {
                currentLength++;
                if (j >= numbers.size() - 1) {
                    break;
                }
                j++;
                thisNumber = nextNumber;
                if (numbers.get(j) == 0) {
                    nextNumber = "both";
                } else {
                    nextNumber = (Math.abs(numbers.get(j)) % 2 == 0 ? "even" : "odd");
                }
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
            currentLength = 1;
        }
        System.out.println(maxLength);
    }
}