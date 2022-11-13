import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HungryBuddies {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String time = scan.next();


        String regex = "[0-9]{2}[:][0-9]{2}[:][0-9]{2}";

        Pattern pattern=Pattern.compile(regex);
        Matcher m = pattern.matcher(time);
        boolean b= Pattern.matches(regex,time);
        if(!b){
            System.out.println("invalid input");
        }else{


            double p, s, r, v, k, c;
            if(time.length()>8 || time.isEmpty()){
                System.out.println("Fried Rice - 0");
                System.out.println("Koththu - 0");
                System.out.println("Rice and Curry - 0");
                System.out.println("Total Bill = 0");
                return;
            }

            Boolean testTime = time.matches("\\d{2}:\\d{2}:\\d{2}");
            if(!testTime){
                System.out.println("Fried Rice - 0");
                System.out.println("Koththu - 0");
                System.out.println("Rice and Curry - 0");
                System.out.println("Total Bill = 0");
                return;
            }
            String[] timeSplit = time.split(":");
            p = Double.parseDouble(Character.toString(timeSplit[0].charAt(0)));
            s = Double.parseDouble(Character.toString(timeSplit[0].charAt(1)));
            r = Double.parseDouble(Character.toString(timeSplit[1].charAt(0)));
            v = Double.parseDouble(Character.toString(timeSplit[1].charAt(1)));
            k = Double.parseDouble(Character.toString(timeSplit[2].charAt(0)));
            c = Double.parseDouble(Character.toString(timeSplit[2].charAt(1)));


            double value = (0.95 * p + 0.30 * s + 0.50 * r + 0.60 * v + 0.80 * k + 0.90 * c) / (p + s + r + v + k + c);
            double OHL = ((double) Math.round(value * 1000) / 1000) * 100;

            int H_FR = 20;//20//*15//15//15//*10//10//
            int H_K = 25;//*20//20//*15//15//15//*10//
            int H_RC = 15;//15//15//15//*10//10//10//

            int P_FR = 800;
            int P_K = 950;
            int P_RC = 300;

            int C_FR = 0;
            int C_K = 0;
            int C_RC = 0;
            int total;

            for (int i = 0; i < 12; i++) {
                if (OHL <= 0) {
                    break;
                }
                //KFKRFKRFKRFK
                //FR=20 K=25 RC=15
                if (i == 0) {
                    H_K = H_K - 5;
                    C_K++;
                }
                //FR=20 K=20 RC=15
                if (i == 1) {
                    H_FR = H_FR - 5;
                    C_FR++;
                }
                //FR=15 K=20 RC=15
                if (i == 2) {
                    H_K = H_K - 5;
                    C_K++;
                }
                //FR=15 K=15 RC=15
                if (i == 3) {
                    H_RC = H_RC - 5;
                    C_RC++;
                }
                //FR=15 K=15 RC=10
                if (i == 4) {
                    H_FR = H_FR - 5;
                    C_FR++;
                }
                //FR=10 K=15 RC=10
                if (i == 5) {
                    H_K = H_K - 5;
                    C_K++;
                }
                //FR=10 K=10 RC=10
                if (i == 6) {
                    H_RC = H_RC - 5;
                    C_RC++;
                }
                //FR=10 K=10 RC=5
                if (i == 7) {
                    H_FR = H_FR - 5;
                    C_FR++;
                }
                //FR=5 K=10 RC=5
                if (i == 8) {
                    H_K = H_K - 5;
                    C_K++;
                }
                //FR=5 K=5 RC=5
                if (i == 9) {
                    H_RC = H_RC - 5;
                    C_RC++;
                }
                //FR=5 K=5 RC=0
                if (i == 10) {
                    H_FR = H_FR - 5;
                    C_FR++;
                }
                //FR=0 K=5 RC=0
                if (i == 11) {
                    H_K = H_K - 5;
                    C_K++;
                }

                OHL = OHL - 25;
            }

            total = C_FR * P_FR + C_K * P_K + C_RC * P_RC;

            System.out.println("Fried Rice - " + C_FR);
            System.out.println("Koththu - " + C_K);
            System.out.println("Rice and Curry - " + C_RC);
            System.out.println("Total Bill = " + total);
        }
    }
}
