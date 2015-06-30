package com.straho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _03_LongestOddEvenSequence_2 {
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
        String numberCanBe = "";
        if (numbers.get(0) == 0) {
            numberCanBe = "both";
        } else {
            numberCanBe = (Math.abs(numbers.get(0)) % 2 == 0 ? "odd" : "even");
        }
        for (int i = 1; i < numbers.size(); i++) {
            String numberIs = "";
            if (numbers.get(i) == 0) {
                numberIs = "both";
            } else {
                numberIs = (Math.abs(numbers.get(i)) % 2 == 0 ? "even" : "odd");
            }
            if (numberCanBe.equals("both") && numberIs.equals("both")) {
                currentLength++;
            } else if (numberCanBe.equals("both") && numberIs.equals("even")) {
                currentLength++;
                numberCanBe = "odd";
            } else if (numberCanBe.equals("both") && numberIs.equals("odd")) {
                currentLength++;
                numberCanBe = "even";
            } else if (numberCanBe.equals("even") && numberIs.equals("even")) {
                currentLength++;
                numberCanBe = "odd";
            } else if (numberCanBe.equals("even") && numberIs.equals("odd")) {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    currentLength = 1;
                }
                numberCanBe = "even";
            } else if (numberCanBe.equals("even") && numberIs.equals("both")) {
                currentLength++;
                numberCanBe = "odd";
            } else if (numberCanBe.equals("odd") && numberIs.equals("odd")) {
                currentLength++;
                numberCanBe = "even";
            } else if (numberCanBe.equals("odd") && numberIs.equals("both")) {
                currentLength++;
                numberCanBe = "even";
            } else if (numberCanBe.equals("odd") && numberIs.equals("even")) {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    currentLength = 1;
                }
                numberCanBe = "odd";
            }
            if (i == numbers.size() - 1) {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
        }
        System.out.println(maxLength);
    }
}