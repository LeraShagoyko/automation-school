import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();

        int upperCount = 1;
        for (int i = s; i >= 1; i--) {

            for (int j = i; j >= 1; j--) {
                System.out.print(" ");
            }
            System.out.print("*");

            for (int j = 0; j <= upperCount - 2; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= upperCount - 2; j++) {
                System.out.print(" ");
            }

            if (upperCount != 1) {
                System.out.print("*");
            }

            upperCount++;
            System.out.print("\n");
        }

        int lowerCount = s - 1;
        for (int i = 1; i <= s - 1; i++) {

            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");

            for (int j = 0; j <= lowerCount - 2; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= lowerCount - 2; j++) {
                System.out.print(" ");
            }

            if (lowerCount != 1) {
                System.out.print("*");
            }

            lowerCount--;
            System.out.print("\n");
        }
    }
}
