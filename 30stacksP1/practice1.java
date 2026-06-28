

public class practice1 {

// // stack using Arraylist
// // Concept
// // Stack follows LIFO (Last In First Out)
// // In ArrayList, we treat the end of list as the top of stack
// // Because:
// // Adding at end → O(1)
// // Removing from end → O(1)
//     static class Stack {

//         ArrayList<Integer> list = new ArrayList<>();

//         // isEmpty
//         public boolean isEmpty() {
//             return list.size() == 0;
//         }

//         // push
//         public void push(int data) {
//             list.add(data);   // add at end
//         }

//         // pop
//         public int pop() {
//             if (isEmpty()) {
//                 System.out.println("Stack is empty");
//                 return -1;
//             }
//             int top = list.get(list.size() - 1);
//             list.remove(list.size() - 1);
//             return top;
//         }

//         // peek
//         public int peek() {
//             if (isEmpty()) {
//                 System.out.println("Stack is empty");
//                 return -1;
//             }
//             return list.get(list.size() - 1);
//         }
//     }


//----------------------------------------------------------------------------------
//stack using Linkedlist
//concept
//We will:
// Insert at head
// Remove from head
// Because:
// Insert at head → O(1)
// Delete head → O(1)
//Head will represent Top of Stack

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        Node head = null;   // top of stack

        // isEmpty
        public boolean isEmpty() {
            return head == null;
        }

        // push
        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        // pop
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
        }
    }

    



    public static void main(String[] args) {

        //stack using Arraylist
        // Stack s = new Stack();

        // s.push(10);
        // s.push(20);
        // s.push(30);

        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        //----------------------------------------------------------------------------
        //stack using Linkedlist

        Stack s = new Stack();

        s.push(10);
        s.push(20);
        s.push(30);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

}

//practice1
//stack introduction----stack of plates, money, stones etc
//stack using Arraylist
//stack using Linkedlist
//
//practice2
//stack using collections framework
//problems
//push at bottom of stack 
//reverse a string using a stack
//reverse a stack
//
//practice3
//advanced problems
//stock span problem
//next greater element

