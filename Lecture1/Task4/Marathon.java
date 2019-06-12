import java.util.*;

public class Marathon {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate");
        List<Integer> times = Arrays.asList(341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265);
        TreeMap<Integer, Person> people = new TreeMap<>();
        int indexResult = 0;

        for (String name : names) {
            int currentPersonTime = times.get(indexResult);
            Person person = new Person(name, currentPersonTime);
            indexResult = indexResult + 1;
            people.put(currentPersonTime, person);
        }

        System.out.println(people);

        List<Person> winners = new ArrayList<Person>(people.values());
        System.out.println(winners.get(1));
        System.out.println(winners.get(0));
    }
}