package demo.sudoku;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Sudoku {
    private final SudokuMatrix sudokuMatrix;

    public Sudoku(SudokuMatrix sudokuMatrix) {
        this.sudokuMatrix = sudokuMatrix;
    }

    public void fill(int x, int y, int number) {
        sudokuMatrix.mat[x][y] = number;
        Queue<Map<String, Integer>> q = new LinkedList();
        reminder(x + ":" + y, sudokuMatrix, number, q);
    }

    public void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudokuMatrix.mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void reminder(String cell, SudokuMatrix sudokuMatrix, int number, Queue<Map<String, Integer>> queue) {
        String[] split = cell.split(":");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        Map<String, Cell> cellHashMap = sudokuMatrix.getCellHashMap();

        for (int r = 0; r < sudokuMatrix.mat[0].length; r++) {

            Cell cell1 = cellHashMap.get(x + ":" + r).removeNumberFromCellHistory(number);
            Cell cell2 = cellHashMap.get(r + ":" + y).removeNumberFromCellHistory(number);

            if (cell1.getSize() != 0) {
                if (cell1.getArr().containsKey(number - 1)) {
                    System.out.println(cell1.getArr().get(number));
                    cell1.getArr().remove(number - 1);
                }
            }

            if (cell2.getSize() != 0) {
                if (cell2.getArr().containsKey(number - 1)) {
                    System.out.println(cell2.getArr().get(number));
                    cell2.getArr().remove(number - 1);
                }
            }
        }

        int x1 = getIndexBoss(x);
        int y1 = getIndexBoss(y);
        int x2 = x1 + 2;
        int y2 = y1 + 2;

        for (int k = x1; k <= x2; k++) {
            for (int l = y1; l <= y2; l++) {
                Cell cell3 = cellHashMap.get(k + ":" + l).removeNumberFromCellHistory(number);
                if (cell3.getArr().size() == 1) {
                    Map.Entry<Integer, Integer> integerIntegerEntry = cell3.getArr().entrySet().stream().findFirst().get();
                    Integer integer = cell3.getArr().get(integerIntegerEntry.getKey()); // single element present in the cell
                    HashMap<String, Integer> obj = new HashMap<>();
                    obj.put(k + ":" + l, integer);
                    queue.add(obj);
                }
            }
        }

        if (!queue.isEmpty()) {
            Map<String, Integer> poll = queue.poll();
            Map.Entry<String, Integer> stringIntegerEntry = poll.entrySet().stream().findFirst().get();
            String key = stringIntegerEntry.getKey();
            String[] split1 = key.split(":");
            int x21 = Integer.parseInt(split1[0]);
            int y21 = Integer.parseInt(split1[1]);
            sudokuMatrix.mat[x21][y21] = stringIntegerEntry.getValue();
            reminder(stringIntegerEntry.getKey(), sudokuMatrix, stringIntegerEntry.getValue(), queue);
        }
    }

    public void start() {
        for (int i = 0; i < sudokuMatrix.mat[0].length; i++) {
            for (int j = 0; j < sudokuMatrix.mat[0].length; j++) {
                int ctr = 0;
                int scannedNumber = 0;
                for (int numberton = 1; numberton <= sudokuMatrix.mat[0].length; numberton++) {
                    if (isSafe(sudokuMatrix, i, j, numberton)) {
                        ctr++;
                        scannedNumber = numberton;
                    }
                }
                if (ctr == 1) {
                    fill(i, j, scannedNumber);
                }
            }
        }
    }

    private boolean isSafe(SudokuMatrix sudokuMatrix, int i, int j, int number) {

        if (sudokuMatrix.mat[i][j] != 0) {
            return false;
        }

        for (int r = 0; r < sudokuMatrix.mat[0].length; r++) {
            if (sudokuMatrix.mat[r][j] == number || sudokuMatrix.mat[i][r] == number) {
                return false;
            }
        }

        int x1 = getIndexBoss(i);
        int y1 = getIndexBoss(j);
        int x2 = x1 + 2;
        int y2 = y1 + 2;

        for (int k = x1; k <= x2; k++) {
            for (int l = y1; l <= y2; l++) {
                int i1 = sudokuMatrix.mat[k][l];
                if (i1 == number) {
                    return false;
                }
            }
        }

        Cell cell = sudokuMatrix.getCellHashMap().get(i + ":" + j);
        cell.put(number - 1, number);
        return true;
    }

    private int getIndexBoss(int i) {
        if (i < 3) return 0;
        if (i < 6) return 3;
        return 6;
    }
}

public class SudukoDemo {
    public static void main(String[] args) {
//        int[][] mat = {
//                {1, 4, 0, 0, 0, 8, 0, 9, 0},
//                {0, 0, 0, 6, 5, 0, 7, 0, 3},
//                {0, 0, 5, 9, 0, 0, 2, 0, 8},
//                {0, 0, 2, 3, 0, 7, 4, 0, 1},
//                {6, 0, 7, 0, 8, 0, 0, 5, 0},
//                {0, 3, 0, 0, 1, 2, 6, 0, 9},
//                {8, 2, 0, 0, 3, 5, 0, 6, 0},
//                {0, 0, 6, 0, 0, 4, 1, 2, 0},
//                {5, 9, 1, 0, 7, 0, 0, 0, 4},
//
//        };

        int[][] mat = {
                {1, 4, 0, 0, 0, 0, 0, 0, 0}, //3, 8
                {0, 0, 0, 6, 5, 0, 7, 0, 3},
                {0, 0, 5, 9, 0, 0, 2, 0, 8},
                {0, 0, 2, 3, 0, 7, 4, 0, 1},
                {6, 0, 7, 0, 8, 0, 0, 5, 0},
                {0, 3, 0, 0, 1, 2, 6, 0, 9},
                {8, 2, 0, 0, 3, 5, 0, 6, 0},
                {0, 0, 0, 0, 0, 4, 1, 2, 0},
                {5, 9, 1, 0, 7, 0, 0, 0, 4},

        };

        Sudoku sudoku = new Sudoku(new SudokuMatrix(mat));

        sudoku.start();

        sudoku.print();

    }
}
