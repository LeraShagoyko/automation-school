package Task1_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeekDays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        Map<Integer, String> days = new HashMap<Integer, String>();
        days.put(1, "понедельник");
        days.put(2, "вторник");
        days.put(3, "среда");
        days.put(4, "четверг");
        days.put(5, "пятница");
        days.put(6, "суббота");
        days.put(7, "воскресенье");

        if (days.containsKey(x)) {
            System.out.println(days.get(x));
        } else {
            System.out.println("Нет такого дня");
        }
    }
}

