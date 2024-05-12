package com.testing;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/aafatihova/Documents/programming_technologies/technical_specification_2/file");
        File file1 = new File("/Users/aafatihova/Documents/programming_technologies/technical_specification_2/test_file_1");
        File file2 = new File("/Users/aafatihova/Documents/programming_technologies/technical_specification_2/test_file_2");
        System.out.println(_min(file));
        System.out.println(_max(file));
        System.out.println(_sum(file));
        System.out.println(_mult(file));



    }
    public static int _min(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        ArrayList<Integer> numbers = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        while (sc.hasNextInt()) {
            int number = sc.nextInt();
            numbers.add(number);
        }
        for (int i = 0; i < numbers.size(); i++)
        {
            if (numbers.get(i) < min)
            {
                min = numbers.get(i);
            }
        }
        //System.out.println(numbers);
        return min;


    }
    public static int _max(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        ArrayList<Integer> numbers = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        while (sc.hasNextInt()) {
            int number = sc.nextInt();
            numbers.add(number);
        }
        for (int i = 0; i < numbers.size(); i++)
        {
            if (numbers.get(i) > max)
            {
                max = numbers.get(i);
            }
        }
        //System.out.println(numbers);
        return max;


    }

    public static int _sum(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            int sum = 0;
            while (sc.hasNextInt()) {
                int number = sc.nextInt();
                numbers.add(number);
            }
            for (int i = 0; i < numbers.size(); i++) {
                sum += numbers.get(i);
            }
            //System.out.println(numbers);
            return sum;
        }
        catch (Exception e)
        {
            throw e;
        }


    }

    public static int _mult(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            int mult = 1;
            while (sc.hasNextInt()) {
                int number = sc.nextInt();
                numbers.add(number);
            }
            for (int i = 0; i < numbers.size(); i++) {
                mult = mult * numbers.get(i);
            }
            //System.out.println(numbers);
            return mult;
        }
        catch (Exception e)
        {
            throw e;
        }


    }
}





