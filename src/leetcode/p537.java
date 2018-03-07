package leetcode;

public class p537 {
    public String complexNumberMultiply(String a, String b) {
        String[] aa = a.split("\\+");
        String[] bb = b.split("\\+");
        int a0 = Integer.parseInt(aa[0]);
        int a1 = Integer.parseInt(aa[1].substring(0, aa[1].length() - 1));
        int b0 = Integer.parseInt(bb[0]);
        int b1 = Integer.parseInt(bb[1].substring(0, aa[1].length() - 1));
        return Integer.toString(a0 * b0 - a1 * b1) + "+" + Integer.toString(a0 * b1 + a1 * b0) + "i";
    }

    public static void main(String[] args) {
        p537 a = new p537();
        System.out.println(a.complexNumberMultiply("1+1i", "1+1i"));
    }
}
