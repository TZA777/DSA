
public class assignment {

    public static void main(String[] args) {
        //Problem 1: Print Matrix Row-Wise
        int arr[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}

        };

        // printRowWise(arr);//---------------------------------------------
        //Problem 2: Sum of Each Row
        //rowSum(arr);//----------------------------------------------------
        //Problem 3: Search an Element in 2D Array
        //searchElement(arr,10 );
        //Problem 4: Find Largest Element in Each Column
        //findLargest(arr);
        //Problem 5: Count Even and Odd Numbers in Matrix
        //evenOddCount(arr);
        //Problem 6: Diagonal Sum of Matrix
        //diagnolSum(arr);
        //Problem 7: Row with Maximum Sum
        //maxSum_Row(arr);
        //Problem 8: Transpose of a Matrix
        //transposeArr(arr);
        //Problem 9: Spiral Matrix Traversal
        //spiralMatrix(arr);
        //Problem 10: Search in a Sorted Matrix
        sortedSearch2d(arr, 7);
    }

    //1.
    public static void printRowWise(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //2.
    public static void rowSum(int arr[][]) {

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
                sum += arr[i][j];
            }
            System.out.println("");
            System.out.println("Sum of row " +i+ " is " +sum);
        }
    }

    //3.
    public static void searchElement(int arr[][], int key) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == key) {
                    System.out.println("key " + arr[i][j] + " found at index " + i + " " + j);
                return;
                }
            }
        }
        System.out.println("key not found");
    }

    //4.largest in each COLOUM
    public static void findLargest(int arr[][]) {
        

        //LOOP COLUM-WISE

        for (int i = 0; i < arr[0].length; i++) {
            int largest = Integer.MIN_VALUE; //assigining -INIFINY
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] > largest) { //important
                    largest = arr[j][i];
                }
            }
            System.out.println("largest in each colom is "+ largest);
        }
    }

    //5.
    public static void evenOddCount(int arr[][]) {
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if ((arr[i][j] % 2) == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
        }
        System.out.println("even count is " + evenCount);
        System.out.println("odd count is " + oddCount);
    }

    //6.Diagnol sum in square matrix
    public static void diagnolSum(int arr[][]) {
        int sum = 0;
        if ((arr.length != arr[0].length)) {
            System.out.println("not a sqare matrix");
        } else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    //primary diagnol
                    if (i == j) {
                        sum += arr[i][j];
                    }

                    //secondary diagnol --note: middle index of the matrix should not be repeated(if-else will take care of it)
                    else if(i + j == arr.length-1) {
                        sum += arr[i][j];
                    }
                }
            }
            System.out.println("sum of diagnol in square matrix is " + sum);
        }
    }

    //7.Row with max sum
    public static void maxSum_Row(int arr[][]) {
        int maxSum = Integer.MIN_VALUE;
        int row = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                sum += arr[i][j];
            }
            if (maxSum < sum) {
                maxSum = sum;
                row = i;
            }
        }
        System.out.println("Row with max sum is " + row);
        System.out.println("Sum of row " + row + " is " + maxSum);
    }

    //8.
    public static void transposeArr(int arr[][]) {
        int rows = arr.length;
        int cols = arr[0].length;

        //creating new 2d array[]
        int newArr[][] = new int[cols][rows];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                newArr[j][i] = arr[i][j];
            }
        }

        //printing transpose arrary
        System.out.println("Transpose of given array is");
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[0].length; j++) {
               System.out.print(newArr[i][j]+ " ");
            }
            System.out.println("");
        }
    }

    //9.
    public static void spiralMatrix(int arr[][]){
        int top= 0;
        int bottom= arr.length-1;
        int left=0;
        int right= arr[0].length-1;

        while(top<=bottom && left<=right){

            //for printing top---ie left to right
            for(int i= left; i<=right; i++){
                System.out.print(arr[top][i] + " ");
            }
            top++;

            //for printing right---ie top to bottom
            for(int i=top; i<=bottom; i++){
                System.out.print(arr[i][right] + " ");
            }
            right--;

            //for printing bottom---corner case---out of bound chec---assumption array with single row
            if(top<=bottom){
                for(int i=right; i>=left; i-- ){
                    System.out.print(arr[bottom][i]+ " ");
                }
                bottom--;
            }

            //for printion left---corner case---in a matrix of odd sqare to avoid repetation of middle part left<=right
            if(left<=right){
                for(int i=bottom; i>=top; i--){
                    System.out.print(arr[i][left]+ " ");
                }
                left++;
            }
        }  
    }
    //10.
    // we have a sorted matrix ----row and cols are sorted in assending order

    //logic --array is sorted from left to righ and top to bottom
    //if we start with 0,0 corner and compare the key with 0,0 -----key is greated ----it is not eliminating any direction LLy if we start n,m ie, the endign index
    //so we start with 0,col-1 or ---rows-1,0  R: on comparision we eliminate one direction 
    

    public static void sortedSearch2d(int arr[][], int target){
        //we start with top right corner
        int row=0;
        int col = arr[0].length-1;
        while(row <= arr.length-1  && col>=0){

            if(target ==arr[row][col]){
                System.out.println("key found at index "+ row + " "+ col);
                return;
            }
            if(target >arr[row][col]){
                row++; //move down
            }else if(target<arr[row][col]){
                col--; //move left
            }
        }
        System.out.println("key not found");
    }
}
