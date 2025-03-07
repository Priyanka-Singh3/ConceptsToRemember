package Maths;

import java.util.ArrayList;

public class PrimeFactors {
    public static void primeFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 2; i * i <= n ; i++) {
            if(n % i == 0) {
                factors.add(i);
                while(n % i == 0) {
                    n /= i;
                }
            }
        }
        if(n != 1) factors.add(n);
    }
}
