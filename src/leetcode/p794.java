package leetcode;

public class p794 {

    public boolean validTicTacToe(String[] board) {
        int O = 0, X = 0;
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                if(board[i].charAt(j) == 'X') X ++;
                if(board[i].charAt(j) == 'O') O ++;
            }
        }
        if( ! ( X == O || X == O + 1) ) return false;
        int lpos = -1, ltype = -1, rpos = -1, rtype = -1, wintype = -1;
        for(int i = 0; i < 3; i ++){
            if(board[i].charAt(0) == 'X' && board[i].charAt(1) == 'X' && board[i].charAt(2) == 'X'){
                if( lpos != -1 ) return false;
                lpos = i; ltype = 1;
                if( wintype == -1) wintype = 1;
                else if( wintype != 1) return false;
            }
            if(board[i].charAt(0) == 'O' && board[i].charAt(1) == 'O' && board[i].charAt(2) == 'O'){
                if( lpos != -1 ) return false;
                lpos = i; ltype = 0;
                if( wintype == -1) wintype = 0;
                else if( wintype != 0) return false;
            }
            if(board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X'){
                if( rpos != -1 ) return false;
                rpos = i; rtype = 1;
                if( wintype == -1) wintype = 1;
                else if( wintype != 1) return false;
            }
            if(board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O' && board[2].charAt(i) == 'O'){
                if( rpos != -1 ) return false;
                rpos = i; rtype = 0;
                if( wintype == -1) wintype = 0;
                else if( wintype != 0) return false;
            }
        }

        int dpos = -1, dtype = -1, epos = -1, etype = -1;
        if(board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O'){
            dpos = 0; dtype = 0;
            if( wintype == -1) wintype = 0;
            else if( wintype != 0) return false;
        }
        if(board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X'){
            dpos = 0; dtype = 1;
            if( wintype == -1) wintype = 1;
            else if( wintype != 1) return false;
        }
        if(board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O'){
            epos = 1; etype = 0;
            if( wintype == -1) wintype = 0;
            else if( wintype != 0) return false;
        }
        if(board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X'){
            epos = 1; etype = 1;
            if( wintype == -1) wintype = 1;
            else if( wintype != 1) return false;
        }
        if( wintype == 0 && X != O ) return false;
        if( wintype == 1 && X != O + 1 ) return false;
        if( lpos != -1 && rpos != -1){
            if( dpos != -1 || epos != -1) return false;
            if( ltype != rtype ) return false;
            if( lpos != rpos) return false;
        }
        if( lpos != -1 && dpos != -1){
            if( epos != -1 ) return false;
            if( ltype != dtype) return false;
        }
        if( rpos != -1 && dpos != -1){
            if( epos != -1 ) return false;
            if( rtype != dtype) return false;
        }
        if( lpos != -1 && epos != -1){
            if( dpos != -1 ) return false;
            if( ltype != etype) return false;
        }
        if( rpos != -1 && epos != -1){
            if( dpos != -1 ) return false;
            if( rtype != etype ) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        p794 a = new p794();
    }
}
