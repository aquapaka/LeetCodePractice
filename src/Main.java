import algorithms.hard.UniquePathsIII;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Program!");

        UniquePathsIII up3 = new UniquePathsIII();
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        System.out.println(up3.uniquePathsIII(grid));
    }
}

