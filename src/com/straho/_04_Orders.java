package com.straho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = scanner.nextLine();
        }

        ArrayList<String> productNames = new ArrayList<String>();
        HashMap<String, TreeMap<String, Integer>> products = new HashMap<String, TreeMap<String, Integer>>();
        for (String line : lines) {
            String[] tokens = line.split(" ");
            String product = tokens[2];
            String customer = tokens[0];
            int amount = Integer.parseInt(tokens[1]);

            if (!products.containsKey(product)) {
                TreeMap<String, Integer> newOrder = new TreeMap<String, Integer>();
                newOrder.put(customer, amount);
                products.put(product, newOrder);
                productNames.add(product);
            } else {
                if (!products.get(product).containsKey(customer)) {
                    products.get(product).put(customer, amount);
                } else {
                    products.get(product).put(customer, products.get(product).get(customer) + amount);
                }
            }
        }

        for (String product : productNames) {
            String output = product + ": ";
            for (String customer : products.get(product).keySet()) {
                output += customer + " " + products.get(product).get(customer) + ", ";
            }
            output = output.substring(0, output.length() - 2);
            System.out.println(output);
        }
    }
}
