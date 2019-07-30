package task1;

import task1.Exceptions.AmountException;
import task1.Exceptions.FilterException;
import task1.Exceptions.NameException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    public static void createListsOfSalads() {
        try {
            Salad greekMyMySalad = new Salad("Greek");
            Salad veganMyMySalad = new Salad("Vegan");
            greekMyMySalad.addVegetable(1, new Cucumber());
            greekMyMySalad.addVegetable(3, new Tomato());
            greekMyMySalad.addVegetable(2, new Onion());

            veganMyMySalad.addVegetable(4, new Cucumber());
            veganMyMySalad.addVegetable(1, new Onion());

            writeToFile(greekMyMySalad.toString(), "lecture3/src/main/java/task2/files/dataForFileWriter");
            writeToFile(veganMyMySalad.toString(), "lecture3/src/main/java/task2/files/dataForFileWriter");
            writeToFile("Filtered by calories " + veganMyMySalad.getFilteredVegetablesByCalories(4, 15), "lecture3/src/main/java/task2/files/dataForFileWriter");

            Collections.sort(greekMyMySalad.getVegetables(), new VegetablesCaloriesComparator());
            writeToFile("Sorted by calories " + greekMyMySalad.getVegetables(), "lecture3/src/main/java/task2/files/dataForFileWriter");
            readFromFile("lecture3/src/main/java/task2/files/dataForFileWriter");
        } catch (NameException | AmountException | FilterException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public static List<String> readFromFile(String pathToFile) {
        List<String> listOfStrings = new ArrayList<>();
        try {
            BufferedReader bufferreader = new BufferedReader(new FileReader(pathToFile));
            String line;
            while((line = bufferreader.readLine()) != null) {
                listOfStrings.add(line);
            }
            bufferreader.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return listOfStrings;
    }

    public static void writeToFile(String inputMessage, String fileName) {

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(inputMessage);

            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

    public static void clearFile(String file) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
    }


    public static void processRegex() {
        String input = readFromFile("lecture3/src/main/java/task2/files/Restaurant.txt").toString();
        Pattern pattern = Pattern.compile("([A-Z]{1}[a-z]+\\sSalad)");
        Matcher neMatcher = pattern.matcher(input);
        while (neMatcher.find())
            System.out.println(neMatcher.group());
    }
}
