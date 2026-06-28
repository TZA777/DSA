
public class practice {

    public static void main(String[] args) {
        //1
        String str = "ABC";
        findPermutations(str, "");

        //----------------------------------------------------------------------------------
        int n = 4;

        //creating board and initializing with empty array
        char board[][] = new char[n][n];

        //initilizing board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }

        //2.solvingQueen f(x)
        //solveQueen(board, 0);
        int n1 = 2;
        int m1 = 2;
        //3
        System.out.println(countWays(0, 0, n1, m1));

        //sudoku sovler f(x);
        char[][] sudokoboard = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

     
        //4
        // solveSudoku(sudokoboard);
        // System.out.println("After solving:");
        // printBoard(sudokoboard);


    }

    //1
    //finding all permutations of a string
    static void findPermutations(String str, String ans) {
        //base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;

        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);  //finding current character

            //string with charactors on left
            String left = str.substring(0, i);

            //string with charactors remaining on right
            String right = str.substring(i + 1);

            //remaining String = left +right //other than charAt(i)----eg: i=1===> curr=str.charAt(i)---b,  left = a  rignt=c, remaining = ac
            String remaining = left + right;

            //recursion
            //findPermutations with remaining String
            findPermutations(remaining, ans + curr);
        }
    }

    
    //2.placing N queens on a N*N board-----------------------------------------------+
    //solving queen f(x)
    static void solveQueen(char board[][], int row) {
        //base case all queens placed
        if (row == board.length) {
            printBoard(board);
            System.out.println();
            return;
        }

        //try placing queen in each column 
        for (int col = 0; col < board.length; col++) {
            //calling isSafe f(x)
            if (isSafe(board, row, col)) {

                //place queen 
                board[row][col] = 'Q';

                //move to next row
                solveQueen(board, row + 1);

                //backtrack
                board[row][col] = '.';

            }
        }
    }

    //isSafe f(x)
    static boolean isSafe(char board[][], int row, int col) {
        //check vertical -same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //check upper-left diagnol
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //check upper-right diagnol
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    //print board f(x)
    static void printBoard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //3.no of way to reach from 0*0 to n-1*m-1----in a grid of n*m
    static int countWays(int i, int j, int n, int m) {
        //reached destination
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        //out of bound
        if (i >= n || j >= m) {
            return 0;
        }

        //moves right+ moves down
        int rightWays = countWays(i, j + 1, n, m); //here we are moving right so col val adjusted
        int downWays = countWays(i + 1, j, n, m); //here we are moving down so row val is adjusted

        return rightWays + downWays;
    }

    //-----------------------------------------------------------------------------------------------
    //4. sudoko solver
    static boolean solveSudoku(char board[][]) {

        //run loop to every cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                //finding empty cell
                if (board[row][col] == '.') {
                    //try digit 1-9
                    for (char digit = '1'; digit <= '9'; digit++) {

                        //check if it is safe to update the digit
                        if (isSafe(board, row, col, digit)) {

                            //update digit
                            board[row][col] = digit;

                            //recurse
                            if (solveSudoku(board)) {
                                return true;
                            }

                            //backtrack
                            board[row][col] = '.';

                        }

                    }
                    //no valid digit found
                    return false;
                }

            }
        }

        //no empty cell left---solved
        return true;
    }

    //isSafe f(x)
    static boolean isSafe(char board[][], int row, int col, char digit) {
        //row check--return false if digit exits in that row 
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) {
                return false;
            }
        }

        //col check--return false if digit exits in the col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        //3*3 sub gird check
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow +3; i++) {
            for (int j = startCol; j < startCol +3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }
}

//1.find all permutations of a given string 'ABC'
//
//2.place N queens on a N*N board such that no 2 queens can attack each other
// Place N queens on an N × N chessboard such that:
// No two queens share the same row
// No two queens share the same column
// No two queens share the same diagonal
//
//3.find number of ways to reach from 0*0 to n-1*m-1 in n*m grid and allowed moved are right and down
// we can solve this problem using recurssion and db(optimistic--later)
//let work out recurssion and backtracking 
//logic
// To reach cell (i, j):
// You must come from (i-1, j) (down move)
// OR from (i, j-1) (right move)
//
//4.Solve a 9×9 Sudoku where empty cells are represented by '.' (or 0).
// Core Idea (Backtracking)
// Find an empty cell
// Try digits 1 → 9
// Check if placing a digit is safe
// Recurse
// If it fails → backtrack
