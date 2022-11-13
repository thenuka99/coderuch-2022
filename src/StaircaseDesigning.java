import java.util.Scanner;
public class StaircaseDesigning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int Height = sc.nextInt();
        }
        catch (Exception e) {
            System.out.println("Invalid Height!");
        }
        try {
            int Width = sc.nextInt();
        }
        catch (Exception e) {
            System.out.println("Invalid width!");
        }
        try {
            int Length = sc.nextInt();
        }
        catch (Exception e) {
            System.out.println("Invalid Length!");
        }
    }
}
