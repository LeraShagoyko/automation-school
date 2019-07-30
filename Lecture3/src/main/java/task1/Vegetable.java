package task1;

public abstract class Vegetable {
    private int calories;
    private int weight;

    Vegetable(int weight, int calories) {
        this.calories = calories;
        this.weight = weight;
    }

    Integer getCalories() {
        return calories;
    }

    public String toString() {
        String className = this.getClass().getName();
        return className + " Calories " + calories + " Weight " + weight + "\n";
    }
}
