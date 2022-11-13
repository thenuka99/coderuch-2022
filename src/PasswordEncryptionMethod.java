import java.util.Scanner;
public class PasswordEncryptionMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr1= new int[n];
        String[] arr2= new String[n];
        int[] arr3= new int[n];
        for(int i=0; i<n; i++)
        {
            arr1[i]=sc.nextInt();
        }

        for(int i=0; i<n; i++) {
            arr2[i]= Integer.toHexString(arr1[i]);
        }
        for(int i=0; i<n; i++)
        {
            arr2[i] = arr2[i].replaceAll("[^\\d.]", "");

        }
        int total=0;
        for(int i=0; i<n; i++)
        {
           arr3[i]= Integer.parseInt(arr2[i]);
        }
        for(int i=0; i<n; i++)
        {
            total+= arr3[i];
        }
        System.out.println(total);
    }
}
