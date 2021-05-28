package he.y2020.m5.mayCircuit;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class FactorsOfDivisors1 {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        int tt  = ni();
        while (tt-- > 0) {
            long n = nl();
            long p = nl();
            long ans = ((n) * (n+1))>>1;
            //System.out.println(ans);
            long a = n/p;
            //System.out.println(a);
            //System.out.println(( p* ( (a * (a+1 ))>>1 )));
            ans = ans - ( p* ( (a * (a+1 ))>>1 ));
            ArrayList<Long> power = new ArrayList<>();
            for (long i = p; i <= n ; i = i*p) {
                power.add(i);

            }


            for (long multipleOfP = p; multipleOfP <= n; multipleOfP +=p) {

                long tempAns = 1;
                long tempj = -1;
                long tempk = -1;
                for (long j = 2; j *j <=  multipleOfP; j++) {
                    if(multipleOfP % j ==0) {
                        long k = multipleOfP/j;
                        if(j% p != 0) {
                            if(j > tempAns){
                                tempAns = j;
                                tempj = j;
                                tempk = k;
                            }

                        }
                        if(k %p != 0) {
                            if(k > tempAns){
                                tempAns = k;
                                tempj = j;
                                tempk = k;
                            }
                        }

                    }

                }
                System.out.println(multipleOfP + " " + tempAns + " " + tempj + " " + tempk);
                ans +=tempAns;
            }
            System.out.println(ans);
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
        new FactorsOfDivisors1().run();
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


