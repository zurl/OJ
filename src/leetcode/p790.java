package leetcode;

public class p790 {

    long[] f, g, h;
    public int numTilings(int N) {
        long MOD = 1000000007;
        f = new long[N + 1];
        g = new long[N + 1];
        h = new long[N + 1];
        f[0] = 1;
        f[1] = 1;
        g[1] = 1;
        h[1] = 1;
        for(int i = 2; i <= N; i++){
            f[i] = (f[i - 1] + f[i - 2] + g[i - 2] + h[i - 2]) % MOD;
            g[i] = (f[i - 1] + h[i - 1]) % MOD;
            h[i] = (f[i - 1] + g[i - 1]) % MOD;
        }
        return (int)(f[N] % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new p790().numTilings(5));
    }
}
