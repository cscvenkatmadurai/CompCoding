package yr2018.m12.he.decCercuits;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;

public class SuperiorSubstring {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        NlogN("ovppcjhlxpp");


        int tt = ni();
        while (tt-- > 0) {
            int length = ni() + 1;
            String s = ns();
           // System.out.println(s.length());
            System.out.println(NlogN(s) );

        }
    }

    private void findTT() {
        Random r = new Random();
        while (true) {
            int n = r.nextInt(20) +1;
            String s = "";
            for (int i = 0; i < n; i++) {
                s += (char)(r.nextInt(26) + 97);
            }
            if(bf(s) != NlogN(s)) {
                System.out.println(s + " " + bf(s) + " " + NlogN(s)) ;
                break;
            } else {
                System.out.println(s + " " + bf(s) + " " + NlogN(s)) ;
            }

        }
    }

    private int bf(String s) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int count[] = new int[26];
            for (int j = i; j < s.length(); j++) {
                count[s.charAt(j)-97]++;
                for (int k = 0; k < count.length; k++) {
//                    if( i == 0 && j == 4) {
//                        System.out.println((char)(k+97) + " " + count[k]);
//                        System.out.println(((j-i+1)/2)  + " " + ans);
//                    }

                    if( (count[k] >= ((j-i+1)/2))  ) {
                        if((j-i +1) > ans) {
                           // System.out.println("$$$" + i + " " + j );
                            ans = (j - i + 1);
                        }
                    }

                }

            }
        }
        return ans;

    }

    private int NlogN(String s) {
        int length;
        length = s.length() + 1;
        if(s.length() < 4) {
            //System.out.println(s.length());
            return s.length();
        }
        s = ' ' + s;
        int maxVal = Integer.MIN_VALUE;
        int minVal = 1;

        int countOfChars[][] = new int[length][26];
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < 26; j++) {
                countOfChars[i][j] = countOfChars[i-1][j];
                if(s.charAt(i)-97 == j) {
                    countOfChars[i][j]++;
                }
                if(countOfChars[i][j] > maxVal) {
                    maxVal = countOfChars[i][j];
                }

            }

        }
        int answer = 0;

        if(((maxVal<<1)+1) <= length-1 ) {
            maxVal = ((maxVal<<1)+1);
        } else {
            maxVal = length-1;
        }
       // System.out.println("len" + length);
        while (minVal < maxVal  ) {
            boolean isValid = false;
            int medium = minVal + ((maxVal-minVal)>>1);

            if( (medium & 1) == 0) {
                if( (medium +1) < length -1 ) {
                    medium = medium +1;
                }else {
                    medium = length -1;
                }
            }
           System.out.println(s + " medium " + medium + " " + minVal + " " + maxVal  );
            for (int i = 1; i + medium-1 < countOfChars.length; i++) {
                for (int j = 0; j < 26; j++) {
                    if((countOfChars[i + medium-1][j]-countOfChars[i-1][j]) >= (medium>>1) ) {
                        answer = Math.max(answer, medium);
                        isValid = true;
                       System.out.println(medium + " " + i + " " + (i + medium-1) + " " + (char)(97 + j));
                    }

                }

            }
            if(isValid) {
                minVal = medium +1;
            }else {
                maxVal = medium -1;
            }

        }

        if(minVal == maxVal ) {
            for (int i = 1; i + maxVal-1 < countOfChars.length; i++) {
                for (int j = 0; j < 26; j++) {
                    if((countOfChars[i + maxVal-1][j]-countOfChars[i-1][j]) >= (maxVal>>1) ) {
                        answer = Math.max(answer, maxVal);

                    }

                }

            }
        }
        return answer;
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
        new SuperiorSubstring().run();
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


