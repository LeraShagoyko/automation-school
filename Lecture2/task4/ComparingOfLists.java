import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ComparingOfLists {
    public static void main(String[] args) {
        timeOfFillingList(new ArrayList<>());

        timeOfFillingList(new LinkedList<>());
    }

    public static void timeOfFillingList(List<Integer> list) {
        Random random1 = new Random();
        LocalTime finish1000Time = LocalTime.now();
        LocalTime startTime = LocalTime.now();
        for (int i = 0; i < 1000000; i++) {
            if (i == 1000) {
                finish1000Time = LocalTime.now();
            }

            list.add(random1.nextInt(100));
        }
        LocalTime finishTime = LocalTime.now();
        System.out.println("List is filled by 1000: " + list.getClass() + ": " + (finish1000Time.getNano() - startTime.getNano()));
        System.out.println("Time of fulling of " + list.getClass() + ": " + (finishTime.getNano() - startTime.getNano()));

        startTime = LocalTime.now();
        for (int i = 0; i < 1000; i++) {
            list.remove(i);
        }
        finishTime = LocalTime.now();
        System.out.println("Time of removing of 1000 elements " + list.getClass() + ": " + (finishTime.getNano() - startTime.getNano()));

        startTime = LocalTime.now();
        for (int i = 500000; i < 500100; i++) {
            list.get(i);
        }
        finishTime = LocalTime.now();
        System.out.println("Time of getting of 1000 elements " + list.getClass() + ": " + (finishTime.getNano() - startTime.getNano()));

    }
}
