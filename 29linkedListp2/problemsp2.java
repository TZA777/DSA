
public class problemsp2 {

    //Node blueprint
    public static class Node {

        Node next;
        int data;

        public Node(int data) {
            this.next = null;
            this.data = data;
        }
    }

    //add first to linkedlist
    public void addFirst(int data){
        //creating newNode
        Node newNode = new Node(data);
        //cornercase
        if(head==null){
            head=tail=newNode;
        }else{
            newNode.next= head;
            head=newNode;
        }
    }
    //print linkedlist
    public void printll() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");

    }

    //1.detecting cycle in linkedList
    public static boolean detectCycle() {

        //2pointer approch
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //2. removing loop in linkedlist
    //s1: using fast and slow pointer find the meeting point where slow == fast
    //s2: once after knowing cycle exist---update slow as head and travers again----now they meet at start of cycle 
    //s3: prev of fast is directed to null---hence loop is breaked
    public static void removeLoop() {
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        //s1: detect cycle
        while (fast != null && fast.next != null) {  
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        //s2: update slow to head and traverse again
        if (isCycle) {
            slow= head;
            Node prev=null;
            while(slow!=fast){
                prev = fast;
                slow= slow.next;
                fast=fast.next;
            }
        //when slow and fast meets ---while loop breaks---that is the point of intersections/ starting point of the loop
        //s3: update prev.next to null and break cycle
            prev.next= null;
        }else{
            System.out.println("Cycle does not exist in linkedlist");
        }
    }

    //mergeSort f(x)
    //find mid point using slow-fast pointer------seperate into left and right linkedlist
    //mergeSort(left) and mergeSort(right)
    // merge f(x)----helper f(x)-----compare left and right linkedlists----and update remaining nodes

    public Node mergeSortLL(Node head){
        //base case
        if(head == null || head.next== null){
            return head;
        }
        //finding mid
        Node mid = getMid(head);

        //right head
        Node rightHead = mid.next;
        //update mid.next to null and close left part
        mid.next=null;

        //appling mergeSortLL on left and right part
        Node newLeft= mergeSortLL(head);
        Node newRight = mergeSortLL(rightHead);

        //using merge f(x)---to sort left and right part
        return merge(newLeft,newRight);
    }
    
    public Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;

        while(fast!=null && fast.next != null){ //why fast.next.next----because it stops at left mid in even cases---helps in maintaining left and right equal halfs
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node leftHead, Node rightHead){
        //comparing left and right part ---and updating the same
        //handling remaining elements in left and right part 
        //returning head

        Node mergedLL = new Node(-1);
        Node temp= mergedLL;

        while(leftHead != null && rightHead != null){
            if(leftHead.data<=rightHead.data){
                temp.next= leftHead;
                leftHead= leftHead.next;
            }else{
                temp.next = rightHead;
                rightHead = rightHead.next;
            }
            //update temp
            temp= temp.next;

        }
            //handling remaining elements--left
            while(leftHead != null ){
                temp.next = leftHead;
                leftHead= leftHead.next;
                temp= temp.next;
            }

            //handling remaining elements--right
            while(rightHead != null){
                temp.next= rightHead;
                rightHead = rightHead.next;
                temp= temp.next;
            }

            return mergedLL.next;
    }
    //---------------------------------------------------------------------------------------------------
    //zizZag of a linked list
    //logic
    //s1: getMid
    //s2: reverse 2nd half
    //s3: zig zig linking 

    public void zigZagLL(Node head){
        //s1:
        Node mid = getMid(head);
    
        //s2: reverse 2nd half
      

        //reversing 3 variables and 4 steps
        Node prev = null;
        Node curr = mid.next;
        Node next;

        mid.next= null; //closing left part

        while(curr!=null){
            next= curr.next;
            curr.next= prev;
            prev=curr;
            curr=next;
        }

        //s3: zig-zag linking 
        //input 1,2,3,4,5,6,7,8,9
        //s1 & s2 
        // 1,2,3,4,5,-------
        // 9,8,7,6
        //linking part 1,9,2,8,3,7,4,6,5

        Node left= head;
        Node right =prev;
        Node nextL;
        Node nextR;

        while(left!=null && right !=null){
            nextL=left.next; //storing for further iteration 
            left.next=right; //linking right
            nextR=right.next;//storing for further iteration 
            right.next= nextL;

            //updating left and right
            left = nextL;
            right = nextR;
        }
    }
    public static Node head;
    public static Node tail;

    public static void main(String[] args) {
        problemsp2 ll = new problemsp2(); //creating a reference---to get access to class Node

        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.printll();
        //-----------------------------------------------------------------------------------------------
        //creating a linked list with cycle in it
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = head.next;

        // //detecting a cycle in linked list 
        // System.out.println(detectCycle()); //true 

        // //removing loop in cycle linked list
        // ll.removeLoop();
        // ll.printll();

        //------------------------------------------------------------------------------------------------
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.printll();

        // //mergeSort f(x)
        // head=ll.mergeSortLL(head); //returned head is stored in head for further traversing
        // ll.printll();
        //----------------------------------------------------------------------------------------------------
        //Zig-Zag linkedlist
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addFirst(5);
        // ll.addFirst(6);
        // ll.addFirst(7);
        // ll.addFirst(8);
        // ll.addFirst(9);   

        // ll.printll();
        // ll.zigZagLL(head);
        // ll.printll();
        //-----------------------------------------------------------------------------------------------
    }
}
//detecting cycle in linkedlist
//removing cycle in linkedlist  

//java collections framework &&  LL in collections framework
//mergeSort in linkedlist
//zig zag in linkedlist 
//double linkedList
//reverse a double linked list
//circular linked list

