/**
 * Retrieved from: http://www.cs.trinity.edu/~bmassing/Classes/CS3366_2015fall/SamplePrograms/Java/csci3366sample/mergesort/MergeSortPar.java
 */
package mergesort;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {

	public static int numThreads;

    /* main method */

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
        String usageMessage = "Arguments: numElements seed";
        System.out.print("Enter seed, array size, and no. threads: ");

        /* get number of threads from environment variable */
        numThreads = 0;
       /* try {
            numThreads = ThreadUtility.getNumThreads();
        }
        catch (ThreadUtility.Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }*/
 
        /* process command-line arguments */
       /* if (args.length < 3) {
            System.err.println(usageMessage);
            System.exit(1);
        }
         */
        int n = 0;
        int seed = 0;
        try {
        	seed = sc.nextInt();
        	n = sc.nextInt();
        	numThreads = sc.nextInt();
            //n = Integer.parseInt(args[0]);
            //seed = Integer.parseInt(args[1]);
            //numThreads = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e) {
            System.err.println("Arguments must be integers");
            System.exit(1);
        }

        /* generate data */
        Integer[] ints = new Integer[n];
        Random randGen = new Random();
        for (int i = 0; i < ints.length; ++i) {
            ints[i] = new Integer(randGen.nextInt(seed));
        }
        
        for(int num: ints)
        	System.out.print(num + ",");
        System.out.println("");

        /* sort (time this part only) */
        long startTime = System.currentTimeMillis();
        ints = sort(ints, numThreads);
        long endTime = System.currentTimeMillis();

        /* print parameters */
        System.out.println("Parallel mergesort of " + n + 
                " random integers (seed " + seed + ")" +
                " with " + numThreads + " threads");

        /* check whether sort succeeded */
        if (isSorted(ints)) {
            System.out.println("Sort succeeded");
        }
        else {
            System.out.println("Sort failed");
        }
        for(int num: ints)
        	System.out.print(num + ",");
        System.out.println("");

        /* print timing result */
        System.out.println("Time " +
                ((double) (endTime - startTime) / 1000) + " seconds");
    }

    /* check whether array is sorted */
    public static boolean isSorted(Integer[] data) {
        for (int i = 0; i < data.length-1; ++i) {
            if (data[i].compareTo(data[i+1]) > 0)
                return false;
        }
        return true;
    }

    /* main mergesort routine */
    public static Integer[] sort(Integer[] data, int numThreads) { 
        Integer[] temp = mergesort(data, 0, data.length-1, numThreads);
        return temp;
    }

    /* 
     * recursive mergesort:
     *   sorts data[firstIndex..lastIndex] using numThreads threads
     *   and returns result (in a new array)
     */
    private static Integer[] mergesort(Integer[] data, 
            int firstIndex, int lastIndex, int numThreads) 
    {
        if (firstIndex > lastIndex) {
            return new Integer[0];
        }
        else if (firstIndex == lastIndex) {
            return new Integer[] { data[firstIndex] };
        }
        int midIndex = (firstIndex + lastIndex) / 2;

        Integer[] temp1 = null;
        Thread otherThread = null;
        CodeForThread other = null;

        /* sort left half of array */
        if (numThreads > 1) {
            /* fork off a thread to do one of the mergesorts */
            other = new CodeForThread(data, firstIndex, midIndex, numThreads/2);;
            otherThread = new Thread(other);
            otherThread.start();
        }
        else {
            /* sort in same thread */
            temp1 = mergesort(data, firstIndex, midIndex, numThreads/2);
        }
        /* sort right half of array */
        Integer[] temp2 = mergesort(data, midIndex+1, lastIndex,
                numThreads-(numThreads/2));

        if (numThreads > 1) {
            /* wait for other thread to finish */
            try {
                otherThread.join();
            }
            catch (InterruptedException e) {
                System.out.println("this should not happen");
            }
            temp1 = other.getResult();
        }
        /* merge two sorted arrays */
        return merge(temp1, temp2);
    }

    /* merge sorted arrays a1, a2, and return result */
    private static Integer[] merge(Integer[] a1, Integer[] a2) {
        Integer[] result = new Integer[a1.length + a2.length];

        int i1 = 0; /* index into a1 */
        int i2 = 0; /* index into a2 */

        for (int j = 0; j < result.length; ++j) {
            if (i2 >= a2.length) {
                result[j] = a1[i1++];
            }
            else if (i1 >= a1.length) {
                result[j] = a2[i2++];
            }
            else if (a1[i1].compareTo(a2[i2]) <= 0) {
                result[j] = a1[i1++];
            }
            else {
                result[j] = a2[i2++];
            }
        }
        return result;
    }

    /* static inner class to contain code to run in thread */

    private static class CodeForThread implements Runnable {

        private Integer[] data;
        private int firstIndex;
        private int lastIndex;
        int numThreads;
        private Integer[] result;

        public CodeForThread(Integer[] d, int first, int last, int nThreads) 
        {
            data = d;
            firstIndex = first;
            lastIndex = last;
            numThreads = nThreads;
        }

        public void run() {
            result = mergesort(data, firstIndex, lastIndex, numThreads);
        }

        public Integer[] getResult() { return result; }
    }

}