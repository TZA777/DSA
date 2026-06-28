import java.util.*;

public class array2d {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //creating 2d array
        int arr[][] = new int[2][2];

        //inserting data in 2d array 
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Enter a value for matrix");
                arr[i][j] = sc.nextInt();
            }
        }

        //printing a 2d array 
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println("");
        }

    }

    //spiral Matrix
    public static void spiralMatrix(){
        int arr[][]= {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };

        int top=0;
        int bottom= arr.length;
        int left=0;
        int right= arr[0].length;

        //for spiral matrix we need to print top, right, bottom, left
        while(top<=bottom && left<=right){
            //priting top
            for(int i=left; i<right; i++){
                System.out.println(arr[top][i]);
            }
            top++;

            //printing right
            for(int i=top; i<bottom; i++){
                System.out.println(arr[right][i]);
            }
            right--;

            //printing bottom 
            if(top<=bottom){
                for(int i=right; i>=left; i--){
                    System.out.println(arr[bottom][i]);
                }
                bottom--;
            }

            //printing left
            if(left<=right){
                for(int i= bottom; i>=top; i--){
                    System.out.println(arr[left][bottom]);
                }
                left++;
            }
        }
    }

}


//key points

// Why IF Conditions Are Needed in Spiral Matrix
// Traversal
// In spiral matrix traversal, we print elements by shrinking boundaries from all four sides. Certain
// edge cases can cause elements to be printed twice or lead to index errors. To avoid this, we use
// conditional checks.
// Key IF Conditions Used
// 1. if (top <= bottom)
// 2. if (left <= right)
// Case 1: Single Row Matrix
// Matrix: [1 2 3 4]
// After printing the top row, the top boundary moves down. Without checking top <= bottom, the
// same row may be printed again.
// Case 2: Single Column Matrix
// Matrix:
// 1
// 2
// 3
// After printing the right column, the right boundary moves left. Without checking left <= right, the
// column may be printed again.
// Case 3: Odd-Sized Matrix (3×3)
// Matrix:
// 1 2 3i:\Downloads\2D_Array_Interview_Practice_Problems.pdf
// 4 5 6
// 7 8 9
// The middle element (5) should be printed only once. The IF conditions prevent duplicate printing
// when boundaries overlap.
// What the Conditions Mean
// • if (top <= bottom): Checks if there is at least one row left to print.
// • if (left <= right): Checks if there is at least one column left to print.
// • These checks prevent duplicate printing and index-out-of-bound errors.
// Summary:
// The IF conditions are essential safeguards in spiral matrix traversal. They ensure correctness for
// edge cases like single-row, single-column, and odd-dimension matrices.