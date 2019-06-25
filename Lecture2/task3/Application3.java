import java.util.*;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {
        List<Child> originList = createNewList(100);

        List<Child> filteredChildren = filterChildrenByLastName(originList, "S");

        calculateAverageAgeOfChildren(originList);

        Map<Integer, String> newMap = convertListToMap(originList);

        Map<Integer, String> mapFilteredById = filteredById(newMap, 10);
        System.out.println("Filter by ID " + mapFilteredById);

        Collections.sort(filteredChildren, new ChildAgeComparator());
        System.out.println("Filtered and sorted children: " + filteredChildren);
    }

    public static List<Child> filterChildrenByLastName(List<Child> notFilteredChildren, String firstLetter) {
        List<Child> filteredChildren = notFilteredChildren.stream()
                .filter(oneChild -> oneChild.getLastName().startsWith(firstLetter))
                .collect(Collectors.toList());
        System.out.println(filteredChildren);
        return filteredChildren;
    }

    public static void calculateAverageAgeOfChildren(List<Child> children) {
        Double average = children.stream().mapToInt(Child::getAge).average().getAsDouble();
        System.out.println(average);
    }

    public static Map<Integer, String> convertListToMap(List<Child> listForConverting) {
        Map<Integer, String> newMap = listForConverting.stream()
                .collect(Collectors.toMap(Child::getId, Child::getLastName));
        System.out.println(newMap);
        return newMap;
    }

    public static List<Child> createNewList(int amountOfChildren) {
        List<Child> children = new ArrayList<>();
        for (int k = 0; k < amountOfChildren; k++) {
            Random r = new Random();
            int age = r.nextInt(5) + 1;
            String lastName;
            if (k > amountOfChildren / 2) {
                lastName = "Jonson";
            } else {
                lastName = "Simpson";
            }

            Child child = new Child(k, "Tom" + k, lastName + k, age);
            children.add(child);
        }
        return children;
    }

    public static Map<Integer, String> filteredById(Map<Integer, String> notFilteredMap, int keyId) {
        Map<Integer, String> filteredMap = notFilteredMap.entrySet().stream()
                .filter(map -> map.getKey() > keyId)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return filteredMap;
    }
}