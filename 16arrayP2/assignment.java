
public class assignment {

    public static void main(String[] args) {

        System.out.println("java practice");

        //1. find repeated elements in array 
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
        //repeatedVal(arr);   

        //2. array rotated at an unknow pivot
        //logic--when we cut down the arry by mid point, one part is sorted
        //rotatedArray(arr);

        //3. max profit on i th day 
        int prices[] = {7, 1, 5, 3, 6, 4};
        //maxProfit(prices);
        //optimized 
        // maxProfitN(prices);

        //4.max rain water tapped between bars
        int bars[] = {4, 2, 0, 6, 2, 5};  //leftMax= [4,4,4,4,4,5] rightMax= [5,5,5,5,5,5]
        //maxWaterTrapped(bars);

        //2pointer for max rain water trapped
        //maxRainWaterTrapped2(bars);

        //5.sum of 2 numbers using 2 pointer (for 2 pointer concept---ideal is linear search ---O(n))
        int arr1[] = {1, 2, 3, 4, 5};
        //sum(arr1);
    }

    //1.function to find repeated values
    public static void repeatedVal(int arr1[]) {

        boolean isRepted = false;
        for (int i = 0; i < arr1.length - 1; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] == arr1[j]) {
                    isRepted = true;
                }
            }
        }
        if (isRepted) {
            System.out.println("The arr has repeated values");
        } else {
            System.out.println("There are no repeated values in the array");
        }
    }

    //2.rotated array 
    public static void rotatedArray(int arr[]) {
        int startIdx = 0;
        int endIdx = arr.length - 1;

        int midIdx = startIdx + (endIdx - startIdx) / 2;

        while (startIdx < endIdx) {
            midIdx = startIdx + (endIdx - startIdx) / 2;

            if (arr[startIdx] == arr[midIdx]) {
                System.out.println("Rotated index is " + startIdx);

            }
            if (arr[startIdx] > arr[midIdx]) {
                //unsorted
                endIdx = midIdx - 1;
            } else {
                startIdx = midIdx + 1;
            }
        }
    }

    //3.maxProfit----brute force O(n^2)
    public static void maxProfit(int arr[]) {
        //conditions
        //1.we should fist buy and then sell
        //2.to make profit buy should be less than sell

        int maxProfit = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j] && (arr[j] - arr[i]) > maxProfit) {
                    maxProfit = arr[j] - arr[i];
                }
            }
        }
        System.out.println("Max profit is " + maxProfit);
    }

    //maxProfit---single loop -TC O(n)
    //logic we dont buy and sell on same day 
    //pass a variable buying price with +infinity 
    //compare buying price ---if bought ok ---else update max profit
    public static void maxProfitN(int arr[]) {

        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < buyPrice) {
                //update buy
                buyPrice = arr[i];
            } else {
                //profit
                int profit = arr[i] - buyPrice;
                //compare maxProfit
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        System.out.println(maxProfit);
    }

    //4. max rain water trapped 
    //logic--if we can find out left max and right max of a given bar and min of both would be maximum water that can be stored at a given position 
    //for given position there is already a bar of surtain height--- so from maximum stored water capacity  we seperate this height
    public static void maxWaterTrapped(int arr[]) {
        int n = arr.length;
        //left max
        int leftMax[] = new int[n];
        for (int i = 0; i < n; i++) {
            //i=0 corner case--leftMax[i]= arr[i]
            if (i == 0) {
                leftMax[i] = arr[i];
            } else {
                leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
            }
        }

        //right max
        int rightMax[] = new int[n];
        for (int j = n - 1; j >= 0; j--) {
            if (j == n - 1) {
                rightMax[j] = arr[j];
            } else {
                rightMax[j] = Math.max(arr[j], rightMax[j + 1]);
            }
        }

        //trapped water
        int trappedwater = 0;
        for (int i = 0; i < arr.length; i++) {
            int waterlevel = Math.min(leftMax[i], rightMax[i]);
            trappedwater += waterlevel - arr[i];
        }
        System.out.println(trappedwater);
    }

    //max rain water trapped----2 pointer approch---- for better space complexity

    public static void maxRainWaterTrapped2(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        int trappedWater = 0;

        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (arr[left] <= arr[right]) {  //finding out min of left and right bar
                //checking legtMax with height of bar and updating trapped water
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                    left++;
                } else {
                    trappedWater += leftMax - arr[left];
                    left++;
                }
            } else { //=> right side bar is min
                if (arr[right] > rightMax) {
                    //updte rightMax
                    rightMax = arr[right];
                    right--;
                } else {
                    //update trapped water
                    trappedWater += rightMax - arr[right];
                    right--;
                }

            }
        }
        System.out.println(trappedWater);
    }

    //sum of array using 2 pointer
    public static void sum(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int sum = 0;

        while (start <= end) {
            if (start == end) {
                sum += arr[start]; //to handle odd case
            } else {
                sum += arr[start] + arr[end];
            }

            start++;
            end--;

        }
        System.out.println(sum);
    }

}

//1. 
// Given an integer array nums, return true if any value appears at least twice in the 
//   array, and return false if every element is distinct. 
// Input: nums = [1, 2, 3, 1]
//2.
// Question 2:  There is an integer array nums sorted in ascending order (with distinct values). Prior to being passed to your function, nums is possibly rotated at an unknown 
// pivot  index k (1  <=  k  <  nums.length)  such  that  the  resulting  array  is [nums[k], 
// nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
// example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and 
// become [4,5,6,7,0,1,2]. Given the array nums after the possible rotation and an integer target, return the 
// index of target if it is in nums, or -1 if it is not in nums. You must write an algorithm with O(log n) runtime complexity.
//3.
// Question 3:  You  are  given  an  array prices where prices[i] is  the  price  of  a  given  stock  on  
//   the ith day. Return the maximum profit you can achieve from this transaction. If you cannot 
// achieve any profit, return 0.   Example 1: Input: prices = [7, 1, 5, 3, 6, 4]
// 4.Given n non-negative integers representing an elevation map where the width of 
//   each bar is 1, compute how much water it can trap after raining [4, 2, 0, 3, 2, 5]
//5. sum of array using 2 pointer

