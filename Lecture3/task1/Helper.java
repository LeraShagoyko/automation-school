import Exceptions.AmountException;
import Exceptions.FilterException;
import Exceptions.NameException;

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

            writeToFile(greekMyMySalad.toString());
            writeToFile(veganMyMySalad.toString());
            writeToFile("Filtered by calories " + veganMyMySalad.getFilteredVegetablesByCalories(4, 15));

            Collections.sort(greekMyMySalad.getVegetables(), new VegetablesCaloriesComparator());
            writeToFile("Sorted by calories " + greekMyMySalad.getVegetables());
            readFromFile("Lecture3/task2/files/dataForFileWriter");
        } catch (NameException | AmountException | FilterException exception) {
            System.out.println(exception.getMessage());
        }

    }

    private static List<String> readFromFile(String pathToFile) {
        List<String> listOfStrings = new ArrayList<>();
        try {
            BufferedReader bufferreader = new BufferedReader(new FileReader(pathToFile));
            String line = bufferreader.readLine();
            while (line != null) {
                line = bufferreader.readLine();
                listOfStrings.add(line);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return listOfStrings;
    }

    private static void writeToFile(String inputMessage) {

        try (FileWriter writer = new FileWriter("Lecture3/task2/files/dataForFileWriter", true)) {
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
        String input = readFromFile("Lecture3/task2/files/Restaurant.txt").toString();
        Pattern pattern = Pattern.compile("([A-Z]{1}[a-z]+\\sSalad)");
        Matcher neMatcher = pattern.matcher(input);
        while (neMatcher.find())
            System.out.println(neMatcher.group());
    }
}
