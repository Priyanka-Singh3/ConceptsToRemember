package Maths;
import java.util.*;

public class SeiveOfEratosthenes {
    public static void seive(int n) {
        // find primes till n

        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);

        for (int i = 2; i * i <= n; i++) {
            if(prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}
