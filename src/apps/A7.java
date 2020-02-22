package apps;
import structure.Node;
import apps.A3;
import java.util.*;
import java.io.*;
public class A7 {
    public static Node[][] crossover(Node[][] matrix1, Node[][] matrix2) {
        int n = matrix1.length;
        int m = matrix1[0].length;
        Node[][] matrix = new Node[n][m];
        //k1 = upper m1 lower m2;
        //mk2 = lower m1 upper m2;
        //compare k1 and k2 which step is less;
        //return smallest of m1, m2 and ma;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix1[i][j].val == matrix2[i][j].val) {
                    matrix[i][j] = matrix1[i][j];
                } else {
                    int maxI = Math.max((n - i - 1),(i));
                    int maxJ = Math.max((m - j - 1), (j));
                    int maxNum = Math.max(maxI, maxJ);
                    int newValue = A4.getRandom(1, maxNum);
                    matrix[i][j] = new Node(i, j, newValue, 0, 2,0);
                }
            }
        }
        return matrix;
    }
    public static boolean selection(Node[][] matrix, int k) {
        int n = matrix.length;
        int step = A3.bfs(matrix, n - 1, n - 1);
        if (step <= k) {
            return true;
        }
        return false;
    }





    public static void main(String[] args) {
        List<Node[][]> list = new LinkedList<>();
        Node[][] matrix1 = randomGen.generateMatrix(5);
        System.out.println();
        Node[][] matrix2 = randomGen.generateMatrix(5);
        list.add(matrix1);
        list.add(matrix2);
/*        int k = 10;
        while (k >= 2) {
            for (int i = 0; i < list.size(); i++) {
                if(!selection(list.get(i), k)) {
                    list.remove(list.get(i));
                }
            }

            if (k > 2) {
                k--;
            }
        }
 */
        System.out.println();
        Node[][] output = crossover(matrix1, matrix2);
        for (Node[] ints : output) {
            for (int j = 0; j < output[0].length; j++) {
                System.out.print(ints[j].val + " ");
            }
            System.out.println();
        }
    }
}
