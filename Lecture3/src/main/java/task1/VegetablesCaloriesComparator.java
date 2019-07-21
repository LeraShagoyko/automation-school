package task1;

import java.util.Comparator;

class VegetablesCaloriesComparator implements Comparator<Vegetable>
{
    public int compare(Vegetable object1, Vegetable object2)
    {
        return object1.getCalories().compareTo(object2.getCalories());
    }
}