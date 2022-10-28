import algorithms.easy.RemoveDuplicatesFromSortedArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting test...");

        long startTime = System.currentTimeMillis();

        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(RemoveDuplicatesFromSortedArray.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        long endTime = System.currentTimeMillis();
        System.out.println("Finished! Execution time: " + (endTime - startTime) + " ms");
    }
}

