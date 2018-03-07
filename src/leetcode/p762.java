package leetcode;

public class p762 {


    public int init = 0;
    int[] isNotPrime;

    public void initialize() {
        isNotPrime = new int[20];
        isNotPrime[1] = 1;
        for (int i = 2; i < 20; i++) {
            if (isNotPrime[i] == 0) {
                for (int j = i * 2; j < 20; j += i) {
                    isNotPrime[j] = 1;
                }
            }
        }
    }

    int get1(int x){
        int count = 0;
        while (x > 0) {
            count++;
            x = (x - 1) & x;
        }
        return count;
    }

    public int countPrimeSetBits(int L, int R) {
        if (init == 0) initialize();
        int ret = 0 ;
        for(int i = L; i <=R; i++){
            if(isNotPrime[get1(i)] == 0)ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        p762 a = new p762();
        System.out.println(a.countPrimeSetBits(289051, 294301));
    }
}
