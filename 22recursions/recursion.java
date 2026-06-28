

public class recursion {

    public static void main(String[] args) {

        //1.System.out.println(factorial(5));
        //2.printInc(5);
        //3.printDec(5);
        //4.System.out.println(sumOfN(5));
        //5.System.out.println(fibonacci(3));  //fibonacci index starts at 0,1,2,3,4,5-----so 3 returns---2 (0,1,1,2) 
        //6.int arr[] = {1, 2, 3, 7, 4, 5};
        // System.out.println(isSorted(arr, 0)); //i=0 => we are checking from start
        //7.System.out.println(firstOccurrence(arr, 8, 0));
        //8.System.out.println(lastOccurrence(arr, 5, arr.length-1));
        //9.System.out.println(xPowerN(2, 4));
        //10.System.out.println(optimizedPower(2, 5));
        //11.System.out.println(tilling(5));
        //12.creating an array of length 26 to map and the chatAt(i)
        // boolean map[] = new boolean[26];
        // String str = "programming";
        // String newStr = "";
        // removeDuplicates(str, 0, newStr, map);
        //13.System.out.println(friendsPairing(2));
        //14.Binary string 
        printBinary(5,0 ,"");
       

    }

    //n factorial
    static int factorial(int n) {
        //base case
        if (n == 0) {
            return 1;
        }
        int fnm1 = factorial(n - 1);
        int fn = n * fnm1;
        return fn;
    }

    //Print 1 to n
    static void printInc(int n) {

        //base case
        if (n == 1) {
            System.out.println(n);
            return;
        }
        printInc(n - 1); //inner function
        System.out.println(n); //operation /work   
    }

    //print n to 1
    static void printDec(int n) {
        //base case
        if (n == 1) {
            System.out.println(n);
            return;
        }

        System.out.println(n); //work
        printDec(n - 1); //inner f(x)
    }

    //sum of first n natural numbers
    static int sumOfN(int n) {
        //base case
        if (n == 1) {
            return 1;
        }

        int sum_nm1 = sumOfN(n - 1);
        int sum_n = n + sum_nm1;
        return sum_n;
    }

    // print nth finbonacci 0,1,1,2,3,5,8,13,21-----
    //if we want to print first n fibonacci numbers just run loop and pass f(n)accodingly
    static int fibonacci(int n) {
        //base case
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        //concept n= (n-1)+(n-2)
        int fnm1 = fibonacci(n - 1);
        int fnm2 = fibonacci(n - 2);

        int fn = fnm1 + fnm2;
        return fn;
    }

    // check if array is sorted-ASSCENDING
    //logic--arr[i]<arr[i+1]
    static boolean isSorted(int arr[], int i) {
        //base case
        if (i == arr.length - 1) {
            return true;
        }

        //condition/work
        if (arr[i] > arr[i + 1]) {
            return false;
        }

        //inner f(x)
        return isSorted(arr, i + 1);
    }

    //First Occurrence
    static int firstOccurrence(int arr[], int key, int i) {

        //base case
        if (i == arr.length) {
            return -1;
        }

        //condition-work
        if (arr[i] == key) {
            System.out.println("First occurrence of the key is at index " + i);
            return i;
        }
        return firstOccurrence(arr, key, i + 1);
    }

    //Last Occurrence---we traverse from n-1 to 0
    static int lastOccurrence(int arr[], int key, int i) {

        //base case
        if (i == -1) {
            return -1;
        }

        //condition-work
        if (arr[i] == key) {
            System.out.println("last occurrence of the key is at index " + i);
            return i;
        }
        return lastOccurrence(arr, key, i - 1);
    }

    //print x^n
    static int xPowerN(int x, int n) {

        //base case
        if (n == 0) {
            return 1;
        }
        //wotk + inner f(x)
        return x * xPowerN(x, n - 1);
    }

    //print x^n--optimized----logic 2^11 = 2 * 2^5 + 2^5 
    static int optimizedPower(int x, int n) {
        //base case
        if (n == 0) {
            return 1;
        }

        //work + inner function
        int halfPower = optimizedPower(x, n / 2) * optimizedPower(x, n / 2);
        if (n % 2 != 0) {//dealing odd case
            halfPower = x * halfPower;
        }

        return halfPower;
    }

    //tilling problem ---tile size---2*1-----board size--2*n
    static int tilling(int n) {
        if (n == 0 || n == 1) {
            return 1;
            //if we have one tile 1 tile and one board size = 2*1----no of ways ==1
            //if we have 0 tiles and no board --no of ways is we do nothing ====1 
        }

        //work
        //veritcal ways + horizontal ways
        //vertical ways
        int fnm1 = tilling(n - 1);//---we have n tiles of size 2*1 and board size of 2*n and if we fit 1 tile rest can be fitted vertically in n-1 ways
        //horizontal way
        int fnm2 = tilling(n - 2); //--we have n tiles of size 2*1 and board size of 2*n and we have to fit 2 tiles----then we can fit rest of the tiles in n-2 ways

        return fnm1 + fnm2;
    }

    //remove duplicates in an string---Pre-requisites--String range should be a-z

    //LOGIC:
    //create an boolean array of length 26---for a-z
    //a=0==>c-a=2==>update boolean value of respective index and update newStr
    static void removeDuplicates(String str, int idx, String newStr, boolean map[]) {

        //baseCase
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx); //current character

        //work+ innerCondition
        if (map[currChar - 'a']) { //=>true=>currChar already exist---no need to add to newStr  a-a=0; b-a=1; d-a= 3
            removeDuplicates(str, idx + 1, newStr, map); //move to next idx
        } else {
            //=>false ---unique character
            //set boolean value to true
            //add to newStr and call inner function 

            map[currChar - 'a'] = true;
            removeDuplicates(str, idx + 1, newStr + currChar, map);
        }
    }

    //friends pairing
    //given n friends----each one can remain single or can be paired with a friend,  each friend can be paired only once
    //find out total number of way in which friend can remain single or can be paired up
    //LOGIC
    //If a friend stay single ---then remaining friends handled f(n-1)
    //if a friend pair with a friend--he can pair up in (n-1)ways---then remaining friends handled f(n-2)
    //base case:
    //when there are no friends--do nothing so---f(n)=1
    //when there is one friend--he stays single--f(n)=1
    static int friendsPairing(int n) {
        //base case
        if (n == 0 || n == 1) {
            return 1;
        }

        //case1---1 one friend chose to be  single---REST of friends handled---f(n-1)---totalWays = 1* f(n-1)
        //case2---2 one friend pairs(can pair up (n-1)ways---REST of friendds handled----f(n-2)-----totalWays= (n-1)*f(n-1) 
        //work + innerFunction
        int single = friendsPairing(n - 1);
        int pair = (n-1)*friendsPairing(n - 2);
        return single + pair;
    }

    //print binary strings of size N without consicutive ones
    static void printBinary(int n, int lastDig, String str){
        //base case
        if(n==0){
            System.out.println(str);
            return;
        }

        //work + inner function
        if(lastDig==0){
            printBinary(n-1, 0, str+"0");
            printBinary(n-1, 1, str+"1");
        }else{
            //lastDight=1
            printBinary(n-1, 0, str+"0");
        }
    }
}

//Prerequsits---2 concepts ---ITERATIONS, FUNCTIONS
//Major uses-------in adv data structures-----TREES, GRAPHS, DP
//What is Recursion?
//Recursion is a method of solving a complicated problem----where solution is depends on solutions to smaller instance of same problem
//in Recursion we have 
// BASE CASE----
// SOME WORK---
// Inner function
//n facorial-----f(n)*f(n-1)*f(n-2)--------so on til f(0)---f(0)is base case in this senario
//Print numbers from 1 to n
//Print numbers from n to 1
//Print sum of 1st n natural numbers
//Print nth fibonacci number
//Check if an array is sorted or not 
//Find the first occurence of an element in an array
//Find the last occurence of an element in an array 
//Print x^n--O(n)
//Print x^n optimized--O(logn)
//tilling problem----tile size-2*1----board size2*n
//Remove duplicates in an string
//Friends pairing 
//Binary String-?? --Print all binary strings of size n without consecutive 1's

