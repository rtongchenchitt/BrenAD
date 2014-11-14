package heap;

import heap.impl.ArrayMinHeap;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Rapol Tongchenchitt on 14/11/14.
 */
public class ArrayMinHeapTest {

    int ITERATION = 10000000;
    int MAX_INT = Integer.MAX_VALUE;

    @Test
    public void TestMinHeap() {

        ArrayMinHeap<Integer> test = new ArrayMinHeap<Integer>(ITERATION);
        PriorityQueue<Integer> sol = new PriorityQueue<Integer>();

        long testInsert = 0, solInsert = 0;
        for(int i = 0; i < ITERATION; i++){
            int r = new Random().nextInt(MAX_INT);

            long testTime = System.currentTimeMillis();
            test.insert(r);
            testInsert += System.currentTimeMillis() - testTime;

            long solTime = System.currentTimeMillis();
            sol.add(r);
            solInsert += System.currentTimeMillis() - solTime;
        }



        long testDelete = 0, solDelete = 0;
        for(int i = 0; i < ITERATION; i++){

            long testTime = System.currentTimeMillis();
            int t = test.deleteMin();
            testDelete += System.currentTimeMillis() - testTime;

            long solTime = System.currentTimeMillis();
            int s = sol.poll();
            solDelete += System.currentTimeMillis() - solTime;

            assertEquals(t, s);
        }

        System.out.println("Test insert: " + testInsert);
        System.out.println("Test delete: " + testDelete);
        System.out.println("Sol insert:  " + solInsert);
        System.out.println("Sol delete:  " + solDelete);

    }

}
