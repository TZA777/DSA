
public class problems {

    //Node blueprint
    public class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    //addFirst f(x)
    public void addFirst(int data) {
        //create newNode
        Node newNode = new Node(data);
        size++;

        //corner case---linkedList is empty 
        if (head == null) {
            head = tail = newNode;
            return;
        }

        //adressing newNode as head
        newNode.next = head;
        head = newNode;
    }

    //print Linkedlist
    public void printll() {
        Node temp = head;
        if (head == null) {
            System.out.println("ll is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
        System.out.println("Size of LinkedList is " + size);
    }

    //1.iterative Search
    public boolean iterativeSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {

            if (temp.data == key) {
                System.out.println("key found at index " + i);
                return true;
            }
            temp = temp.next;
            i++;
        }
        System.out.println("key not found");
        return false;
    }

    //2.recursive search-------------------------------------------------------------------------------
    public int recursiveSearch(int key) {
        return helper(head, key);

    }

    //helper f(x)
    public int helper(Node head, int key) {
        if (head == null) {
            System.out.println("linked list is empty");
            return -1;
        }
        //bc
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    //3. reverse a linkedList----3 variables and 4 steps
    public void reversell() {
        Node prev = null;
        Node curr = head;
        Node next;

        //updating tail---old head will become new tail
        tail = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //after loop ll is reversed now need to adress head
        head = prev;
    }

    //4.find nth node from end and delete 
    //logic 
    //nth node from end =  (size-n) from starting and 
    //go to prev element of size-n Node and adj Node to prev.next.next
    public void removeNthNode(int idx) {

        //calculate size of linked list 
        int length = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        //handling invalid index
        if (idx > length) {
            System.out.println("Invalid index");
            return;
        }

        //case-1 idx==length---refers to head ---nth-from-end where n = length → is always the head
        if (idx == length) {
            head = head.next;
            if (head == null) {
                tail = null;
            }; //hadling tail when one element is removed----ie empty set
            size--;
            return;
        }

        //case-2 other cases
        int i = 1;  //as zero index--head is covered---we move on from 1 to tail

        int itoFind = length - idx; // to find prev index

        Node prev = head;
        while (i < itoFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;

        //if deleted node was tail
        if (prev.next == null) {
            tail = prev;
        }
        size--; //upate global size
        return;

    }

    //4. check if a given linked list is a palindrome
    //logic---find mid point 10/2=5; 9/2=4.5
    //reverse the second hald of the linkedList
    //compare fist half of linked list with second hald of the linkedlist
    public boolean checkPalindrome() {
        //find mid using fast and slow pointer
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // At this point:
        // slow = middle node
        // fast = null (even length) OR last node (odd length)

        //handling odd palindrome
        // If odd length, move slow one step forward
        if (fast != null) {     // fast != null means odd length
            slow = slow.next;   // skip the middle node----no need for comparision
        }

        //reverse 2nd half starting from slow and store head---for traversing 
        Node secondHalfHead = reverse(slow); //helper f(x)

        //saving reference to restore later
        Node reverseCopy = secondHalfHead;

        //CHECK 1st half with 2nd half
        Node firstHalf = head;
        boolean isPalin = true;

        while (secondHalfHead != null) {
            if (firstHalf.data != secondHalfHead.data) {
                isPalin = false;
                break;
            }

            firstHalf = firstHalf.next;
            secondHalfHead = secondHalfHead.next;
        }

      
        return isPalin;
    }

    //helper f(x)---to reverse
    public Node reverse(Node head) {
        //3 variables and 4 steps
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        return prev; //ie is new head of reversed list
    }
    public Node head;
    public Node tail;
    int size;

    public static void main(String[] args) {
        //creating a linkedlist as reference of class
        problems ll = new problems();

        //adding data to linkedList using reference
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        //ll.iterativeSearch(5);
        //------------------------------------------------------------------------------------
        //int index = ll.recursiveSearch(3);
        // System.out.println("Index of recursive search of key  is at index " + index);
        //------------------------------------------------------------------------------------
        //ll.printll();
        //ll.reversell();
        //ll.printll();
        //-----------------------------------------------------------------------------------
        // ll.removeNthNode(5);
        // ll.printll();
        //------------------------------------------------------------------------------------
        boolean checkResult = ll.checkPalindrome();
        System.out.println(checkResult);
    }
}

//itrative search
//recersive search
//reverse a linkedList
//find and remove nth Node from end
//check if a linkedList is palindrome
