package demo.sudoku;

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
        reminder(x, y, sudokuMatrix, number, new LinkedList());
    }

    public void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudokuMatrix.mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void reminder(int x, int y, SudokuMatrix sudokuMatrix, int number, Queue<Integer> queue) {
        Map<String, Cell> cellHashMap = sudokuMatrix.getCellHashMap();
        for (int i = 0; i < sudokuMatrix.mat[0].length; i++) {
            for (int j = 0; j < sudokuMatrix.mat[0].length; j++) {
                Cell cell = cellHashMap.get(i + ":" + j).removeNumberFromCellHistory(number);
                if (cell.getArr().size() == 1) {
                    Map.Entry<Integer, Integer> integerIntegerEntry = cell.getArr().entrySet().stream().findFirst().get();
                    if (x != i || y != j) {
                        sudokuMatrix.mat[cell.getRow()][cell.getColumn()] = integerIntegerEntry.getValue();
                    }
                    queue.add(integerIntegerEntry.getValue());
                }
            }
        }
        if (!queue.isEmpty()) {
            Integer number1 = queue.poll();
            reminder(0, 0, sudokuMatrix, number1, queue);
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
        cell.getArr().put(number - 1, number);
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
                {1, 4, 0, 7, 2, 0, 5, 9, 0}, //3, 8
                {0, 0, 0, 6, 5, 0, 7, 0, 3},
                {0, 0, 5, 9, 0, 0, 2, 0, 8},
                {0, 0, 2, 3, 0, 7, 4, 0, 1},
                {6, 0, 7, 0, 8, 0, 0, 5, 0},
                {0, 3, 0, 0, 1, 2, 6, 0, 9},
                {8, 2, 0, 0, 3, 5, 0, 6, 0},
                {0, 0, 6, 0, 0, 4, 1, 2, 0},
                {5, 9, 1, 0, 7, 0, 0, 0, 4},

        };

        Sudoku sudoku = new Sudoku(new SudokuMatrix(mat));

        sudoku.start();

        sudoku.print();

    }
}
