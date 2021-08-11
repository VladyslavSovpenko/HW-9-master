package com.goit.module9.part3;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCalculate {
    public static void main(String[] args) throws IOException {
        File file = new File("wordCalc.txt");
        String text = "\n" +
                "the day is sunny the the\n" +
                "the sunny is is";
        WordCalculate wordCalculate = new WordCalculate();
        wordCalculate.writeToTxt(file, text);
        wordCalculate.calculateWord(file);
    }

    public void writeToTxt(File file, String text) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(text.replace("\n", " ").trim());
            writer.flush();
        }
    }

    public void calculateWord(File file) throws FileNotFoundException {
        Map<String, Integer> wordMap = new HashMap<>();
        int a = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] str = scanner.nextLine().split(" ");
                for (int i = 0; i < str.length; i++) {
                    if (wordMap.containsKey(str[i])) {
                        a = wordMap.get(str[i]);
                        a++;
                        wordMap.put(str[i], a);
                    } else {
                        wordMap.put(str[i], 1);
                    }
                }
            }
        }

        Object[][] doubleArray = new Object[wordMap.size()][2];

        Object[] keys = wordMap.keySet().toArray();
        Object[] values = wordMap.values().toArray();


        for (int i = 0; i < wordMap.size(); i++) {
            doubleArray[i][0] = keys[i];
            doubleArray[i][1] = values[i];
        }
        for (int i = 0; i < doubleArray.length; i++) {
            System.out.println();
            for (int j = 0; j < doubleArray[i].length; j++) {
                System.out.print(doubleArray[i][j] + " ");

            }
        }
    }
}
