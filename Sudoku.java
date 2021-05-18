class Sudoku{
    static int[][] board = {{7, 8, 0, 4,0 ,0, 1, 2, 0},
                            {6, 0, 0, 0, 7, 5, 0, 0, 9},
                            {0, 0, 0, 6, 0, 1, 0, 7, 8},
                            {0, 0, 7, 0, 4, 0, 2, 6, 0},
                            {0, 0, 1, 0, 5, 0, 9, 3, 0},
                            {9, 0, 4, 0, 6, 0, 0, 0, 5},
                            {0, 7, 0, 3, 0, 0, 0, 1, 2},
                            {1, 2, 0, 0, 0, 7, 4, 0, 0},
                            {0, 4, 9, 2, 0, 6, 0, 0, 7}};

    
    public static void solve(int[][] board){
        if (solve(board, 9)) {
            System.out.println("-------------------------------------");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print("|" + " " + board[i][j] + " ");
                }
                System.out.println("|");
                System.out.println("-------------------------------------");
            }
        }

    }
    
    public static boolean solve(int[][] board, int n) {
        int rowIndex = -1;
        int columnIndex = -1;
        int i = 0;
        int j = 0;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    rowIndex = i;
                    columnIndex = j;
                    break;
                }
            }
            if (rowIndex != -1) {
                break;
            }
        }
        if (i == n && j == n) {
            return true;
        } else {
            for (int value = 1; value < 10; value++) {
                if (valid(board, value, rowIndex, columnIndex, n)) {
                    board[rowIndex][columnIndex] = value;
                    if (!solve(board, n)) {
                        board[rowIndex][columnIndex] = 0;
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static boolean valid(int[][] board, int value, int rowIndex, int columnIndex, int n) {
        // row check
        for (int j = 0; j < 9; j++) {
            if (board[rowIndex][j] == value) {
                return false;
            }
        }
        // column check
        for (int i = 0; i < 9; i++) {
            if (board[i][columnIndex] == value) {
                return false;
            }
        }
        // submatrix check
        int baseRowIndex = rowIndex - (rowIndex % 3);
        int baseColumnIndex = columnIndex - (columnIndex % 3);
        for (int i = baseRowIndex; i < baseRowIndex + 3; i++) {
            for (int j = baseColumnIndex; j < baseColumnIndex + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }

            }
        }
        return true;
    }
}        



/*
public static void main(String[] args) {
        int [][] board ={{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
                };
if(solve(board, 9)){
System.out.println("-------------------------------------");
 for (int i = 0; i < 9; i++) {
                               for (int j = 0; j < 9; j++) {
                    System.out.print("|"+" "+board[i][j]+" ");
                }
                System.out.println("|");
 System.out.println("-------------------------------------");
            }
        }
   
    }
public static boolean solve(int [][]board, int n){
        int rowIndex = -1;
        int columnIndex = -1;
        int i = 0;
        int j = 0;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if(board[i][j] == 0){
                    rowIndex = i;
                    columnIndex = j;
                    break;
                }
            }
            if(rowIndex != -1){
                break;
            }
          }
        if(i == n && j == n){
            return  true;
        }
        else {
            for (int value = 1; value < 10; value++) {
                if(valid(board, value, rowIndex, columnIndex, n)){
                    board[rowIndex][columnIndex] = value;
                    if(!solve(board,n)){
                        board[rowIndex][columnIndex] = 0;
                    }
                    else {
                        return true;
                    }
                }
            }
            return false;
        }
    }
      public static boolean valid(int [][] board, int value, int rowIndex, int columnIndex, int n){
        //row check
        for (int j = 0; j < 9; j++) {
            if(board[rowIndex][j] == value){
                return  false;
            }
        }
        //column check
        for (int i = 0; i < 9; i++) {
            if(board[i][columnIndex] == value){
                return  false;
            }
        }
        //submatrix check
        int baseRowIndex = rowIndex - (rowIndex % 3);
        int baseColumnIndex = columnIndex - (columnIndex % 3);
        for (int i = baseRowIndex; i < baseRowIndex + 3; i++) {
            for (int j = baseColumnIndex; j < baseColumnIndex + 3; j++) {
                if(board[i][j] == value){
                    return  false;
                }

            }
        }
        return true;
    }
    */