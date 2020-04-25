package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        Vector<Integer> vector = new Vector<>();
        new Thread() {
            @Override
            public void run() {
                int i=0;
                while (i<100) {
                    vector.add(i);
                    i++;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        Thread.sleep(100);

        Iterator<Integer> iterator = vector.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            Thread.sleep(10);
        }
    }
}
