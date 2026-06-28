
import java.util.ArrayList;

public class problems {

    public static void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<>();

        heights.add(1);
        heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4);
        heights.add(8);
        heights.add(3);
        heights.add(7);

        //max water stored_brute force
        //maxWaterStoredBruteForce(heights);
        //max water stored_2 pointer approch
        //System.out.println(maxWaterStored_2pointer(heights));
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);

        //pair sum == target_brute force
        //pairSum_target_BruteForce(arr, 5);
        //pair sum == target_2pointer approch
        //pariSum_targer_2papproch(arr, 4);
        ArrayList<Integer> rotatedArr = new ArrayList<>();

        rotatedArr.add(5);
        rotatedArr.add(6);
        rotatedArr.add(7);
        rotatedArr.add(1);
        rotatedArr.add(2);
        rotatedArr.add(3);
        rotatedArr.add(4);
     
        pairSum_target_rotatedArrayList(rotatedArr, 5);

    }

    //max water stored between 2 polls ---BRUTE FORCE
    //logic height*width = area ---traverse a loop i=0 j=i+1 ---find height, width, update max
    static void maxWaterStoredBruteForce(ArrayList<Integer> heights) {

        int maxWaterStored = Integer.MIN_VALUE;

        for (int i = 0; i < heights.size(); i++) {
            for (int j = i + 1; j < heights.size(); j++) {

                Integer ht = Math.min(heights.get(i), heights.get(j));
                int width = j - i;

                int currentWaterStored = ht * width;
                //System.out.println("current water stored" + currentWaterStored);

                maxWaterStored = Math.max(maxWaterStored, currentWaterStored);
            }
        }
        System.out.println(maxWaterStored);
    }
    //------------------------------------------------------------------------------------------------------------------

    //maxWaterStored_2 pointer approch
    //logic---2 pointers one on left and one on right-----widht = rightIdx- leftIdx,  height = min of left and right, update pointer---on the minimum height side move pointer forward R: moving forward may result in max capaity
    static int maxWaterStored_2pointer(ArrayList<Integer> heights) {
        int maxStoredWater = Integer.MIN_VALUE;
        int lp = 0;
        int rp = heights.size() - 1;

        while (lp < rp) {
            Integer ht = Math.min(heights.get(lp), heights.get(rp));
            int width = rp - lp;

            int currentWaterStored = ht * width;

            maxStoredWater = Math.max(maxStoredWater, currentWaterStored);

            //updating pointer--on min height side move forward
            if (heights.get(lp) < heights.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxStoredWater;
    }
    //---------------------------------------------------------------------------------------------------------------------

    //pairSum ==target BRUTE FORCE
    static void pairSum_target_BruteForce(ArrayList<Integer> arr, int target) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (target == arr.get(i) + arr.get(j)) {
                    System.out.println("pairs sum up for target are at index " + i + "and " + j);
                }
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------
    //pairSum ==  target 2pointer
    //Note: it is a sorted ArrayList in ascending order
    static void pariSum_targer_2papproch(ArrayList<Integer> arr, int target) {
        int lp = 0;
        int rp = arr.size() - 1;

        while (lp < rp) {

            if ((arr.get(lp) + arr.get(rp)) == target) {
                System.out.println("pair sumup to target are at indices " + lp + " and " + rp);
            }

            if (arr.get(lp) + arr.get(rp) < target) {//need to increase sum and check
                lp++;
            } else {
                rp--;
            }
        }
    }

    //--------------------------------------------------------------------------------------------------
    //pair sum == target in a rotated ArrayList
    static void pairSum_target_rotatedArrayList(ArrayList<Integer> arr, int target) {

        //finding the breaking point in rotated ArrayList
        int bp = -1;
        for (int i = 0; i < arr.size()-1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                bp = i;
            }
        }

        int lp = bp + 1;
        int rp = bp;
        int n = arr.size();

        while (lp != rp) {

            if (arr.get(lp) + arr.get(rp) == target) {
                System.out.println("pairs sum up to target are at indiecs " + lp + " and " + rp);
            
            }

            if (arr.get(lp) + arr.get(rp) < target) { //left pointer need to be adjusted
                lp = (lp + 1) % n; // very imp
            }else{ //left pointer need to be adjusted n adjusted to 0 using modulus
                rp = (rp - 1 + n) % n;  //very imp---to adjust out of bound in rotated array -1 adjusted to n-1 index using modulus
            }

        }

    }
}

//1.container with max water stored
//for a  given n lines choose 2 lines on x-axis to form a container which stores max water--height=[1,8,6,2,5,4,8,3,7]
//brute-force
//2 pointer
//2.pair sum==target
//find if any pain in sorted arrayList has targer sum
//list = [1,2,3,4,5,6]; target sum =5
