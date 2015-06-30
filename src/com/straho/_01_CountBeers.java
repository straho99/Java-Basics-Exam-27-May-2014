package com.straho;

import java.util.Scanner;

public class _01_CountBeers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int beers = 0;
        int stacks = 0;
        String line = scanner.nextLine();
        while (line.compareTo("End") != 0) {
            String[] tokens = line.split("\\s+");
            if (tokens[1].trim().compareTo("beers") == 0) {
                beers += Integer.parseInt(tokens[0]);
            } else {
                stacks += Integer.parseInt(tokens[0]);
            }
            line = scanner.nextLine();
        }

        stacks += beers / 20;
        beers = beers % 20;

        System.out.println(stacks + " stacks + " + beers + " beers");
    }
}