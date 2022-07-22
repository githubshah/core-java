package demo.sudoku;

import java.util.HashMap;
import java.util.Map;

public class Cell {
    private final int row;
    private final int column;

    public int getSize() {
        return size;
    }

    private final Map<Integer, Integer> arr = new HashMap<>();

    private int size = 0;


    public Map<Integer, Integer> getArr() {
        return arr;
    }

    private boolean isPresent(int number) {
        return arr.containsKey(number - 1);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Cell removeNumberFromCellHistory(int number) {
        if (isPresent(number)) {
            arr.remove(number - 1);
        }
        return this;
    }

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", column=" + column +
                ", size=" + size +
                ", arr=" + arr +
                '}';
    }

    public void put(int i, int number) {
        arr.put(i, number);
        this.size = arr.size();
    }
}