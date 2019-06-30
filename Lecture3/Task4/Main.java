public class Main {
    public static void main(String[] args) {
        SaladFactory factory = new SaladFactory();

        MySalad greek = factory.getSalad(SaladTypes.GREEK);
        MySalad vegan = factory.getSalad(SaladTypes.VEGAN);
        MySalad cheese = factory.getSalad(SaladTypes.CHEESE);

        greek.eat();
        vegan.eat();
        cheese.eat();
    }
}