
public class problems1 {

    //1.Queque using array
    static class ArrayQueque {

        static int arr[];
        static int size;
        static int rear;

        ArrayQueque(int n) {
            arr = new int[n];
            size = n;
            rear = -1;

        }

        //isEmpty()
        public static boolean isEmpty() {
            return rear == -1;
        }

        //add()---in Queque we add at rear
        public static void add(int data) {
            //check if array is full
            if (rear == size - 1) {
                System.out.println("array is full");
                return;
            }
            //update rear and insert data
            rear = rear + 1;
            arr[rear] = data;
        }

        //remove()---in Queque we remove from front
        public static int remove() {
            //check if array empty
            if (isEmpty()) {
                System.out.println("Array is empty");
                return -1;
            }

            int front = arr[0];

            //updating front of array
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }

            rear--; //note: now array will be 0 to n-2---so rear should be decreased by 1 and address the last element

            return front;
        }

        //peek()--we peek at front ie= arr[0]
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Array is empty");
                return -1;
            }
            return arr[0];
        }
    }
    //---------------------------------------------------------------------------------------------

    //2.Circular Queque in array
    static class CircularQueque {

        static int arr[];
        static int size;
        static int rear;
        static int front;

        CircularQueque(int n) {
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        //isEmpty()
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        //isFull()
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        //add()--in Queque we add at rear
        public static void add(int data) {

            //check if circular array  is full
            if (isFull()) {
                System.out.println("CircularQueQue is full");
                return;
            }
            //adj front for first element and add element at rear
            if (front == -1) {
                front = 0;
            };

            //adding element at rear
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        //remove()---in Queque we remove from front 
        public static int remove() {
            if (isEmpty()) {
                System.out.println("empty Queque");
                return -1;
            }

            int result = arr[front];

            //if last element is being removed (ie, only one element in cicular array )if-case
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }

        //peek()
        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty Queque");
                return -1;
            }
            return arr[front];
        }
    }

    //----------------------------------------------------------------------------------------
    //3.Queque using Linkedlist
    //Linkedlist
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //LinkedlistQueque
    static class LinkedlistQueque {

        static Node head = null;
        static Node tail = null;

        //isEmpty()
        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        //isFull()---not required
        //add()
        public static void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }

            //add at tail and adjust tail
            tail.next = newNode;
            tail = newNode;
        }

        //remove()
        public static int remove() {
            if (isEmpty()) {
                System.out.println("empty queque");
                return -1;
            }

            //remove head and adjust head
            int front = head.data;
            //Single element
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        //peek()
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queque");
                return -1;
            }
            int front= head.data;

            return front;
        }

    }

    public static void main(String[] args) {

        //1.Queues using arrays-Drawbacks---fixed size
        //ArrayQueque q = new ArrayQueque(5);
        //
        //2.Queque using CircularArrays
        //CircularQueque q = new CircularQueque(2);
        //
        //3.Queque using Linkedlist
        LinkedlistQueque q = new LinkedlistQueque();

        q.add(1);
        q.add(2);
        q.add(3);

        //printing queque
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}

//PROBLEMS1.JAVA
//1. Queues using arrays
//2. Circular Queque in Arrays
//
//3. Queques using Linkedlist
//
//PROBLEMS2.JAVA
//4. Queques usging Java Collection Framework
//
//5. Queques using 2 stacks
//6. Stacks using 2 queques
//
//Problems3.java
//7.First non-repeating letters
//8.Interleave 2 halves of a queue
//9.Queue reversal
//
//problems3.java
//10. Double Ended Queue
//11. Deque in JCF
//12. Implementation of stack in dequei:\Downloads\Queue Solutions.pdf i:\Downloads\Queue Questions.pdf
//13. Implementation of queues in deque
