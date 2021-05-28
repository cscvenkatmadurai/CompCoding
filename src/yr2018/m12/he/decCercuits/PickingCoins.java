package yr2018.m12.he.decCercuits;




import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.InputMismatchException;

public class PickingCoins {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        int tt = ni();
        while (tt -- > 0) {
            long n = nl();
            BigDecimal nB = new BigDecimal(Long.toString(n + 2 ));
            long k = nl();
            BigDecimal kB = new BigDecimal(Long.toString(k));

            final BigDecimal two = new BigDecimal("2");
            BigDecimal t = two.subtract(nB).add(kB.multiply(nB));
            final double a = t.divide(two.multiply(kB),30, RoundingMode.FLOOR ).doubleValue();
            final double b = kB.doubleValue();
            final double v = Math.log(a) / Math.log(b);

            if(k  == 1 && n% 2 == 0) {
                System.out.println("Bob");

            }else if(k ==  1 && n %2 != 0 ){
                System.out.println("Alice");
            }else if(n == k ) {

            }else if( v < 1) {

                long alice = 1;
                long bob = 1;
                while(n >= 0 ) {
                    alice *= k;
                    if( n - alice >= 0) {
                        n = n-alice;
                    }else {
                        System.out.println("Bob");
                        break;
                    }

                    bob *= k;
                    if( n - bob >= 0) {
                        n -= bob;
                    }else {
                        System.out.println("Alice");
                        break;
                    }

                }


            }else {


                final double floor = Math.floor(v);
                double t4 = ((((double) 2) * (1 - Math.pow((double) k, floor + (double) 1))) / (((double) 1) - (k)));
               // System.out.println(t4);
                if (t4 + Math.pow(k, floor + 1) <= n) {
                    System.out.println("Alice");
                } else {
                    System.out.println("Bob");
                }
            }

        }

    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        out.flush();
        if (!INPUT.isEmpty()) tr(System.currentTimeMillis() - s + "ms");
    }

    public static void main(String[] args) throws Exception {
        new PickingCoins().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private static void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}





