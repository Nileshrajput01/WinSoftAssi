/* Find maximum sum path involving elements of given arrays
Given two sorted arrays of integers, find a maximum sum path involving elements of both arrays whose sum is maximum. 
We can start from either array, but we can switch between arrays only through its common elements.

For example,

Input: X = { 3, 6, 7, 8, 10, 12, 15, 18, 100 }
Y = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 }  
The maximum sum path is: 1 —> 2 —> 3 —> 6 —> 7 —> 9 —> 10 —> 12 —> 15 —> 16 —> 18 —> 100 
The maximum sum is 199 */



import java.util.Scanner;

class MaxSumPath {
    
    public static int maxSumPath(int[] X, int[] Y) {
        int sumX = 0, sumY = 0, result = 0;
        int i = 0, j = 0;
        int m = X.length, n = Y.length;
        StringBuilder path = new StringBuilder();

        while (i < m && j < n) {
            if (X[i] < Y[j]) {
                sumX += X[i];
                path.append(X[i]).append(" -> ");
                i++;
            } else if (X[i] > Y[j]) {
                sumY += Y[j];
                path.append(Y[j]).append(" -> ");
                j++;
            } else {
                result += Math.max(sumX, sumY) + X[i];
                path.append(X[i]).append(" -> ");
                sumX = 0;
                sumY = 0;
                i++;
                j++;
            }
        }

        while (i < m) {
            sumX += X[i];
            path.append(X[i]).append(" -> ");
            i++;
        }

        while (j < n) {
            sumY += Y[j];
            path.append(Y[j]).append(" -> ");
            j++;
        }

        result += Math.max(sumX, sumY);
        System.out.println("The maximum sum path is: " + path.toString());
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the size of array X:");
        int sizeX = scanner.nextInt();
        int[] X = new int[sizeX];
        System.out.println("Enter the elements of array X:");
        for (int i = 0; i < sizeX; i++) {
            X[i] = scanner.nextInt();
        }
        
        System.out.println("Enter the size of array Y:");
        int sizeY = scanner.nextInt();
        int[] Y = new int[sizeY];
        System.out.println("Enter the elements of array Y:");
        for (int i = 0; i < sizeY; i++) {
            Y[i] = scanner.nextInt();
        }
        
        System.out.println("Maximum sum path: " + maxSumPath(X, Y));
        
        scanner.close();
    }
}
