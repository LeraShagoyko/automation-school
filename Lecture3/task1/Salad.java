import Exceptions.AmountException;
import Exceptions.FilterException;
import Exceptions.NameException;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private ArrayList<Vegetable> vegetables = new ArrayList<>();
    private int totalCalories;

    public Salad(String name) throws NameException{
        if (name.equals("")) {
            throw new NameException("The name is absent");
        }
        this.name = name;
    }

    public String toString() {
        return "MySalad Name: " + name + " Total Calories: " + totalCalories + "\n" + "Ingredients:" + vegetables;
    }

    public void addVegetable(Integer amount, Vegetable vegetable) throws AmountException {
        if (amount < 1) {
            throw new AmountException("The amount is less then 1");
        }

        vegetables.add(vegetable);
        totalCalories = totalCalories + vegetable.getCalories() * amount;
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public List<Vegetable> getFilteredVegetablesByCalories(int minCalories, int maxCalories) throws FilterException {
        if (minCalories > maxCalories) {
            throw new FilterException("Min value more then max value");
        }
        List<Vegetable> filteredVegetables = new ArrayList<>();
        for (Vegetable i : vegetables) {
            if (i.getCalories() > minCalories && i.getCalories() < maxCalories) {
                filteredVegetables.add(i);
            }
        }
        return filteredVegetables;
    }
}
