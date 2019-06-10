package Task1_1;

import java.util.Scanner;

public class Mother {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        StringBuffer buffer = new StringBuffer(s);
        buffer.reverse();
        System.out.println(buffer);

        System.out.println(s.replace(' ', '\n'));

        System.out.println(s.replace(' ', '*'));

        System.out.println(s.toUpperCase());

        String substr = s.substring(5,11);
        System.out.println(substr);
    }
}