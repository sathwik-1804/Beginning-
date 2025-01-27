import java.util.Scanner;
public class NumberRaised {
    private static final int MOD = 1000000007;
    public static long modularExponentiation(int base, int exponent, int mod) {
        long result = 1;
        long baseMod = base % mod;
        while (exponent > 0) {
            if ((exponent % 2) == 1) {
                result = (result * baseMod) % mod;
            }
            baseMod = (baseMod * baseMod) % mod;
            exponent /= 2;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        long result = modularExponentiation(n, r, MOD);
        System.out.println(result);
        sc.close();
    }
}