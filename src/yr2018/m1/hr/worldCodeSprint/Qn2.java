package yr2018.m1.hr.worldCodeSprint;
/*


https://www.hackerrank.com/contests/world-codesprint-12/challenges/red-knights-shortest-path
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;


/**
 * Created by cscvenkatmadurai on 12/14/2016.
 */
public class Qn2 {
    public static final String DELIMITER = " ";
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    int N,s_r,s_c,e_r,e_c;
    HashMap<String,String> map = new HashMap<>();
    char[][] pattern = {{'a', 'c'}, {'b', 'd'}, {'c', 'a'}, {'d', 'b'}};
    String dir[] = {"UL", "UR", "R", "LR", "LL", "L"};
    int rowOp[] = {-2, -2, 0,  2, 2, 0 };
    int colOp[] = {-1 ,1, 2, 1, -1, -2 };


    boolean isValidRow(int r){
        if(r >= 0 && r< N ){
            return true;

        }
        return false;

    }

    boolean isValidCol(int c){
        if(c >= 0 && c < N){
            return true;
        }
        return false;
    }

    boolean isValidCell(int r, int c){
        return isValidRow(r) && isValidCol(c);
    }


    void solve() {
        N = ni();
        s_r = ni();
        s_c = ni();
        e_r = ni();
        e_c = ni();
        map.put(s_r+" "+s_c,null);

        if(pattern[s_r%4][s_c%2] != pattern[e_r%4][e_c%2]){
            System.out.println("Impossible");
        }else{
         //   System.out.println("In else");
            Queue<String> queue[] = new LinkedList[2];
            queue[0] = new LinkedList<>();
            queue[1] = new LinkedList<>();
            queue[0].add(s_r+" "+s_c);
            int  distance = 0;
            while (queue[0] != null && queue[0].size() > 0){


                String t = queue[0].remove();
               // System.out.println(t);

                int r = Integer.parseInt( t.split(" ")[0]);
                int c = Integer.parseInt(t.split(" ")[1]);
                if(r == e_r && c == e_c){
                    System.out.println(distance);
                    String ans = "";
                    while ( map .get(r+DELIMITER+c) != null){
                        t = map.get(r+DELIMITER+c);
                        ans = t.split(DELIMITER)[2]+" "+ans;
                        r = Integer.parseInt(t.split(DELIMITER)[0]);
                        c = Integer.parseInt(t.split(DELIMITER)[1]);

                    }
                    System.out.println(ans);
                    return;
                }else{
                    //System.out.print(r+" "+c+" ");
                    for (int i = 0; i < dir.length; i++) {
                        int t_r = r + rowOp[i];
                        int t_c = c + colOp[i];
                        if(isValidCell(t_r, t_c) && !map.containsKey(t_r+DELIMITER+t_c)){
                            map.put(t_r+DELIMITER+t_c,r+DELIMITER+c+DELIMITER+dir[i] );
                            queue[1].add(t_r+ DELIMITER +t_c);
                       //     System.out.print(t_r+ DELIMITER +t_c+DELIMITER+dir[i]);
                        }
                      //  System.out.println();

                    }
                    if(queue[0].size() == 0){
                        queue[0] = queue[1];
                        queue[1] = new LinkedList<>();
                        distance++;
                     //   System.out.println(r+" "+c+" "+queue[0]+" "+map);

                    }

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
        new Qn2().run();
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