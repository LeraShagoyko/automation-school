public class Child {
    private int id;
    private String name;
    private String lastName;
    private int age;

    Child(int id, String name, String lastName, int age){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    String getLastName() {
        return lastName;
    }

    Integer getAge() {
        return age;
    }

    Integer getId() {
        return id;
    }

    public String toString() {
        return "id: " + id + " Name: " + name + " lastName " + lastName + " age" + age + "\n";
    }
}
