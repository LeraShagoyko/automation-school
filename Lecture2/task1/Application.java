import java.util.Collections;

public class Application {
    public static void main(String[] args) {
        Salad greekSalad = new Salad("Greek");
        greekSalad.addVegetable(2, new Cucumber());
        greekSalad.addVegetable(3, new Tomato());
        greekSalad.addVegetable(2, new Onion());


        Salad veganSalad = new Salad("Vegan");
        veganSalad.addVegetable(4, new Cucumber());
        veganSalad.addVegetable(1, new Onion());

        System.out.println(greekSalad);
        System.out.println(veganSalad);
        System.out.println("Filtered by calories " + veganSalad.getFilteredVegetablesByCalories(4, 15));

        Collections.sort(greekSalad.getVegetables(), new VegetablesCaloriesComparator());
        System.out.println("Sorted by calories " + greekSalad.getVegetables());
    }
}