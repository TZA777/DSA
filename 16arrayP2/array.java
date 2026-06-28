
public class array {

    public static void main(String[] args) {
        //Max-subarray
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int arrX[] = {-2,-1,5,1,16,-10};

        //brute-force
        //bruteForce(arr);
        //-------------------------------------------------------------------------
        //Prefix-sum method
        //prefixSum(arr);
        //-------------------------------------------------------------------------
        //kadane's method
        kadane(arrX);
    }

    //brute force method
    public static void bruteForce(int arr[]) {

        int maxVal = Integer.MIN_VALUE;
        int si;
        int ei;

        for (int i = 0; i < arr.length; i++) {
            si = i;
            for (int j = i; j < arr.length; j++) {
                ei = j;
                int sum = 0;
                for (int k = si; k <= ei; k++) {
                    //System.out.print(arr[k] + " ");
                    sum += arr[k];
                }
                //System.out.println(sum);

                //update maxVal
                if (sum > maxVal) {
                    maxVal = sum;
                }
            }
        }
        System.out.println(maxVal);
    }

    //----------------------------------------------------------------------------------------
    //prefix-sum method
    public static void prefixSum(int arr[]) {

        //creating a temp array
        int prefixArr[] = new int[arr.length];
        //maxValue
        int maxVal = Integer.MIN_VALUE;

        //storing index sum in prefixArr
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                prefixArr[i] = arr[i];
            } else {
                prefixArr[i] = prefixArr[i - 1] + arr[i];
            };
        }

        //running outer loop and inner loop
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                int cs;
                //System.out.print(si);  //check        
                cs = (i == 0) ? prefixArr[j] : prefixArr[j] - prefixArr[i - 1];
                //System.out.println(cs);

                //updating maxValue
                if (cs > maxVal) {
                    maxVal = cs;
                }
            }
            //System.out.println("end of loop"); 
        }
        System.out.println(maxVal);
    }
    //------------------------------------------------------------------------------------------------------------
    //kadane's method
    public static void kadane(int arr[]){

        int sum = 0;

        for(int i=0;i<arr.length; i++){
            sum += arr[i];
            if(sum<0){
                sum=0;
            }
        }
        System.out.println(sum);
    }
}
