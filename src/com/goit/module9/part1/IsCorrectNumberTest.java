package com.goit.module9.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class IsCorrectNumberTest {

  public static void main(String[] args) throws IOException {

    String text = "987-123-4567\n"
        + "123 456 7890\n"
        + "(123) 456-7890\n";

    IsCorrectNumberTest isCorrectNumberTest = new IsCorrectNumberTest();
    File file = new File("test.txt");
    isCorrectNumberTest.writeToFile(file, text);
    isCorrectNumberTest.isCorrectNumber(file);
  }

  public void writeToFile(File file, String text) throws IOException {
    try (FileWriter fileWriter = new FileWriter(file);) {
      fileWriter.write(text);
    }
  }

  public void isCorrectNumber(File file) {
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        char[] charArray = scanner.nextLine().toCharArray();
        if (charArray[0] == '(' && charArray[4] == ')' && charArray[5] == ' '
            && charArray[9] == '-') {
          for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]);
          }
          System.out.println();
        } else if (charArray[3] == '-' && charArray[7] == '-') {
          for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]);
          }
          System.out.println();
        }
      }
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    }
  }

}
