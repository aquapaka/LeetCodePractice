import algorithms.hard.MyCalendarIII;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Program!");
        long startTime = System.currentTimeMillis();

        MyCalendarIII myCalendarIII = new MyCalendarIII();
        System.out.println(myCalendarIII.book(10, 20));
        System.out.println(myCalendarIII.book(50, 60));
        System.out.println(myCalendarIII.book(10, 40));
        System.out.println(myCalendarIII.book(5, 15));
        System.out.println(myCalendarIII.book(5, 10));
        System.out.println(myCalendarIII.book(25, 55));

        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms");

    }
}

