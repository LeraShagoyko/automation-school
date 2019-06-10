package Task1_4;

public class Person {
    public String name;

    public int result;

    public Person(String name, int result){
        this.name = name;
        this.result = result;
    }
    public String toString() {
        return "Name: " + name + " result " + result +"\n";
    }
}
