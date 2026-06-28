
public class linkedList {

    public class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    int size;

    //addFirst f(x)
    public void addFirst(int data) {
        //creating newNode
        Node newNode = new Node(data);

        //cornercase--ll is empty or head == null
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        //update head
        newNode.next = head;
        head = newNode;
        size++;

    }

    //printing a linkedList
    public void printLL() {
        Node temp = head; //assigning head to head

        //cornerCase
        if (temp == null) {
            System.out.println("Linked list empty");
            System.out.println(size);
            return;
        }

        while (temp != null) {
            System.out.println(temp.data); // printing temp data
            temp = temp.next;//update temp to next Node
        }

        System.out.println("null");
        System.out.println(size);
        System.out.println("done");

    }

    //addLast f(x)
    public void addLast(int data) {
        Node newNode = new Node(data);

        //cornerCase--head==null linkedList is empty
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    //addMiddle f(x)
    public void addMiddle(int data, int idx) {
        Node newNode = new Node(data); //creating newNode
        //baseCase --idx==0---ie, to add at first
        if (idx == 0) {
            addFirst(data);  //size updated in addFirst f(x)
            return;
        }

        Node prev = head; //assing head to prev for traversing
        int i = 0;

        //finding prev value of idx
        while (i < idx - 1) { //as we are need pointer at idx-1 but accessing prev.next at said index we traverse to idx-2 position
            prev = prev.next;
            i++;
        }

        //linking newNode next to prev
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    //remove fist f(x)
    public int removeFirst() {

        //baseCase---case1-when ll is empty case2-when size-1 ie, ll got only one value
        if (size == 0) {
            System.out.println("Linked list is empty");
            return -1;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size--;
            return value;
        }

        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    //remove last f(x)

    public int removeLast(){
        //basecase
        if(size==0){
            System.out.println("linkedList is empty");
            return -1;
        }else if(size==1){
            int value= head.data;
            head=tail=null;
            size=0;
            return value;
        }

        Node prev= head;
        //traverse to get prev value
        for(int i=0; i<size-2; i++){ //why size-2====prev refer next Node---so at size-2 prev refer to size-1 Node
            prev=prev.next;
        }

        int value= prev.next.data;
        prev.next=null;
        size--;
        return value;
    }

    public static void main(String[] args) {

        //creating a LinkedList
        linkedList ll = new linkedList();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);

        ll.addLast(0);

        //ll.printLL();
        //ll.addMiddle(9, 0);
        //ll.printLL();

        //System.out.println(ll.removeFirst());
        ll.printLL();

        System.out.println(ll.removeLast());
        ll.printLL();

    }
}

//create node bluePrint
//addFirst
//addLast
//addMiddle
//removeFirst
//removeLast
//printLinkedList
