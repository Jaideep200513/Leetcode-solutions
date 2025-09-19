/*
3484. Design Spreadsheet

Approach: 
1. Make a 2D array with rows × 26 (since 26 columns = A–Z).
  Example: grid[rows][26]

2. setCell(cell, value)
  Convert "A1" → row index and column index.
  Store value in that cell.

3. resetCell(cell)
  Same as setCell, but put 0.

4. getValue(formula)
  Formula is always "=X+Y".
  Split it into two parts: X and Y.
  For each part:
      If it’s a number, convert to integer.
      If it’s a cell reference, fetch from grid.
  Return the sum.

5. Helper function → parseCell("B2") → find row and col.
  Column = 'B' - 'A' = 1
  Row = 2 - 1 = 1
*/

import java.util.*;

class Spreadsheet {
    private int[][] grid; // rows x 26 columns

    public Spreadsheet(int rows) {
        grid = new int[rows][26]; // all initialized to 0
    }

    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = value;
    }

    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = 0;
    }

    public int getValue(String formula) {
        // formula format: =X+Y
        String[] parts = formula.substring(1).split("\\+"); 
        return getOperandValue(parts[0]) + getOperandValue(parts[1]);
    }

    private int getOperandValue(String s) {
        if (Character.isLetter(s.charAt(0))) {
            int[] pos = parseCell(s);
            return grid[pos[0]][pos[1]];
        } else {
            return Integer.parseInt(s);
        }
    }

    private int[] parseCell(String cell) {
        char colChar = cell.charAt(0); 
        int col = colChar - 'A'; 
        int row = Integer.parseInt(cell.substring(1)) - 1; 
        return new int[]{row, col};
    }
}
