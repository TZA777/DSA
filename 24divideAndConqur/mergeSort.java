//Important-- things in the concept ----pointers i,j on sorted left and sorted right

public class mergeSort {

    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 5, 9, 7};
        mergeSort(arr, 0, arr.length - 1);  //calling mergeSort f(x)

        //printing Sorted array 
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    //mergeSort f(x)
    static void mergeSort(int arr[], int si, int ei) {

        //basecase
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        mergeSort(arr, si, mid); //for sorting left part
        mergeSort(arr, mid + 1, ei); //for sorting right part

        merge(arr, si, mid, ei);  //for merging left and right part----HEART OF MERGESORT
    }

    //merge f(x)
    static void merge(int arr[], int si, int mid, int ei) {
        int i = si;
        int j = mid + 1; //i  and j are startign pointers of sorted LEFT and sorted RIGHT----VERY IMP
        int temp[] = new int[ei - si + 1];  //temperary arr to sort----sorted left and sorted right
        int k = 0;  //This is the position that traverse across the temp arr every time

        while (i <= mid && j <= ei) { //check if POINTERS are with in the boundary
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i]; //updating temp arr with smallest value
                i++; //updating pointer
            } else {
                temp[k] = arr[j]; // same
                j++; //updating pointer
            }
            k++; //updating kth position
        }

        //one the poiters i /j is out the boundary---Handling remaing elements in left and right sorted  arrays
        //handling right =>i>mid--out of bound
        while (j <= ei) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        //handling left =>j>ei--out of bound 
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        //updating arr with temp--for a given arr s(i + idx of temp) should update arr
        for (int idx = 0; idx < temp.length; idx++) {
            arr[si + idx] = temp[idx];
        }

    }

}
