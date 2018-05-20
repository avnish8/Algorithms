public class CopyArray {
    static int[][] copyArray(int[][] inputArray) {
        int row = inputArray.length, col = inputArray[0].length;
        int[][] newArray = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                inputArray[i][j] = newArray[i][j];
        }
        return newArray;
    }
}
