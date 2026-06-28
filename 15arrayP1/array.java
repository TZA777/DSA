import java.util.*;

public class array{


    public static void main(String[] args) {
        
        int arr[]= {1,2,3,4,5};

        // //printing an array
        // for(int i= 0; i<arr.length; i++){
        //     System.out.println(arr[i]);
        // }

        //calling linear search f(x)
        //linearSearch(arr,3);   

        //calling find largest f(x)
        //findLargest(arr);

        //calling binary-search f(x)
        //binarySearch(arr,30);

        //reverse of an array f(x)
        //reversedArray(arr);

        //pairs in array
        //pairs(arr);

        //subarray
        subArrays(arr);
    }

        //linerSearch f(x)
        public static int linearSearch(int numArr[],int key){
        for (int i=0; i<numArr.length; i++){
            if(numArr[i]==key){
                System.out.println("Index of the 3 is "+ i);
                return i;
            }
        }
        return -1;
    }

        //find largest f(x)
        public static int findLargest(int numArr[]){
            int maxValue = Integer.MIN_VALUE;

            for(int i=0; i<numArr.length; i++){
                if (numArr[i]>maxValue){
                    maxValue = numArr[i];  
                }
            }
            System.out.println(maxValue);
            return maxValue;
        }


        //binay search ----pre-requisite---array must sorted 
        public static int binarySearch(int arr[], int key){
            int start= 0;
            int end = arr.length-1;

            while(start<=end){
                int mid = start+(end-start)/2;
                if(arr[mid] == key){
                    System.out.println("Found key, Index of the key is"+ mid);
                    return mid;
                }else if(arr[mid]<key){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
                
            }   
            System.out.println("key not found ");
            return -1; 
        }

        //reverse of an array 
        public static void reversedArray(int arr[]){
            int temp;
            int start = 0;
            int end= arr.length-1;
            for(int i=0; i<=(arr.length-1)/2; i++){
                //swapping technique
                temp = arr[start];
                arr[start]= arr[end];
                arr[end]= temp;

                start++;
                end--;
            }
            //printing reverse array
            for(int i= 0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
           }

        }

        //pairs in an array
        //note--adding limits---in i and j are very important
        public static void pairs(int arr[]){
            int count =0;
            for(int i= 0; i<arr.length; i++){
                for(int j=i+1; j<arr.length; j++){
                    System.out.println(arr[i]+""+arr[j]);
                    count++;
                }
            }
            System.out.println("total pairs are " +count);                
        }


        //print subarry
        public static void subArrays(int arr[]){
            int start;
            int end;
            for(int i =0; i<=arr.length-1; i++){
                start=i;
                for(int j=i; j<=arr.length-1; j++){
                    end=j;
                    for(int k = start; k<=end; k++){
                        System.out.print(arr[k]+" ");   
                    }
                    System.out.println("");
                } 
            }
        }
}