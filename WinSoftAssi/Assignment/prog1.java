/* Q1: Merge two arrays by satisfying given constraints
Given two sorted arrays X[] and Y[] of size m and n each where m >= n and X[] has exactly n vacant cells,
 merge elements of Y[] in their correct position in array X[], i.e., merge (X, Y) by keeping the sorted order.   */


import java.util.Arrays;
import java.util.Scanner;

class MergeArr {
    void mergeArrays(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;

        // Move all non-zero elements of X to the end
        int k = m - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (X[i] != 0) {
                X[k--] = X[i];
            }
        }

        // Merge X and Y
        int i = k + 1, j = 0;
        k = 0;
        while (i < m && j < n) {
            if (X[i] < Y[j]) {
                X[k++] = X[i++];
            } else {
                X[k++] = Y[j++];
            }
        }

        // Fill remaining elements of X with Y
        while (j < n) {
            X[k++] = Y[j++];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of array X:");
        int sizeX = scanner.nextInt();
        int[] X = new int[sizeX];
        System.out.println("Enter the elements of array X (sorted):");
        for (int i = 0; i < sizeX; i++) {
            X[i] = scanner.nextInt();
        }

        System.out.println("Enter the size of array Y (less than or equal to size of array X):");
        int sizeY = scanner.nextInt();
        int[] Y = new int[sizeY];
        System.out.println("Enter the elements of array Y (sorted):");
        for (int i = 0; i < sizeY; i++) {
            Y[i] = scanner.nextInt();
        }

        MergeArr obj = new MergeArr();
        obj.mergeArrays(X, Y);
        System.out.println("Merged Array: " + Arrays.toString(X));

        scanner.close();
    }
}
