import java.util.Scanner;
public class COMTel {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String pattern1 = sc.next();
        String pattern2 = sc.next();
        String[] arr1 = pattern1.split("");
        String[] arr2 = pattern2.split("");
        String[] arr3 = new String[arr1.length];

        int j=0;
        for (int i=arr1.length-1;i>=0;i--){
            arr3[j]=arr1[i];
            j++;
        }
        int size=arr2.length+arr3.length;
        String[] arr4 = new String[size];


        int n=0;
        for (int k=0;k<arr2.length;k++){

            arr4[n]=arr2[k];
            n+=2;
        }
        int m=1;
        for (int k=0;k<arr3.length;k++){

            arr4[m]=arr3[k];
            m+=2;
        }

        String[] arr5 = new String[arr4.length/2];

        int p=0;
        for (int k=0;k<arr5.length;k++){

            arr5[k]=arr4[p].concat(arr4[p+1]);
            p+=2;
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr5.length; i++) {
            output.append((char)Integer.parseInt(arr5[i], 16));
        }
        System.out.println(output);
    }
}
