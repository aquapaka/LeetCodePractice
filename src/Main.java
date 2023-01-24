import algorithms.easy.AddBinary;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Program!");
        long startTime = System.currentTimeMillis();

        /*
         * - Execution here ----------------------------------
         */
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("1010", "1011"));
        /*
         * ----------------------------------------------------
         */

        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " ms");

    }
}
