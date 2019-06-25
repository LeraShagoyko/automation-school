import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Salad {
    private String name;
    private ArrayList<Vegetable> vegetables = new ArrayList<>();
    private int totalCalories;

    public Salad(String name) {
        this.name = name;
    }

    public String toString() {
        return "Salad Name: " + name + " Total Calories: " + totalCalories + "\n" + "Ingredients:" + vegetables;
    }

    public void addVegetable(Integer amount, Vegetable vegetable) {
        vegetables.add(vegetable);
        totalCalories = totalCalories + vegetable.getCalories() * amount;
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public List<Vegetable> getFilteredVegetablesByCalories(int minCalories, int maxCalories) {
        List<Vegetable> filteredVegetables = new ArrayList<>();
        for (Vegetable i : vegetables) {
            if (i.getCalories() > minCalories && i.getCalories() < maxCalories) {
                filteredVegetables.add(i);
            }
        }
        return filteredVegetables;
    }
}
