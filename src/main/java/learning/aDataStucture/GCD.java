package learning.aDataStucture;

public class GCD {

    public static void main(String as[]) {
        long a = 90, b = 240;

        long gcd = _gcd(a, b);
        long lcm = _lcm(a, b, gcd);
        System.out.println("gcd: " + gcd);
        System.out.println("lcm: " + lcm);
    }

    private static long _gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        if (a == 0) {
            return b;
        }
        return a > b ? _gcd(b, a % b) : _gcd(a, b % a);
    }

    private static long _lcm(long a, long b, long gcd) {
        return (a * b) / gcd;
    }
}
