public class invFact {

    private static final int N = 100000;
    private static long[] fact = new long[N + 1];
    private static long[] invFact = new long[N + 1];
    private static final int mod = 1000000007;

    public static long modExp(long x, int y, int mod) {
        long res = 1L;
        x %= mod;
        while(y > 0) {
            if((y & 1) == 1) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            y = y >> 1;
        }
        return res;
    }

    static {
        fact[0] = 1L;
        for(int i = 1; i <= N; i++) {
            fact[i] = (fact[i-1] * i) % mod;
        }

        invFact[N] = modExp(fact[N], mod-2, mod);
        for(int i = N-1; i >= 0; i--) {
            invFact[i] = (invFact[i+1] * (i+1)) % mod;
        }
    }
    public static long nCr(int n, int r) {
        if(r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % mod) * invFact[n-r]) % mod;
    }
}