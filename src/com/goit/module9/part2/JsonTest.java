package com.goit.module9.part2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonTest {

    public static void main(String[] args) throws IOException {
        String text = "name age\n"
                + "alice 21\n"
                + "ryan 30";

        JsonTest jsonTest = new JsonTest();
        File file = new File("jsonText.txt");
        jsonTest.writeToFile(file, text);
        jsonTest.readFromFileToJson(file);
    }

    public void writeToFile(File file, String text) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(text);
        }
    }

    public void readFromFileToJson(File file) throws FileNotFoundException {
        List<User> users = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] str = scanner.nextLine().split(" ");
                if (str[1].matches("[0-9]+")) {
                    User user = new User(str[0], Integer.parseInt(str[1]));
                    users.add(user);
                }
            }
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        System.out.println(json);
    }

    public class User {

        String name;
        int age;

        public String getName() {
            return name;
        }


        public int getAge() {
            return age;
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }


}
