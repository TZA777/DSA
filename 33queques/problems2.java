
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class problems2 {

    //Queue using 2 stacks
    public static class Queue2Stacks {

        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        //isEmpty()
        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        //add()----TC-O(n)
        //logic===in queue we add at rear, but in stack we add and remove at top---to solve we make use of 2 stack and move elements from one to another and add element at bottom
        public static void add(int data) {
            //move elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            //add data in s1
            s1.push(data);

            //now move elements from s2 to s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        //remove()--TC= O(1)--we simply remove from top of the stack
        public static int remove() {
            if (s1.isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }

            return s1.pop();
        }

        //peek()--TC= O(1)---we simply peek top element of the stack
        public static int peek() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return s1.peek();
        }

    }

    //Stacks using 2 Queues
    public static class Stack2Queues {

        //creating 2 queues using linkedlist
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        //isEmpty();
        public boolean isEmpty() {
            return q1.isEmpty();
        }

        //push(costly)---TC=O(n)
        public static void push(int data) {
            //step-1 : add new element to q2
            q2.add(data);

            //step-2: move all elements from q1 to q2
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            //step3: swap q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        //pop()
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return q1.remove();
        }

        // peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return q1.peek();
        }

    }

    public static void main(String[] args) {

        //4.1creating Queque data structure using JCF--ArrayDeque
        //Queue<Integer> q = new ArrayDeque<>();
        //
        //4.2createing Queque data structure using JCF---Linkedlist
        //Queue<Integer> q = new LinkedList<>();
        //
        //5.Queue using 2 stacks
        Queue2Stacks q = new Queue2Stacks();
  

        q.add(1);
        q.add(2);
        q.add(3);

        //printing queque
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
        //-------------------------------------------------------------------
        //stack using 2 queues
        Stack2Queues s = new Stack2Queues();

        s.push(1);
        s.push(2);
        s.push(3);

        //printing stack
        while(!s.isEmpty()){
            System.out.println("top"+ s.peek());
            System.out.println("popedd"+s.pop());
        }

    }

}

//PROBLEMS2.JAVA
//4. Queques usging Java Collection Framework
//
//5. Queques using 2 stacks
//6. Stacks using 2 queues
//
