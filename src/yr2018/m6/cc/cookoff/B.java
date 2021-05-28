package yr2018.m6.cc.cookoff;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.*;

public class B {

    int getno(){
        System.out.println("hello");
        return 100;
    }
    public B(){
        System.out.println("constructor");
    }

    int number  = getno();
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    int k;
    int ip[];
    List<Integer> zeroIndexList;
    int result = 0;

    void solve() {
        int tt = ni();
        while (tt-- > 0) {
            int n = ni();
            k = ni();
            boolean temp[] = new boolean[n + 1];
            ip = new int[n];
            zeroIndexList = new ArrayList<>();
            int zeroSize = 0;
            for (int i = 0; i < n; i++) {
                ip[i] = ni();
                if (ip[i] != 0) {
                    temp[ip[i]] = true;
                } else {
                    zeroSize++;
                    zeroIndexList.add(i);
                }

            }
            result = 0;
            if (zeroIndexList.size() > 0) {
                int zeroArray[] = new int[zeroSize];
                for (int i = 1, j = 0; i < temp.length; i++) {
                    if (!temp[i]) {

                        zeroArray[j++] = i;

                    }

                }
                permute(zeroArray, 0, zeroSize - 1);
            }else{
                int tempK = 0;
                for (int i = 1; i < ip.length; i++) {
                    if(ip[i] > ip[i-1]){
                        tempK++;
                    }
                }
                if(tempK == k){
                    result = 1;
                }
            }
            System.out.println(result);


        }
    }


    public void permute(int arr[] ,int l, int r){
        if(l == r){


            for (int i = 0; i < zeroIndexList.size(); i++) {
                ip[zeroIndexList.get(i)] = arr[i];
            }
            int t = 0;
            for (int i = 1; i < ip.length; i++) {
                if(ip[i] > ip[i-1]){
                    t++;
                }
            }


            if(t == k){
                result++;

            }

            for (int i = 0; i < zeroIndexList.size(); i++) {
                ip[zeroIndexList.get(i)] = 0;
            }
        }else {
            for (int i = l; i <= r ; i++) {
                swap(arr, l ,i);
                permute(arr, l+1 , r);
                swap(arr, l ,i);
            }
        }
    }

    private void swap(int arr[], int l, int r){
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
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
        new B().run();
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


