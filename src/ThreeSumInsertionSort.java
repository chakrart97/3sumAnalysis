import edu.princeton.cs.algs4.In;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ThreeSumInsertionSort {

    public static int count(int[] a) {
        int count = 0;
        //TODO: Finish ThreeSumInsertionSort using insertionsort instead of array sort.
        insertionSort(a);
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; ++j) {
                if (BinarySearch.indexOf(a, -a[i]-a[j]) > j)
                    count++;
            }
        }
        return count;
    }

    public static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) throws IOException {
        In in = new In(args[0]);
        int[] a = in.readAllInts();


        // Time only the count() call
        Stopwatch timer = new Stopwatch();
        int count = count(a);
        double time = timer.elapsedTime();

        System.out.printf("Count = %d  time = %.3f seconds%n", count, time);
    }
}
