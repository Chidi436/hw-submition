import java.io.*;
import java.util.*;

public class MatrixMultiplier {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        if (args.length == 2) {
            int[][] matrix1 = readMatrixFromFile(args[0]);
            int[][] matrix2 = readMatrixFromFile(args[1]);

            int[][] result = multiplyMatrices(matrix1, matrix2);
            writeMatrixToFile(result, "matrix3.txt");

        } else if (args.length == 1 && isInteger(args[0])) {
            int size = Integer.parseInt(args[0]);
            int[][] matrix1 = generateRandomMatrix(size);
            int[][] matrix2 = generateRandomMatrix(size);

            writeMatrixToFile(matrix1, "matrix1.txt");
            writeMatrixToFile(matrix2, "matrix2.txt");

            int[][] result = multiplyMatrices(matrix1, matrix2);
            writeMatrixToFile(result, "matrix3.txt");

        } else {
            System.out.println("Enter two filenames or a single integer: ");
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");

            if (tokens.length == 2) {
                int[][] matrix1 = readMatrixFromFile(tokens[0]);
                int[][] matrix2 = readMatrixFromFile(tokens[1]);

                int[][] result = multiplyMatrices(matrix1, matrix2);
                writeMatrixToFile(result, "matrix3.txt");

            } else if (tokens.length == 1 && isInteger(tokens[0])) {
                int size = Integer.parseInt(tokens[0]);
                int[][] matrix1 = generateRandomMatrix(size);
                int[][] matrix2 = generateRandomMatrix(size);

                writeMatrixToFile(matrix1, "matrix1.txt");
                writeMatrixToFile(matrix2, "matrix2.txt");

                int[][] result = multiplyMatrices(matrix1, matrix2);
                writeMatrixToFile(result, "matrix3.txt");

            } else {
                System.out.println("Invalid input.");
            }
        }

        scanner.close();
    }

    // ---- Helper Methods Below ----

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int[][] readMatrixFromFile(String filename) throws IOException {
        List<int[]> rows = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            String[] tokens = line.trim().split("\\s+");
            int[] row = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
            rows.add(row);
        }

        br.close();
        return rows.toArray(new int[0][]);
    }

    private static void writeMatrixToFile(int[][] matrix, String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (int[] row : matrix) {
            for (int val : row) {
                bw.write(val + " ");
            }
            bw.newLine();
        }
        bw.close();
    }

    private static int[][] generateRandomMatrix(int size) {
        Random rand = new Random();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                matrix[i][j] = rand.nextInt(10); // 0–9
        return matrix;
    }

    private static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;

        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }
}