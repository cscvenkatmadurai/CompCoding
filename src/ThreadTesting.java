import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTesting {
    public static void main(String[] args) {

        final Runnable test = new Test();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final long startTime = System.currentTimeMillis();
        executorService.submit(test);
        executorService.submit(test);
        executorService.submit(test);
        System.out.println(System.currentTimeMillis() - startTime);





    }

    static class Test implements Runnable  {

        Object object = new Object();

        @Override
        public void run(){
            synchronized (object) {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getId() + " " + System.currentTimeMillis());
        }
    }
}




