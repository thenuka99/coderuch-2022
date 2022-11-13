import java.math.*;
import java.util.*;

public class Assignment {

    public static void main(String args[])
    {
        int p, q, n, z, d = 0, e, i;

        //Ask the user to enter two prime numbers as p and q.
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter a prime number for Number_p :");
        p=sn.nextInt();
        if (!isPrime(p)){
            while(true){
                System.out.println("p is not a prime number.please enter again");
                System.out.println("------------------------------------------");
                System.out.print("Enter a prime number for Number_p :");
                p=sn.nextInt();
                if (isPrime(p)) {
                    break;
                }
            }
        }


        System.out.print("Enter a prime number for Number_q :");
        q=sn.nextInt();
        if (!isPrime(q)){
            while(true){
                System.out.println("q is not a prime number.please enter again");
                System.out.println("------------------------------------------");
                System.out.print("Enter a prime number for Number_q :");
                q=sn.nextInt();
                if (isPrime(q)) {
                    break;
                }
            }
        }

        System.out.println("------------ You may proceed !!-----------");

        //  Ask the user to enter the plain text value.
        // The number to be encrypted and decrypted

        int plaintext;

        System.out.print("Enter the plain text value :");
        plaintext=sn.nextInt();

        double c;
        BigInteger msgback;

        n = p * q;
        z = (p - 1) * (q - 1);
        System.out.println("the value of z = " + z);

        for (e = 2; e < z; e++) {

            // e is for public key exponent
            if (gcd(e, z) == 1) {
                break;
            }
        }
        System.out.println("the value of Public Key = " + e);
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);

            // d is for private key exponent
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("the value of Private Key = " + d);
        c = (Math.pow(plaintext, e)) % n;
        System.out.println("Encrypted message is : " + c);

        // converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf(n);

        // converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        System.out.println("Decrypted message is : "
                + msgback);
    }

    static int gcd(int e, int z)
    {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }

    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}