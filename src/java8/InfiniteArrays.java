package java8;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;

public class InfiniteArrays {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        int tt = ni();
        while (tt-- > 0) {
            long n = nl();
            long[] arr = new long[(int)n + 1];
            long[] prefix = new long[(int)n + 1];
            long sum = 0;


            for (int i = 1; i <= n; i++) {
                arr[i] = nl();
                prefix[i] = (arr[i] + prefix[i - 1]);
                sum = (sum + arr[i]);
            }


            int q = ni();
            double[] leftIndex = new double[q];
            for (int i = 0; i < leftIndex.length; i++) {
                leftIndex[i] = nd();
            }

            double[] rightIndex = new double[q];
            for (int i = 0; i < rightIndex.length; i++) {
                rightIndex[i] = nd();
            }

            for (int i = 0; i < q; i++) {
                double l = leftIndex[i];
                double r = rightIndex[i];
                double doubleN = (double) n;

                if ((l / n) == (r / n)) {
                    final double rightMode = ((r % n) == 0)? r : (r % n);
                    final int leftMode = (int)(((l % n) == 0) ? n - 1 : (l % n) - 1);
                    System.out.print( (prefix[(int)rightMode  ] - prefix[leftMode])%1000000007);

                } else {

                    final int leftMode = (int)(((l % n) == 0) ? n - 1 : (l % n) - 1);
                    BigInteger left = new BigInteger(Long.toString(sum)).subtract(new BigInteger(Long.toString(prefix[leftMode])));

                    final double v = Math.floor(r / doubleN) - Math.ceil(l / doubleN);
                    BigInteger v1 = new BigInteger(Long.toString((long)v));
                     BigInteger middle = v1.multiply(new BigInteger(Long.toString(sum)));
                    BigInteger right = new BigInteger(Long.toString(prefix[(int) (r % n)]));
                    System.out.print( (left.add(middle).add(right)).mod( new BigInteger(Long.toString(1000000007))));
                }
                System.out.print(" ");


            }
            System.out.println();
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
        new InfiniteArrays().run();
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


