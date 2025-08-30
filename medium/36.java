/*
36. Valid Sudoku

Approach:
1. Use three sets (or hashmaps) to track seen numbers:
    One for each row.
    One for each column.
    One for each 3×3 sub-box.
2. While iterating through the board:
    If the cell contains a number val (not "."):
      Check if val already exists in:
        The current row set.
        The current column set.
        The current sub-box set.
      If yes → return False.
      Otherwise, add it to the respective sets.
3. If no conflicts are found, return True.
*/

import java.util.*;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') continue;

                int boxIdx = (r / 3) * 3 + (c / 3);

                if (rows[r].contains(val) || cols[c].contains(val) || boxes[boxIdx].contains(val)) {
                    return false;
                }

                rows[r].add(val);
                cols[c].add(val);
                boxes[boxIdx].add(val);
            }
        }
        return true;
    }
}
