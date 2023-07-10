package algorithm;

public class double_linkedList {

    Node head;
    Node tail;
    int size = 0;

    //############# inserting part ##################
    // 1-inserting first
    public void insertFirst(int data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = tail = node;
            this.size++;
            return;
        }
        node.next = head;
        head.prev = node;
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
        if (head.next == null) {
            insertLast(data);
            return;
        }
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
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
        node.next = tail.next;
        node.prev = tail;
        tail.next = node;
        tail = node;
        this.size++;
    }

    // 4- insert to the node before the tail
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
        node.next = tail;
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        this.size++;
    }

    // 5- insaert after node 
    public void insertAfterNode(int dataBefore, int newData) {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        Node curNode = head;
        while (curNode.next != null && curNode.data != dataBefore) {
            curNode = curNode.next;
        }
        if (curNode.next == null && curNode.data != dataBefore) {
            System.out.println("the node is not found !");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = curNode.next;
        newNode.prev = curNode;
        if (curNode.next != null) {
            curNode.next.prev = newNode;
        }
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
        newNode.prev = curNode;

        if (curNode.next != null) {
            curNode.next.prev = newNode;
        }
        curNode.next = newNode;

        this.size++;

    }

    //############# traversing part ##################
    // 7- search
    public void search(int data) {
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
    // 9 -delete first
    public void DeleteFirst() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        if (head.next == null) {
            head = tail = null;
            this.size--;
            return;
        }
        head = head.next;
        head.prev = null;
        this.size--;
    }

    // 10-delete the element after the head
    public void DeleteFirstNext() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        if (head.next == null) {
            head = tail = null;
            this.size--;
            return;
        }
        if (head.next.next == null) {
            DeleteLast();
            return;
        }
        head.next.next.prev = head;
        head.next = head.next.next;

        this.size--;
    }

    // 11- delete all the element after the head
    public void DeleteALlFirstNext() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        tail=head;
        head.next = null;
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
        tail.prev.next = null;
        tail = tail.prev;
        this.size--;
    }

    // 13- delete the node before the tail
    public void DeleteLastPrevious() {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        if (head.next == null) {
            head = tail = null;
            this.size--;
            return;
        }
        if (head.next.next == null) {
            DeleteFirst();
            return;
        }
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;

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
        Node curNode = head;
        while (curNode.next != null && curNode.data != data) {
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
        if (curNode.data == head.data) {
            DeleteFirst();
            return;
        }

        curNode.prev.next = curNode.next;
        curNode.next.prev = curNode.prev;

        curNode.next = null;
        curNode.prev = null;

        this.size--;

    }

    // 16- delete after node
    public void deleteAfterNode(int dataBefore) {

        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }

        Node curNode = head;
        while (curNode.next != null && curNode.data != dataBefore) {
            curNode = curNode.next;
        }
        if (curNode.next == null && curNode.data != dataBefore) {
            System.out.println("the node is not found !");
            return;
        }
        if (curNode.next == null) {
            System.out.println("there is no node after this one");
            return;
        }
        if (curNode.next.next == null) {
            this.DeleteLast();
            return;
        }

        Node deletedNode = curNode.next;

        deletedNode.prev.next = deletedNode.next;
        deletedNode.next.prev = deletedNode.prev;

        deletedNode.next = deletedNode.prev = null;

        this.size--;

    }

    // 17 - delete all the element after a node
    public void deleteAllNodeNext(int data) {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        int temp = 1;
        Node curNode = head;
        while (curNode.next != null && curNode.data != data) {
            curNode = curNode.next;
            temp++;
        }
        if (curNode.next == null && curNode.data != data) {
            System.out.println("The node is not found");
            return;
        }
        curNode.next = null;
        tail=curNode;
        this.size = temp;
    }

    //18- delete a node's previous
    public void DeleteNodePrevious(int dataAfter) {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        Node curNode = head;
        while (curNode.next != null && curNode.data != dataAfter) {
            curNode = curNode.next;
        }
        if (curNode.next == null && curNode.data != dataAfter) {
            System.out.println("The node is not found");
            return;
        }
        if (curNode.data == head.data) {
            System.out.println("there is node before this one!");
            return;
        }
        if (curNode.prev.data == head.data) {
            DeleteFirst();
            return;
        }
        curNode.prev.prev.next = curNode;
        curNode.prev = curNode.prev.prev;
        this.size--;

    }

    // 19- delete all previous nodes for a chosen one 
    public void deleteAllNodePrevious(int data) {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        int temp = 0;
        Node curNode = head;
        while (curNode.next != null && curNode.data != data) {
            curNode = curNode.next;
            temp++;
        }
        if (curNode.next == null && curNode.data != data) {
            System.out.println("The node is not found");
            return;
        }
        if (curNode.data == head.data) {
            System.out.println("There is no node before this one");
            return;
        }
        head = curNode;
        this.size = this.size - temp;

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
            System.out.print(node + "<->");
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
            System.out.print(node + "<->");
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
        if (tail.prev == null) {
            System.out.println("there is no node before the tail");
            return;
        }
        System.out.println("the node before the tail is: " + tail.prev);
    }

    // 27- display all the nodes before the tail
    public void DisplayAllTailPrevious() {
        if (isEmpty()) {
            System.out.println("The list is empty :(");
            return;
        }
        if (tail.prev == null) {
            System.out.println("there is no node before the tail");
            return;
        }
        Node node = tail.prev;
        System.out.print("tail from here->");
        while (node != null) {
            System.out.print("<->" + node);
            node = node.prev;
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
        Node curNode = head;
        while (curNode.next != null && curNode.data != data) {
            curNode = curNode.next;
        }
        if (curNode.next == null && curNode.data != data) {
            System.out.println("The data is not found");
            return;
        }
        if (curNode.prev == null) {
            System.out.println("There is no node before this one");
            return;
        }
        System.out.println(curNode.prev);

    }

    // 31- display all node previous of a chosen node
    public void DisplayAllNodePrevious(int data) {
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
        if (curNode.prev == null) {
            System.out.println("There is no node before this one");
            return;
        }
        while (curNode.prev != null) {
            System.out.println(curNode.prev);
            curNode = curNode.prev;
        }

    }

    // 32 - display a node with his next and previous nodes
    public void DisplayNodeWithPreviuosAndNext(int data) {
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
        if (curNode.prev == null && curNode.next == null) {
            System.out.println(curNode);
            System.out.println("this is the only node in the list");
            return;
        }
        if (curNode.next == null) {
            System.out.println("the node" + curNode);
            System.out.println("the node before" + curNode.prev);
            System.out.println("there is no node after this one");
            return;
        }
        if (curNode.prev == null) {
            System.out.println("the node" + curNode);
            System.out.println("the node after" + curNode.next);
            System.out.println("there is no node before this one");
            return;
        }
        System.out.println("the node" + curNode);
        System.out.println("the node after" + curNode.next);
        System.out.println("the node before" + curNode.prev);

    }

    //############# check part ##################
    // 33 -checking if empty
    public boolean isEmpty() {
        return head == null;
    }
}
