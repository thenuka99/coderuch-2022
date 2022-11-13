import java.util.Scanner;

public class malmiKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] array = input.split(" ");

        for (int j = 0; j < array.length; j++) {
            if (array[j].matches("-?\\d+(\\.\\d+)?")) {
                int i = Integer.parseInt(array[j]);
                if ((i <= -1 && i >= -127)) {
                    if (i <= -1) {
                        i = Math.abs(i);
                        char asciiValue = (char) i;
                        array[j] = "" + asciiValue;
                    }
                    else{
                        char asciiValue = (char) i;
                        array[j] = "" + asciiValue;
                    }
                }
            }
            System.out.print(array[j] + " ");
        }
    }
}