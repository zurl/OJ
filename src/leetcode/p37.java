package leetcode;

public class p37 {

    char[][] m;
    boolean[][] row, col, grp;

    int getgrp(int i, int j){
        return (j / 3 * 3) + i / 3;
    }

    int nexti(int i, int j){
        if(j == 8) return i + 1;
        else return i;
    }

    int nextj(int i, int j){
        if(j == 8) return 0;
        else return j + 1;
    }

    int ok = 0;

    void dfs(int i, int j){
        if( ok == 1 ) return;
        if( i == 9) {
            ok = 1;
        }
        else if(m[i][j] == '.'){
            for(int k = 0; k < 9; k++){
                if(!row[i][k] && !col[j][k] && !grp[getgrp(i, j)][k]){
                    row[i][k] = true;
                    col[j][k] = true;
                    grp[getgrp(i, j)][k] = true;
                    m[i][j] = (char)('1' + k);
                    dfs(nexti(i, j), nextj(i, j));
                    if( ok == 1) return;
                    m[i][j] = '.';
                    row[i][k] = false;
                    col[j][k] = false;
                    grp[getgrp(i, j)][k] = false;
                }
            }
        }
        else dfs(nexti(i, j), nextj(i, j));
    }

    public void solveSudoku(char[][] board) {
        m = board;
        ok = 0;
        row = new boolean[9][9];
        col = new boolean[9][9];
        grp = new boolean[9][9];
        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 9; j ++){
                if( board[i][j] != '.'){
                    int v = board[i][j] - '1';
                    row[i][v] = true;
                    col[j][v] = true;
                    grp[getgrp(i, j)][v] = true;
                }
            }
        }
        dfs(0, 0);
    }

    public static void main(String[] args) {
        p37 a = new p37();
        a.solveSudoku(new char[][]{{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}});

    }

}
