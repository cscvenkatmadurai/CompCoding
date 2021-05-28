package lc;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;
import java.util.stream.Collectors;

/**
 *
 *https://leetcode.com/problems/3sum/submissions/
 *
 * Runtime: 92 ms, faster than 31.23% of Java online submissions for 3Sum.
 * Memory Usage: 44.3 MB, less than 33.94% of Java online submissions for 3Sum.
 */
public class ThreeSum {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        System.out.println(Boolean.TRUE.equals(false));

        final long l = System.currentTimeMillis();
        System.out.println(threeSum(new int[]{-4,0,4,100,150,300,400}));
        System.out.println(System.currentTimeMillis() - l);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3 ) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int minNumber = nums[0];
        int secondMinNUmber = nums[1];
        int maxNumber = nums[nums.length-1];
        if(minNumber > 0 || maxNumber < 0 ) {
            return new ArrayList<>();
        }

        if(minNumber == 0 && maxNumber == 0 ) {
            final ArrayList<List<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> al = new ArrayList<>();
            al.add(0);
            al.add(0);
            al.add(0);
            lists.add(al);
            return lists;
        }

        Set<List<Integer>>  result = new HashSet<>();

        HashMap<Integer, Integer> numberToFirstOccureencePosition = new HashMap<>();
        for (int posC = 0; posC < nums.length && (minNumber + secondMinNUmber + nums[posC]) < 1; posC++) {
            for (int posB = 0; posB < posC  ; posB++) {
                int a = -(nums[posB] + nums[posC]);
                //System.out.println(a + " " + nums[posB] + " " + nums[posC] );
                if(a < minNumber) {
                    break;
                    //System.out.println("minCase: " + a + " " + nums[posB] + " " + nums[posC] + " minNumber: " + minNumber  );

                }
               /* System.out.println(a + " posB  " + posB + " posC  "
                        + posC + "  posBValue " + nums[posB] + " posCValue " + nums[posC]);
                System.out.println("numberToFirstOccureencePosition: " + numberToFirstOccureencePosition);
                System.out.println("a " + a + " containsA " +  numberToFirstOccureencePosition.containsKey(a));*/
                if(numberToFirstOccureencePosition.containsKey(a) && numberToFirstOccureencePosition.get(a) < posB) {
                    final List<Integer> integers = Arrays.asList(a, nums[posB], nums[posC]);
                    //Collections.sort(integers);
                    //System.out.println(integers);
                    result.add(integers);
                }



            }
            numberToFirstOccureencePosition.putIfAbsent(nums[posC], posC);
         /*   System.out.println();
            System.out.println();
            System.out.println();*/

        }

        return new ArrayList<List<Integer>>(result);

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
        new ThreeSum().run();
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


