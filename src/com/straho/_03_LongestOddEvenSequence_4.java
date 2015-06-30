package com.straho;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class _03_LongestOddEvenSequence_4 {
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
        ArrayList<Stack<Integer>> sequences = new ArrayList<Stack<Integer>>();

        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = 0;
            if (numbers.get(i) == 0) {
                Stack<Integer> evenStack = new Stack<Integer>();
                Stack<Integer> oddStack = new Stack<Integer>();
                evenStack.add(2);
                oddStack.add(1);
                sequences.add(evenStack);
                sequences.add(oddStack);

            } else {
                currentNumber = numbers.get(i) % 2 == 0 ? 2 : 1;
                Stack<Integer> singleStack = new Stack<Integer>();
                singleStack.add(currentNumber);
                sequences.add(singleStack);
            }
            int j = i + 1;
            while (j < numbers.size()) {
                if (numbers.get(j) == 0) {
                    if (sequences.get(sequences.size() - 1).peek() != -1) {
                        int nextNumber = sequences.get(sequences.size() - 1).peek() == 1 ? 2 : 1;
                        sequences.get(sequences.size() - 1).add(nextNumber);
                    }

                    if (sequences.size() > 1) {
                        if (sequences.get(sequences.size() - 2).peek() != -1) {
                            int nextNumber = sequences.get(sequences.size() - 2).peek() == 1 ? 2 : 1;
                            sequences.get(sequences.size() - 2).add(nextNumber);
                        }
                    }
                } else {
                    int nextNumber = numbers.get(j) % 2 == 0 ? 2 : 1;
                    if (sequences.get(sequences.size() - 1).peek() != -1) {
                        if (sequences.get(sequences.size() - 1).peek() != nextNumber) {
                            sequences.get(sequences.size() - 1).add(nextNumber);
                        } else {
                            sequences.get(sequences.size() - 1).add(-1);
                        }

                    }

                    if (sequences.size() > 1) {
                        if (sequences.get(sequences.size() - 2).peek() != -1) {
                            if (sequences.get(sequences.size() - 2).peek() != nextNumber) {
                                sequences.get(sequences.size() - 2).add(nextNumber);
                            } else {
                                sequences.get(sequences.size() - 2).add(-1);
                            }
                        }
                    }
                }
                j++;
            }
            if (sequences.get(sequences.size() - 1).peek() != -1) {
                sequences.get(sequences.size() - 1).add(-1);
            }
            if (sequences.size() > 1) {
                if (sequences.get(sequences.size() - 2).peek() != -1) {
                    sequences.get(sequences.size() - 2).add(-1);
                }
            }
        }

        for (Stack<Integer> sequence : sequences) {
            if (sequence.size() - 1 > maxLength) {
                maxLength = sequence.size()-1;
            }
        }

        System.out.println(maxLength);
    }
}