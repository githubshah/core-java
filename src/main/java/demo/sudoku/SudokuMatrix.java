package demo.sudoku;

import java.util.HashMap;
import java.util.Map;

class SudokuMatrix {
    int[][] mat;

    Map<String, Cell> cellHashMap = new HashMap<>();

    public SudokuMatrix(int[][] mat) {
        this.mat = mat;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cellHashMap.put(i + ":" + j, new Cell(i, j, mat[0].length));
            }
        }
    }

    public Map<String, Cell> getCellHashMap() {
        return cellHashMap;
    }
}