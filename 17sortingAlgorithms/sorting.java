
public class sorting {

    public static void main(String[] args) {

        int arr[] = {5, 4, 8, 2, 1};
        //calling bubble sort
        //bubbleSort(arr);

       
        //selectionSort(arr);
      
        //insertion(arr);
       
        //insertionWhile(arr);

        countingSort(arr);

    }

    //bubble sort f(x)---in simple compare adjecent element and swap
    public static void bubbleSort(int arr[]) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) { //note: last idx need not be sorted--reason already sorted
            for (int j = 0; j < n - i - 1; j++) { //note limiting condition should be updated according to sorted portion ie n-i-1

                //condition--comparing adjacent elents
                if (arr[j] > arr[j + 1]) {

                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Array sorted");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //selection sort--find the minVal in the array and swap accordingly
    public static void selectionSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int minIdx = i; //assumption arr[i] is sorted

            for (int j = i + 1; j < n; j++) {
                //finding minIdx and updating minIdx
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }

                //swaping value in minIdx with i
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
        }
        System.out.println("sorted array");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //insertion sort
    public static void insertion(int arr[]) {
        //arr= [5,4,3,2,1];

        //outer loop----1 to 4(n-1)
        for (int i = 1; i < arr.length; i++) {
            //inner loop
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    //if swaping is not required => sorted to said index
                    break;
                }

            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void insertionWhile(int arr[]) {
        //insertion sort using while loop---no swaping--here we use shifing --cleaner and better version
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //countion sort--helps with small range
    //s1: find largest values in the array 
    //s2: creat a new array count[] with length largest+1;
    //s3: run for loop on new array and insert count[i] =i; //upating index value
    //s4: run for or while loop on count [] and print in array in assending or desending order

    public static void countingSort(int arr[]) {
        //find largest
        int largest = Integer.MIN_VALUE; //assigning -infinity

        //find largest
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        System.out.println("largest value is " + largest);

        //creating new array of length largest +1
        int count[] = new int [largest+1];
        //frequecy
        for(int i=0; i<arr.length; i++){ //note check boundary
            count[arr[i]]++;
        }

        //printing sorted array 
        for(int i=0;i<count.length; i++){
            while(count[i]>0){
                System.out.println(i);
                count[i]--;
            }
        }
    }
}
