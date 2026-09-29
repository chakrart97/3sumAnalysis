import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.*;
import edu.princeton.cs.algs4.In;


public class ThreeSum {

    // Count triples that sum to 0 (brute force O(n^3))
    public static int count(int[] a) {

        int count = 0;
        int N = a.length;
        HashSet<ArrayList<Integer>> seen = new HashSet<>();
        //TODO: Finish THreeSum
        for (int i = 0; i < N-2; ++i) {
            for (int j = i+1; j < N-1; ++j) {
                for (int k = j+1; k < N-2; ++k) {
                    int ai = a[i], aj = a[j], ak = a[k];
                    if (ai + aj + ak == 0) {
                        ArrayList<Integer> triple = new ArrayList<>();
                        triple.add(ai);
                        triple.add(aj);
                        triple.add(ak);
                        triple.sort(Comparator.naturalOrder());
                        seen.add(triple);
                    }
                }
            }
        }

        count = seen.size();

        return count;
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
