76package algorithm;

public class Single_linkedList {

    Node head;
    Node tail;
    int size = 0;

    // 1-inserting first
    public void insertFirst(int data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = tail = node;
            this.size++;
            return;
        }

        node.next = head;
        head = node;

        this.size++;
    }

    // 2- insert element after the first one 
    public void insertFirstNext(int data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = tail = node;
            this.size++;
            return;
        }
        node.next = head.next;
        head.next = node;
        this.size++;
    }

    // 3- insert last 
    public void insertLast(int data) {
        Node node = new Node(data);
        if (isEmpty()) {
            this.size++;
            head = tail = node;
            return;
        }
        tail.next = node;
        tail = node;
        this.size++;
    }

    //4- insert a node before the tail
    public void insertLastPrevious(int data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = tail = node;
            this.size++;
            return;
        }
        if (head.next == null) {
            insertFirst(data);
            return;
        }
        Node curNode = head;
        while (curNode.next != null && curNode.next.data != tail.data) {
            curNode = curNode.next;
        }
        node.next = curNode.next;
        curNode.next = node;
        this.size++;
    }

    // 5- insaert after node 
    public void insertAfterNode(int dataBefore, int newData) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node curNode = head;
        while (curNode.next != null && curNode.data != dataBefore) {
            curNode = curNode.next;
        }
        if (curNode.data != dataBefore) {
            System.out.println("the node is not found !");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = curNode.next;
        curNode.next = newNode;
        this.size++;

    }
    // 6- insert before the givin node
    public void insertBeforeNode(int dataNext, int newData) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        if (dataNext == head.data) {
            insertFirst(newData);
            return;
        }
        Node curNode = head;
        while (curNode.next != null && curNode.next.data != dataNext) {
            curNode = curNode.next;
        }

        if (curNode.next == null && curNode.data != dataNext) {
            System.out.println("the node is not found !");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = curNode.next;
        curNode.next = newNode;

        this.size++;

    }

    //############# traversing part ##################
    // 7- search
    public void search(int data) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node curNode = head;
        int temp = 0;
        while (curNode != null) {
            if (curNode.data == data) {
                temp++;
                break;
            }
            curNode = curNode.next;
        }
        System.out.println(
                temp > 0 ? "we found the data" : "we couldn't find the data"
        );
    }
    // 8-getting the size 

    public void size() {
        System.out.println("the size of the list is:" + this.size);
    }

    //############# deleting part ################## 
    // 9-delete first
    public void DeleteFirst() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        head = head.next;
        this.size--;
    }

    // 10-delete the element after the head
    public void DeleteFirstNext() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        if (head.next == null) {
            System.out.println("there is no node after this one");
            return;
        }
        head.next = head.next.next;
        this.size--;
    }

    // 11- delete all the element after the head
    public void DeleteALlFirstNext() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        head.next = null;
        tail= head;
        this.size = 1;

    }

    // 12 -delete last
    public void DeleteLast() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        if (head.next == null) {
            head = tail = null;
            this.size--;
            return;
        }
        Node node = head;
        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
        this.size--;
    }

    // 13- delete the node before the tail
    public void DeleteLastPrevious() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        if (head.next == null) {
            System.out.println("there is no node before this one");
            return;
        }
        if (head.next.next == null) {
            DeleteFirst();
            return;
        }
        Node curNode = head;
        while (curNode.next.next.next != null) {
            curNode = curNode.next;
        }
        curNode.next = tail;
        this.size--;
    }

    // 14- delete all the element before the tail
    public void DeleteALlLastPrevious() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        head = tail;
        head.next = null;
        this.size = 1;

    }

    // 15- delete a node 
    public void deleteNode(int data) {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        if (head.data == data) {
            DeleteFirst();
            return;
        }

        Node curNode = head;
        while (curNode.next != null && curNode.next.data != data) {
            curNode = curNode.next;
        }
        if (curNode.next == null && curNode.data != data) {
            System.out.println("the node is not found !");
            return;
        }
        if (curNode.next == null) {
            DeleteLast();
            return;
        }

        curNode.next = curNode.next.next;
        this.size--;

    }

    // 16- delete after node
    public void deleteAfterNode(int dataBefore) {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }

        Node curNode = head;
        while (curNode.next.next != null && curNode.data != dataBefore) {
            curNode = curNode.next;
        }
        if (curNode.data != dataBefore) {
            System.out.println("the node is not found !");
            return;
        }
        curNode.next = curNode.next.next;
        this.size--;

    }

    // 17- delete after node
    public void deleteAllNodeNext(int dataBefore) {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        int temp = 1;
        Node curNode = head;
        while (curNode.next != null && curNode.data != dataBefore) {
            curNode = curNode.next;
            temp++;
        }
        if (curNode.data != dataBefore) {
            System.out.println("the node is not found !");
            return;
        }
        curNode.next = null;
        tail= curNode;
        this.size = temp;

    }

    //18- delete a node's previous
    public void DeleteNodePrevious(int dataBefore) {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        if (head.data == dataBefore) {
            System.out.println("there is no node before this one !");
            return;
        }
        if (head.next == null) {
            System.out.println("the data is not found ;(");
            return;
        }
        if (head.next.data == dataBefore) {
            DeleteFirst();
            return;
        }
        if (head.next.next == null) {
            System.out.println("the data is not found ;(");
            return;
        }

        Node curNode = head;
        while (curNode.next.next != null && curNode.next.next.data != dataBefore) {
            curNode = curNode.next;
        }
        if (curNode.next.next == null && curNode.data != dataBefore) {
            System.out.println("The node is not found");
            return;
        }
        curNode.next = curNode.next.next;
        this.size--;

    }

    //19- delete all the node before a choosen one 
    public void DeleteAllNodePrevious(int dataBefore) {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        int temp = 0;
        if (head.data == dataBefore) {
            System.out.println("there is no node before this one !");
            return;
        }

        Node curNode = head;
        while (curNode.next != null && curNode.data != dataBefore) {
            curNode = curNode.next;
            temp++;
        }
        if (curNode.next == null && curNode.data != dataBefore) {
            System.out.println("The node is not found");
            return;
        }
        head = curNode;
        this.size = size - temp;

    }

    //20- delete all
    public void deleteAll() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        head = tail = null;
        this.size = 0;

    }

    //############# printing part ##################
    // 21- print the list
    public void DisplayList() {
        if (isEmpty()) {
            System.out.println("The list is empty :(");
            return;
        }
        Node node = head;
        while (node != null) {
            System.out.print(node + "->");
            node = node.next;
        }
        System.out.print("Null");
        System.out.println();

    }

    // 22- print the First  element
    public void DisplayFirst() {
        if (isEmpty()) {
            System.out.println("The list is empty :(");
            return;
        }
        System.out.println("The first element is ->" + head);

    }

    // 23 - display the node after the head
    public void DisplayHeadNext() {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        if (head.next == null) {
            System.out.println("there is no node after the head");
            return;
        }
        System.out.println("the node after the head is: " + head.next);

    }

    // 24 - display all the nodes after the head
    public void DisplayAllHeadNext() {
        if (isEmpty()) {
            System.out.println("The list is empty :(");
            return;
        }
        if (head.next == null) {
            System.out.println("there is no node after the head");
            return;
        }
        Node node = head.next;
        while (node != null) {
            System.out.print(node + "->");
            node = node.next;
        }
        System.out.print("Null");
        System.out.println();

    }

    //25- print the last element
    public void DisplayLast() {
        if (isEmpty()) {
            System.out.println("The list is empty :(");
            return;
        }
        System.out.println("The last element is ->" + tail);

    }

    // 26- display the node before the tail 
    public void DisplayTailPrevious() {
        if (isEmpty()) {
            System.out.println("The list is empty :(");
            return;
        }
        if (tail.data == head.data) {
            System.out.println("there is no node before the tail");
            return;
        }
        Node node = head;
        while (node.next.data != tail.data) {
            node = node.next;
        }
        System.out.println("the node before the tail is: " + node);
    }

    // 27- display all the nodes before the tail
    public void DisplayAllTailPrevious() {
        if (isEmpty()) {
            System.out.println("The list is empty :(");
            return;
        }
        if (tail.data == head.data) {
            System.out.println("there is no node before the tail");
            return;
        }
        Node node = head;
        System.out.print("head from here");
        while (node.data != tail.data) {
            System.out.print("->" + node);
            node = node.next;
        }
        System.out.println();

    }

    // 28 - display the node after a chosen node 
    public void DisplayNodeNext(int data) {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        Node curNode = head;
        while (curNode.next != null && curNode.data != data) {
            curNode = curNode.next;
        }
        if (curNode.next == null && curNode.data != data) {
            System.out.println("The data is not found");
            return;
        }
        if (curNode.next == null) {
            System.out.println("There is no node after this one");
            return;
        }
        System.out.println(curNode.next);

    }

    // 29- display all node after a chosen one 
    public void DisplayAllNodeNext(int data) {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        Node curNode = head;
        while (curNode.next != null && curNode.data != data) {
            curNode = curNode.next;
        }
        if (curNode.next == null && curNode.data != data) {
            System.out.println("The data is not found");
            return;
        }
        if (curNode.next == null) {
            System.out.println("There is no node after this one");
            return;
        }
        while (curNode.next != null) {
            System.out.println(curNode.next);
            curNode = curNode.next;
        }
    }

    // 30 - display the previus node of a chosen node
    public void DisplayNodePrevious(int data) {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        if (head.data == data) {
            System.out.println("there is no node before this one");
            return;
        }
        if (head.next == null) {
            System.out.println("the data is not found");
            return;
        }
        if (head.next.data == data) {
            System.out.println("the data before it is: " + head);
            return;
        }
        Node curNode = head;
        while (curNode.next != null && curNode.next.data != data) {
            curNode = curNode.next;
        }
        if (curNode.next == null && curNode.data != data) {
            System.out.println("The data is not found");
            return;
        }

        System.out.println("the data before it is: " + curNode);

    }

    // 31- display all node previous of a chosen node
    public void DisplayAllNodePrevious(int data) {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        if (head.data == data) {
            System.out.println("There is no node before this one");
            return;
        }
        Node curNode = head;
        while (curNode.next != null && curNode.data != data) {
            curNode = curNode.next;
        }
        if (curNode.next == null && curNode.data != data) {
            System.out.println("The data is not found");
        } else {
            Node node = head;
            System.out.print("the head from here");
            while (node.data != curNode.data) {
                System.out.print("->" + node);
                node = node.next;
            }

            System.out.println();
        }
    }
    // 32 - display a node with his next and previous nodes

    public void DisplayNodeWithPreviuosAndNext(int data) {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }

        if (head.data == data) {
            System.out.println("the node" + head);
            System.out.println("the node after" + head.next);
            System.out.println("there is no node before this one");
            return;
        }
        Node curNode = head;
        while (curNode.next != null && curNode.next.data != data) {
            curNode = curNode.next;
        }
        if (curNode.next == null && curNode.data != data) {
            System.out.println("The data is not found");
            return;
        }

        System.out.println("the node" + curNode.next);
        if (curNode.next.next != null) {
            System.out.println("the node after" + curNode.next.next);
        } else {
            System.out.println("there is no node after this one");
        }
        System.out.println("the node before" + curNode);

    }

    //############# check part ##################
    // 33 -checking if empty
    public boolean isEmpty() {
        return head == null;
    }
    
     //############# extra part ##################
    public void reverseList(){
   Node cur = head;
   while (cur!=null){
   Node curOne = cur.next;
   Node prevOne = cur;
   curOne.next = prevOne;
   cur=cur.next;

   }
    }
    
}
