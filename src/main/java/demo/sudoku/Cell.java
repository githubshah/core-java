package demo.sudoku;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cell {
    private final int row;
    private final int column;

    public int getSize() {
        return size;
    }

    private int size;

    public Map<Integer, Integer> getArr() {
        return arr;
    }

    private final Map<Integer, Integer> arr;

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
            size--;
        }
        return this;
    }

    public Cell(int row, int column, int size) {
        this.row = row;
        this.column = column;
        this.size = size;
        //this.arr = IntStream.range(1, size + 1).boxed().toArray(Integer[]::new);
        this.arr = new HashMap<>();
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
}