package algorithms.hard;

/*
You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.



Example 1:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:


Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
 */

/*
    [!] NOTICE: Poorly optimize code
 */

import java.util.Arrays;

public class UniquePathsIII {
    private int count;

    public int uniquePathsIII(int[][] inputGrid) {
        count = 0;

        move(inputGrid);

        return count;
    }

    /*
        Start move
     */
    private void move(int[][] currentGrid) {
        moveUp(currentGrid);
        moveRight(currentGrid);
        moveDown(currentGrid);
        moveLeft(currentGrid);
    }

    private void moveUp(int[][] inputGrid) {
        int[][] currentGrid = Arrays.stream(inputGrid).map(int[]::clone).toArray(int[][]::new);

        int[] pos = findCurrentPos(currentGrid);

        // Check if player will move out of grid
        if (pos[0] - 1 < 0) return;
        // Check if player will move into obstacle
        if (currentGrid[pos[0] - 1][pos[1]] == -1) return;
        // Check if player will move into a travelled square (valued 3)
        if (currentGrid[pos[0] - 1][pos[1]] == 3) return;

        // Check if player will move into ending square
        if(currentGrid[pos[0] - 1][pos[1]] == 2) {
            // Check if all squares are travelled before completing
            if(isWalkedThroughAll(currentGrid)) {
                count++;
            }

            return;
        }

        // Continue to move
        currentGrid[pos[0] - 1][pos[1]] = 1;
        currentGrid[pos[0]][pos[1]] = 3;
        move(currentGrid);
    }

    private void moveRight(int[][] inputGrid) {
        int[][] currentGrid = Arrays.stream(inputGrid).map(int[]::clone).toArray(int[][]::new);

        int[] pos = findCurrentPos(currentGrid);

        // Check if player will move out of grid
        if (pos[1] + 1 >= currentGrid[0].length) return;
        // Check if player will move into obstacle
        if (currentGrid[pos[0]][pos[1] + 1] == -1) return;
        // Check if player will move into a travelled square (valued 3)
        if (currentGrid[pos[0]][pos[1] + 1] == 3) return;

        // Check if player will move into ending square
        if(currentGrid[pos[0]][pos[1] + 1] == 2) {
            // Check if all squares are travelled before completing
            if(isWalkedThroughAll(currentGrid)) {
                count++;
            }

            return;
        }

        // Continue to move
        currentGrid[pos[0]][pos[1] + 1] = 1;
        currentGrid[pos[0]][pos[1]] = 3;
        move(currentGrid);
    }

    private void moveDown(int[][] inputGrid) {
        int[][] currentGrid = Arrays.stream(inputGrid).map(int[]::clone).toArray(int[][]::new);

        int[] pos = findCurrentPos(currentGrid);

        // Check if player will move out of grid
        if (pos[0] + 1 >= inputGrid.length) return;
        // Check if player will move into obstacle
        if (currentGrid[pos[0] + 1][pos[1]] == -1) return;
        // Check if player will move into a travelled square (valued 3)
        if (currentGrid[pos[0] + 1][pos[1]] == 3) return;

        // Check if player will move into ending square
        if(currentGrid[pos[0] + 1][pos[1]] == 2) {
            // Check if all squares are travelled before completing
            if(isWalkedThroughAll(currentGrid)) {
                count++;
            }

            return;
        }

        // Continue to move
        currentGrid[pos[0] + 1][pos[1]] = 1;
        currentGrid[pos[0]][pos[1]] = 3;
        move(currentGrid);
    }

    private void moveLeft(int[][] inputGrid) {
        int[][] currentGrid = Arrays.stream(inputGrid).map(int[]::clone).toArray(int[][]::new);

        int[] pos = findCurrentPos(currentGrid);

        // Check if player will move out of grid
        if (pos[1] - 1 < 0) return;
        // Check if player will move into obstacle
        if (currentGrid[pos[0]][pos[1] - 1] == -1) return;
        // Check if player will move into a travelled square (valued 3)
        if (currentGrid[pos[0]][pos[1] - 1] == 3) return;

        // Check if player will move into ending square
        if(currentGrid[pos[0]][pos[1] - 1] == 2) {
            // Check if all squares are travelled before completing
            if(isWalkedThroughAll(currentGrid)) {
                count++;
            }

            return;
        }

        // Continue to move
        currentGrid[pos[0]][pos[1] - 1] = 1;
        currentGrid[pos[0]][pos[1]] = 3;
        move(currentGrid);
    }

    /*
        Find current position in grid
     */
    private int[] findCurrentPos(int[][] currentGrid) {
        for (int row = 0; row < currentGrid.length; row++) {
            for (int col = 0; col < currentGrid[0].length; col++) {
                if(currentGrid[row][col] == 1) return new int[]{row, col};
            }
        }

        return new int[]{-1, -1};
    }

    /*
        Check if player have go through all area
     */
    private boolean isWalkedThroughAll(int[][] currentGrid) {
        for (int[] row : currentGrid) {
            for (int val : row) {
                if (val == 0) return false;
            }
        }

        return true;
    }
}
