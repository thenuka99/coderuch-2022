import java.util.*;
import java.math.*;

class RSA
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int p,q,n,z,d=0,e,i;
        BigInteger msgback;
        System.out.print("Enter 1st prime number P = ");
        boolean P=isPrime(p=sc.nextInt());
        System.out.print("Enter 2nd prime number Q = ");
        boolean Q= isPrime(q=sc.nextInt());
        System.out.println();

        if(P & Q == true) {
            n = p * q;
            z = (p - 1) * (q - 1);
            System.out.println();
            System.out.println("The value of z = " + z);

            for (e = 2; e < z; e++) {
                if (gcd(e, z) == 1)            // e is for public key exponent
                {
                    break;
                }
            }

            for (i = 0; i <= 9; i++) {
                int x = 1 + (i * z);
                if (x % e == 0)      //d is for private key exponent
                {
                    d = x / e;
                    break;
                }
            }
            System.out.println("The Private key value of d = " + d);
            System.out.println("The Public key value of e = " + e);
            System.out.println();
            System.out.print("Enter the plain text value = ");
            int msg = sc.nextInt();
            double c;
            c = (Math.pow(msg, e)) % n;
            System.out.print("Encrypted message is : ");
            System.out.println(c);
            //converting int value of n to BigInteger
            BigInteger N = BigInteger.valueOf(n);
            //converting float value of c to BigInteger
            BigInteger C = BigDecimal.valueOf(c).toBigInteger();
            msgback = (C.pow(d)).mod(N);
            System.out.print("Derypted message is : ");
            System.out.println(msgback);
        }
        else {


            System.out.println("You entered P = " + p + " and Q = " + q);
            if ((!isPrime(p)) && (isPrime(q))) {
                System.out.println(+p + " = P , This value is not a Prime value. Please Re-enter value for P & Q");

            } else if ((isPrime(p)) && (!isPrime(q))) {
                System.out.println(+q + " = Q , This value is not a Prime value. Please Re-enter value for P & Q");

            } else {
                System.out.println("Both P & Q values are not Prime values. Please Re-enter value for P & Q");
            }

            System.out.print("Do you want to enter the value again [Y:N] :");
            String choice=sc.next();
            System.out.println();
            switch (choice){
                case "Y": case "y": main(args); break;
                default:break;
            }


        }
    }

    static int gcd(int e, int z)
    {
        if(e==0)
            return z;
        else
            return gcd(z%e,e);
    }
    static boolean isPrime(int num){
        if(num<=1)
        {
            return false;
        }
        for(int i=2;i<=num/2;i++)
        {
            if((num%i)==0)
                return  false;
        }
        return true;

    }
}