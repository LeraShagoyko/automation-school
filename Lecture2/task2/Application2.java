import java.util.*;
import java.util.stream.Collectors;

public class Application2 {
    public static void main(String[] args) {
        List<Child> originList = createNewList(100);

        List<Child> filteredChildren = filterChildrenByLastName(originList, "Simpson3");

        calculateAverageAgeOfChildren(originList);

        Map<Integer, String> newMap = convertListToMap(originList);

        Map<Integer, String> mapFilteredById = filteredById(newMap, 5);
        System.out.println("Filtered by ID " + mapFilteredById);

        Collections.sort(filteredChildren, new ChildAgeComparator());
        System.out.println("Filtered and sorted children: " + filteredChildren);
    }

    public static List<Child> filterChildrenByLastName(List<Child> notFilteredChildren, String firstLetter) {
        List<Child> filteredChildren = new ArrayList<>();
        for (Child i : notFilteredChildren) {
            if (i.getLastName().startsWith(firstLetter)) {
                filteredChildren.add(i);
            }
        }
        return filteredChildren;
    }

    public static void calculateAverageAgeOfChildren(List<Child> children) {
        int sum = 0;
        for (Child oneChild : children) {
            sum = sum + oneChild.getAge();
        }
        Double average =  (double) sum / children.size();
        System.out.println(average);
    }

    public static Map<Integer, String> convertListToMap(List<Child> listForConverting) {
        Map<Integer, String> newMap = new HashMap<>();
        for (Child oneChild : listForConverting) {
            newMap.put(oneChild.getId(), oneChild.getLastName());
        }
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
        Map<Integer, String> filteredMap = new HashMap<>();
        notFilteredMap.forEach((key, value) -> {
            if (key > keyId) {
                filteredMap.put(key, value);
            }
        });
        return filteredMap;
    }
}
