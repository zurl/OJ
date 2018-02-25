package leetcode;

public class p780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if( sx == tx && sy == ty) return true;
        if( sx > tx || sy > ty) return false;
        if( sx == tx && ty % sx == sy) return true;
        if( sy == ty && tx % sy == sx) return true;
        if( tx < ty ) return reachingPoints(sx, sy, tx, ty % tx);
        else return reachingPoints(sx, sy, tx % ty, ty);
    }
}
