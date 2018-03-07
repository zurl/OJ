package leetcode;

public class p764 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] m = new int[N][N];
        int[][][] f= new int[4][N][N];
        for(int i = 0; i < mines.length; i++){
            m[mines[i][0]][mines[i][1]] = 1;
        }
        for(int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j++) {
                if (m[i][j] == 1) f[0][i][j] = 0;
                else if( j == 0 ) f[0][i][j] = 1;
                else f[0][i][j] = f[0][i][j - 1] + 1;
                if (m[i][j] == 1) f[1][i][j] = 0;
                else if( i == 0 ) f[1][i][j] = 1;
                else f[1][i][j] = f[1][i - 1][j] + 1;
            }
        }
        for(int i = N - 1; i >= 0 ; i --) {
            for (int j = N - 1; j >= 0 ; j --) {
                if (m[i][j] == 1) f[2][i][j] = 0;
                else if( j == N - 1 ) f[2][i][j] = 1;
                else f[2][i][j] = f[2][i][j + 1] + 1;
                if (m[i][j] == 1) f[3][i][j] = 0;
                else if( i == N - 1 ) f[3][i][j] = 1;
                else f[3][i][j] = f[3][i + 1][j] + 1;
            }
        }
        int maxn = 0;
        for(int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j++) {
                int t = f[0][i][j];
                for(int d = 1; d < 4; d ++){
                    t = Math.min(t, f[d][i][j]);
                }
                maxn = Math.max(t, maxn);
            }
        }
        return maxn;
    }

    public static void main(String[] args) {

    }
}
