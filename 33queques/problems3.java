
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class problems3 {

    //first non-repeating letter in stream of charaters
    public static void printNonRepeating(String str) {
        //creating an arry of 26 to calculate frequency
        int freq[] = new int[26];
        //creating an queue to peek fist non-repeating char
        Queue<Character> q = new LinkedList<>();

        //loop on to each character of the string----apply logic
        for (int i = 0; i < str.length(); i++) {

            //Logic
            //1.add element to queue
            //2.check frequency
            //3.if frequency of 1st element is more than 1 => repeating ----> so remove from Queue
            //4. if queue is empty-->no non repeating --> return -1 
            //5. else print q.peek()
            char ch = str.charAt(i);  //currnt char
            q.add(ch);  //add element to queue
            freq[ch - 'a']++;  //simple calculation to get an int value and increase frequency of curr char in freq array

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println("");
    }

    //------------------------------------------------------------------------------
    //Interleave f(x)
    public static void interleave(Queue<Integer> q) {
        //Logic
        //1. create new Queue--firstHalf and remove 1st half elements  of existing q and add to new Queue using for loop
        //2. while firstHalf queue is not empty---
        //3. remove elements from firstHalf and add to last existing q and 
        //4. remove elemetns from existing q and add to existing q----------helps in interleaving 2 halfs 

        //creating new Queue
        Queue<Integer> firstHalf = new LinkedList<>();

        //loop to remove 1st half elements and add to new Queue
        int size = q.size(); //Note: in next for loop, size variable should be passed(R: constant)--->if we pass q.size()---due to remove() method, size constantly change
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        //INTERLEAVE-- the heart
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove()); //remove element from first half and add to existing queue
            q.add(q.remove()); //remove elements from existing queue and add to existing queue----to interleave
        }

    }

    //---------------------------------------------------------------------------------------
    //reverseQueue f(x)
    public static void reverseQueue(Queue<Integer> q) {

        //logic
        //1.create stack and remove elements from queus and push to stack 
        //2. now pop elements from stack and add to queue
        //3. queue is reversed 
        
        //creting Stack
        Stack<Integer> s = new Stack<>();

        //remove elements from queue to stack
        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        //pop elements from stack and add to queue
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {

        //7.First non-repeating letter
        String str = "aabcca";
        //printNonRepeating(str);

        //-----------------------------------------------------------------------------------
        //8.Interleave 2 half of a Queue
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        //calling interleave f(x)
        //interleave(q);
        // //printign queue
        // while(!q.isEmpty()){
        //     System.out.print(q.remove() + " ");
        // }
        // System.out.println(" ");
        //-------------------------------------------------------------------------------
        //calling reverseQueue f(x);
        reverseQueue(q);

        //printign queue
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println(" ");

    }

}

//Problems3.java
//7.First non-repeating letters in a stream of characters----input= [a,a,b,b,c,x,b,c,y]----output---x is 1st non repeating letter
//8.Interleave 2 halves of a queue 1,2,3,4,5,6,7,8,9.10------>1,6,2,7,3,8,4,9,5,10
//9.Queue reversal
//
