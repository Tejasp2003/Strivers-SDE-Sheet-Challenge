import java.util.ArrayList;

public class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int topRow = 0;     // Index of the top row
        int bottomRow = n - 1;     // Index of the bottom row
        int leftCol = 0;     // Index of the left column
        int rightCol = m - 1;     // Index of the right column

        while (leftCol < rightCol && topRow < bottomRow) {
            int previous = mat.get(topRow + 1).get(leftCol); // Store the element below the current element

            // Shift elements in the top row to the left
            for (int i = leftCol; i <= rightCol; i++) {
                int current = mat.get(topRow).get(i);
                mat.get(topRow).set(i, previous);
                previous = current;
            }
            topRow++; // Move to the next row

            // Shift elements in the rightmost column upwards
            for (int i = topRow; i <= bottomRow; i++) {
                int current = mat.get(i).get(rightCol);
                mat.get(i).set(rightCol, previous);
                previous = current;
            }
            rightCol--; // Move to the previous column

            // Shift elements in the bottom row to the right
            for (int i = rightCol; i >= leftCol; i--) {
                int current = mat.get(bottomRow).get(i);
                mat.get(bottomRow).set(i, previous);
                previous = current;
            }
            bottomRow--; // Move to the previous row

            // Shift elements in the leftmost column downwards
            for (int i = bottomRow; i >= topRow; i--) {
                int current = mat.get(i).get(leftCol);
                mat.get(i).set(leftCol, previous);
                previous = current;
            }
            leftCol++; // Move to the next column
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1 = new ArrayList<Integer>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        mat.add(row1);
        ArrayList<Integer> row2 = new ArrayList<Integer>();
        row2.add(4);
        row2.add(5);
        row2.add(6);
        mat.add(row2);
        ArrayList<Integer> row3 = new ArrayList<Integer>();
        row3.add(7);
        row3.add(8);
        row3.add(9);
        mat.add(row3);
        rotateMatrix(mat, 3, 3);
        System.out.println(mat);
    }
}
