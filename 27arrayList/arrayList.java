import java.util.ArrayList;
import java.util.Collections;

public class arrayList {

    public static void main(String[]args){

        //creating an arrayList
        //fist import arrayList package
        ArrayList <Integer> list = new ArrayList<>();

        //add values to arrayList and print arrayList 
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //print array list
        //System.out.println(list);

        //arraryList properties
        list.add(22); //to add elementt 22 at last in arraylist
        //System.out.println(list);

        list.add(2,22);// to add element at a specific index and and rest will be adjusted to next indecies
        //System.out.println(list);

        list.set(2,24); //to set an element at index 2 to 24
        //System.out.println(list);

        list.remove(2);// to remove an element at index 2
        //System.out.println(list);

        //System.out.println(list.contains(4));//to check if an element contains in an array---returns boolean value

        //System.out.println(list.size()); // to get size of arrayList


        //Problems
        //1.Print elements in an arrayList

        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //2. Print elements in an array List in reverseOrder
        for(int i= list.size()-1; i>=0; i--){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //3.Find max in the arryList
        //Logic--assign a variable max with with -Infinity value and update max in a loop

        int max = Integer.MIN_VALUE; 
        for(int i= 0; i<list.size(); i++){
            max= Math.max(max, list.get(i));
        }

        //printing max value
        System.out.println(max);

        //4.swap indices of an array list eg:0,2

        int temp= list.get(0); //storing value at index 0
        list.set(0,list.get(2)); //updating index-0 with value at index 2
        list.set(2,temp); //updating index-2 with value stored in temp
        
        System.out.println(list);

        //5.sorting an arrayList using Collections package
        Collections.sort(list); //sorting in assending order
        System.out.println(list);

        //sorting in decending order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        //6.Multidimentional arrayList

        //creating a 2d arrayList
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        //creating 3 random arrayList
        ArrayList <Integer> random1 = new ArrayList<>();
        ArrayList <Integer> random2 = new ArrayList<>();
        ArrayList <Integer> random3 = new ArrayList<>();

        //assigning values to random arrayList
        for(int i=0; i<=5; i++){
            random1.add(i*1);
            random2.add(i*2);
            random3.add(i*3);
        }

        //adding random list to mainList and creating 2d array List
        mainList.add(random1);
        mainList.add(random2);
        mainList.add(random3);


        //printing 2d arrayList
        System.out.println(mainList);

        //printing arrayList using loop 
        for(int i=0; i<mainList.size(); i++){
            ArrayList<Integer> currentList = mainList.get(i); //assigning each ArrayList of mainList into currentList
            for(int j=0; j<currentList.size(); j++){
                System.out.print(currentList.get(j)+ " ");
            }
            System.out.println("");
              
        }
    }
    
}
