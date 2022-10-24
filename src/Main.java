import algorithms.medium.MaximumLengthOfAConcatenatedStringWithUniqueCharacters;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting test...");
        long startTime = System.currentTimeMillis();

        MaximumLengthOfAConcatenatedStringWithUniqueCharacters mObj = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters();
        System.out.println(mObj.maxLength(List.of("cha","r","act","ers")));

        long endTime = System.currentTimeMillis();
        System.out.println("Finished! Execution time: " + (endTime - startTime) + " ms");

    }
}

