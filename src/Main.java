import algorithms.hard.MyCalendarIII;
import algorithms.medium.ThreeSumClosest;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Program!");
        long startTime = System.currentTimeMillis();

        /*
            - Execution here ----------------------------------
         */
        MyCalendarIII myCalendarIII = new MyCalendarIII();
        System.out.println(ThreeSumClosest.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        /*
            ----------------------------------------------------
         */

        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms");

    }
}

