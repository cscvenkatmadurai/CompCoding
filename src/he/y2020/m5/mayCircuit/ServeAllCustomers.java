package he.y2020.m5.mayCircuit;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.PriorityQueue;


class Chef {
    long nextFreeTime;

    @Override
    public String toString() {
        return "Chef{" +
                "nextFreeTime=" + nextFreeTime +
                '}';
    }
}

class Customer {
    int id;
    long arrivalTime;
    long prepTime;
    long disVal;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", arrivalTime=" + arrivalTime +
                ", prepTime=" + prepTime +
                ", disVal=" + disVal +
                '}';
    }
}

public class ServeAllCustomers {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        int n = ni();
        int k = ni();
        long ans[] = new long[n];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = -1;
        }
        PriorityQueue<Customer> customerPriorityQueue = new PriorityQueue<>(Comparator.comparing(o -> o.arrivalTime));
        Customer[] customers = new Customer[n];
        for (int i = 0; i < n; i++) {
            customers[i] = new Customer();
            customers[i].id = i;
            customers[i].arrivalTime = nl();
        }
        for (int i = 0; i < n; i++) {
            customers[i].prepTime = nl();
        }
        for (int i = 0; i < n; i++) {
            customers[i].disVal = -nl();
            customerPriorityQueue.add(customers[i]);
        }

        PriorityQueue<Chef> chef = new PriorityQueue<Chef>(Comparator.comparingLong(o -> o.nextFreeTime));
        for (int i = 0; i < k; i++) {
            chef.add(new Chef());
        }


        long time = Math.max(1, chef.peek().nextFreeTime);
        long tenPow9 = (long) Math.pow(10, 9);
        final Comparator<Customer> customerComparator = Comparator.comparingLong(o -> (o.disVal * o.prepTime));
        //final Comparator<Customer> cusComp1 = customerComparator.thenComparing(o -> (-1 *o.prepTime));
        PriorityQueue<Customer> leftCustomers = new PriorityQueue<Customer>(customerComparator);

        while (!customerPriorityQueue.isEmpty() && time < tenPow9) {
            while (!customerPriorityQueue.isEmpty() && customerPriorityQueue.peek().arrivalTime <= time) {
                leftCustomers.add(customerPriorityQueue.poll());

            }

            while (!leftCustomers.isEmpty() && chef.peek().nextFreeTime <= time) {
                //System.out.println(leftCustomers);
                //System.out.println(chef);
                final Customer servingCustomer = leftCustomers.poll();
                final Chef servingChef = chef.poll();
                //System.out.println("Picked chef: " + servingChef + "  picked customer: " + servingCustomer);
                //System.out.println();

                long servingTime = Math.max(servingChef.nextFreeTime, servingCustomer.arrivalTime);
                if (servingTime + servingCustomer.prepTime < Math.pow(10, 9)) {
                    ans[servingCustomer.id] = servingTime;
                }
                servingChef.nextFreeTime = servingTime + servingCustomer.prepTime;
                chef.add(servingChef);
            }

            if (!customerPriorityQueue.isEmpty()) {
                if (leftCustomers.isEmpty()) {
                    time = customerPriorityQueue.peek().arrivalTime;
                } else {
                    time = Math.max(time+1, chef.peek().nextFreeTime);
                }
            }

        }

        while (!leftCustomers.isEmpty() && chef.peek().nextFreeTime < tenPow9) {
            Customer servingCustomer = leftCustomers.poll();
            Chef servingChef = chef.poll();
            long servingTime = Math.max(servingChef.nextFreeTime, servingCustomer.arrivalTime);
            if (servingTime + servingCustomer.prepTime < Math.pow(10, 9)) {
                ans[servingCustomer.id] = servingTime;
            }
            servingChef.nextFreeTime = servingTime + servingCustomer.prepTime;
            chef.add(servingChef);

        }
        printAnswer(ans);






























        /*
        final Comparator<Customer> customerComparator = Comparator.comparingLong(o -> o.arrivalTime);
        final Comparator<Customer> cusComp1 = customerComparator.thenComparing(o -> o.disVal);
        PriorityQueue<Customer> leftCustomers = new PriorityQueue<Customer>(cusComp1);
        for (int i = 0; i < customers.length; i++) {
            leftCustomers.add(customers[i]);
            long currentTime = customers[i].arrivalTime;

            while (!chef.isEmpty() && !leftCustomers.isEmpty() && chef.peek().nextFreeTime <= leftCustomers.peek().arrivalTime && chef.peek().nextFreeTime < Math.pow(10, 9 )) {
                Customer servingCustomer = leftCustomers.poll();
                Chef servingChef = chef.poll();
                //System.out.println(i + " " + leftCustomers + " " + chef);
                long servingTime = Math.max(servingChef.nextFreeTime, servingCustomer.arrivalTime);
                if(servingTime + servingCustomer.prepTime < Math.pow(10, 9)) {
                    ans[servingCustomer.id] = servingTime;
                }
                servingChef.nextFreeTime = servingTime + servingCustomer.prepTime;
                chef.add(servingChef);

            }

        }

        while (!leftCustomers.isEmpty() && chef.peek().nextFreeTime < Math.pow(10, 9)) {
            Customer servingCustomer = leftCustomers.poll();
            Chef servingChef = chef.poll();
            long servingTime = Math.max(servingChef.nextFreeTime, servingCustomer.arrivalTime);
            if(servingTime + servingCustomer.prepTime < Math.pow(10, 9)) {
                ans[servingCustomer.id] = servingTime;
            }
            servingChef.nextFreeTime = servingTime + servingCustomer.prepTime;
            chef.add(servingChef);

        }
        for (int i = 0; i < ans.length; i++) {
            if(ans[i] == -1) {
                System.out.println("Wrong Answer");
                return;
            }
        }

        for (int i = 0; i < ans.length; i++) {

                System.out.print(ans[i] + " ");


        }
        */

    }

    private void printAnswer(final long ans[]) {
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == -1) {
                System.out.println("Wrong Answer");
                return;
            }
        }

        for (int i = 0; i < ans.length; i++) {

            System.out.print(ans[i] + " ");


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
        new ServeAllCustomers().run();
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


