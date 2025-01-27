import java.util.Arrays;

public class NumberOfSpanningTrees {
    static final int MAX = 100;
    static final int MOD = 1000000007;

    // Function to multiply two matrices A and B and store result in C
    void multiply(long[][] A, long[][] B, long[][] C, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                C[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
    }

    // Function to calculate power of a matrix A raised to the power N and store it in result
    void power(long[][] A, int N, long[][] result, int size) {
        // Initialize result matrix as identity matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) result[i][j] = 1;
                else result[i][j] = 0;
            }
        }

        // Exponentiation by squaring
        while (N > 0) {
            if ((N & 1) == 1) {
                long[][] temp = new long[size][size];
                multiply(result, A, temp, size);
                System.arraycopy(temp, 0, result, 0, temp.length);
            }
            long[][] temp = new long[size][size];
            multiply(A, A, temp, size);
            System.arraycopy(temp, 0, A, 0, temp.length);
            N >>= 1;
        }
    }

    // Function to calculate the number of spanning trees using Kirchhoff's theorem
    long numOfSpanningTree(int[][] graph, int V) {
        // Step 1: Construct the Laplacian matrix
        int[][] laplacian = new int[V][V];
        
        // Initialize the Laplacian matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    // Degree of node i
                    laplacian[i][j] = 0;
                    for (int k = 0; k < V; k++) {
                        if (graph[i][k] == 1) {
                            laplacian[i][j]++;
                        }
                    }
                } else {
                    if (graph[i][j] == 1) {
                        laplacian[i][j] = -1;
                    } else {
                        laplacian[i][j] = 0;
                    }
                }
            }
        }

        // Step 2: Remove any row and column (usually the last row and column)
        int size = V - 1;
        long[][] reducedLaplacian = new long[size][size];
        for (int i = 1; i < V; i++) {
            for (int j = 1; j < V; j++) {
                reducedLaplacian[i - 1][j - 1] = laplacian[i][j];
            }
        }

        // Step 3: Calculate the determinant of the reduced Laplacian matrix
        return determinant(reducedLaplacian, size);
    }

    // Function to calculate the determinant of a matrix
    long determinant(long[][] matrix, int size) {
        if (size == 1) {
            return matrix[0][0];
        }

        long det = 0;
        long[][] subMatrix = new long[size - 1][size - 1];
        for (int i = 0; i < size; i++) {
            int subRow = 0;
            for (int j = 1; j < size; j++) {
                int subCol = 0;
                for (int k = 0; k < size; k++) {
                    if (k == i) continue;
                    subMatrix[subRow][subCol] = matrix[j][k];
                    subCol++;
                }
                subRow++;
            }
            long subDet = determinant(subMatrix, size - 1);
            if (i % 2 == 0) {
                det = (det + matrix[0][i] * subDet) % MOD;
            } else {
                det = (det - matrix[0][i] * subDet + MOD) % MOD;
            }
        }

        return det;
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        // Example graph represented as an adjacency matrix
        int[][] graph = { 
            { 0, 1, 1, 1 }, 
            { 1, 0, 1, 1 }, 
            { 1, 1, 0, 1 }, 
            { 1, 1, 1, 0 } 
        };

        NumberOfSpanningTrees obj = new NumberOfSpanningTrees();
        System.out.println(obj.numOfSpanningTree(graph, V)); // Output: Number of spanning trees
    }
}
