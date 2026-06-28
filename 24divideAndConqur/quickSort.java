
public class quickSort {

    //quickSorted f(x)
    static void quickSorted(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pivotIdx = partition(arr, si, ei);

        //as pivot idx is already sorted---we take care of left part pivotIdx-1 and right part pivotIdx+1 
        //sort left part
        quickSorted(arr, si, pivotIdx - 1);

        //sort right part
        quickSorted(arr, pivotIdx + 1, ei);

    }

    //partition method
    static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei]; //storing ei value in pivot

        int i = si - 1; //traversing index

        //finding out pivot index---------sorting left side of pivot index ---->right side automatically sorted
        for (int j = si; j < ei; j++) {
            if (arr[j] < pivot) {
                i++;

                //swapping arr[i] and arr[j]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        //place pivot at correct position----sorted till i so position of pivot is i+1----update pivot positon and and return i+1
        int temp = arr[i + 1];
        arr[i + 1] = arr[ei];
        arr[ei] = temp;

        return i + 1;  //pivot index
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 2, 5};

        //calling quickSort f(x)
        quickSorted(arr, 0, arr.length - 1);

        //print sorted array
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}




// Quick Sort is a divide and conquer sorting algorithm.

// It works by:

// Choosing a pivot element

// Placing the pivot in its correct position

// Moving smaller elements to the left

// Moving larger elements to the right

// Recursively sorting left and right parts
