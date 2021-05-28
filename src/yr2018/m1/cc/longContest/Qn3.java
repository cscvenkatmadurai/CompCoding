package yr2018.m1.cc.longContest;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;


/**
 * Created by cscvenkatmadurai on 12/14/2016.
 */
public class Qn3 {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        int tt = ni();
        int n;
        long k,arr[];

        while (tt-- > 0){

            n = ni();
            k = nl();
            arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nl();
            }
            System.out.println(l1(n,k,arr));




        }


    }

    private long l1(int n, long k, long[] arr) {
        long maxSuffix;
        long maxPrefix;
        long arrSum;
        long tSuffixSum;
        long tPrefixSum;
        long ans = 0;
        long maxNeg = Integer.MIN_VALUE;
        maxPrefix = maxSuffix = 0;
        tPrefixSum = tSuffixSum = arrSum = 0;
        boolean isAllNumbersNegative = true;
        for (int i = 0; i < n; i++) {
            tPrefixSum += arr[i];
           // System.out.println(tSuffixSum+" "+arr[n-i-1]);
            tSuffixSum += arr[n-i-1];
            arrSum += arr[i];
            if(tPrefixSum > maxPrefix){
                maxPrefix = tPrefixSum;
            }
            if(tSuffixSum > maxSuffix){
                maxSuffix = tSuffixSum;
            }
            if(arr[i] > 0){
                isAllNumbersNegative = false;
            }
            if(isAllNumbersNegative){
                maxNeg = Math.max(arr[i],maxNeg);
            }

        }

        if(isAllNumbersNegative){

            return maxNeg;
        }else if(n == 1){
            ans = Math.max(arr[0],arr[0]*k);
        }else if(k > 2) {
            if (arrSum < 0) {
                arrSum = 0;
            }
            ans = Math.max(maxPrefix + (arrSum * (k - (long)2)) + maxSuffix,maxSubArraySum(arr)) ;
        }else if(k == 2){

            ans =Math.max( Math.max(maxPrefix+maxSuffix,arrSum*(long)2),maxSubArraySum(arr));
        }else{
            ans = maxSubArraySum(arr);
        }
        return ans;
    }
    private long l2(long n, long k, long arr[]){
        long t[] = new long[(int)n*(int)k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                t[i+(j*(int)n)] = arr[i];
            }
        }
        return maxSubArraySum(t);
    }

    static long maxSubArraySum(long a[])
    {
        long max_so_far = a[0];
        long curr_max = a[0];

        for (int i = 1; i < a.length; i++)
        {
            curr_max = Math.max(a[i], curr_max+a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
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
        new Qn3().run();
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