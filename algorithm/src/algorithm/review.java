package algorithm;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class review {

    TreeNode root;

    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        insert(root, data);
    }

    public TreeNode insert(TreeNode node, int data) {
        if (node == null) {
            node = new TreeNode(data);
        } else {
            if (node.data >= data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }

        }
        return node;
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node + " ");
    }

    public void levelOrder() {
        levelOrder(root);
    }

    public void levelOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(node);
        while (q.size() != 0) {
            TreeNode removed = q.remove();
            System.out.print(removed + " ");
            if (removed.left != null) {
                q.add(removed.left);
            }
            if (removed.right != null) {
                q.add(removed.right);
            }

        }
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    public TreeNode delete(TreeNode node, int value) {
        if (node == null) {
            return node;
        }
        // searching for the node in the first two ifs
        if (node.data > value) {
            node.left = delete(node.left, value);
        } else if (node.data < value) {
            node.right = delete(node.right, value);
        } // this for handling the case where the node is found
        else {
            if (node.left == null) {
                /* if the node has no left child and it has right child just replace 
                 and it will work for the no children case because if the right child
                 was null that what the parent node will be*/
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // here is for node with two children
            // replace the node data with thw samllest value
            node.data = minimum(node.right);
            // delete that value
            node.right = delete(node.right, node.data);
        }
        // this will return if the node we are looking for is not found
        return node;

    }

    private int minimum(TreeNode node) {
        if (node.left != null) {
            return minimum(node.left);

        }
        return node.data;

    }
}

/*

    int V;
    LinkedList<Integer> adj[];

    review(int V) {
        adj = new LinkedList[V];
        this.V = V;
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void insert(int v, int n) {
        adj[v].add(n);
    }

    public void BFS(int s) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean visited[] = new boolean[V];
        queue.add(s);
        int i = 0;
        while (queue.size() != 0) {
            int removed = queue.poll();
            visited[i] = true;
            while(removed.next!=null){
            
            }
        }

    }

    TreeNode root;

    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        insert(root, data);
    }

    public TreeNode insert(TreeNode node, int data) {
        if (node == null) {
            node = new TreeNode(data);
        } else {
            if (node.data >= data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }

        }
        return node;
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node + " ");
    }

    public void levelOrder() {
        levelOrder(root);
    }

    public void levelOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(node);
        while (q.size() != 0) {
            TreeNode removed = q.remove();
            System.out.print(removed + " ");
            if (removed.left != null) {
                q.add(removed.left);
            }
            if (removed.right != null) {
                q.add(removed.right);
            }

        }

    }
    Single_linkedList list;

    review() {
        list = new Single_linkedList();
    }

    public void enqueue(int data) {
        list.insertLast(data);
    }

    public void dequeue() {
        list.DeleteFirst();
    }

    public void Top() {
        list.DisplayFirst();
    }

    public void size() {
        list.size();
    }

    public boolean isEmpty() {
        return list.head == null;
    }*/

 /*

    public void push(int data) {
        list.insertFirst(data);
    }

    public void pop() {
        list.DeleteFirst();
    }

    public void peek() {
        list.DisplayFirst();
    }

    public void size() {
        list.size();
    }

    public boolean isEmpty() {
        return list.head == null;

    }*/
 /* public void insertFirst(int data) {
        if (isEmpty()) {
            head = tail = new Node(data);
            return;
        }
        Node node = new Node(data);
        head.prev = node;
        node.next = head;
        head = node;
    }

    public void insertLast(int data) {
        if (isEmpty()) {
            head = tail = new Node(data);
            return;
        }
        Node node = new Node(data);
        node.prev = tail;
        tail.next = node;
        tail = node;

    }

    public void insertAfter(int data, int newData) {
        if (isEmpty()) {
            System.out.println("the list is empty");
            return;
        }
        Node cur = head;
        while (cur.next != null && cur.data != data) {
            cur = cur.next;
        }
        if (cur.data != data) {
            System.out.println("the node is not found!");
            return;
        }
        Node node = new Node(newData);
        cur.next.prev = node;
        node.prev = cur;
        node.next = cur.next;
        cur.next = node;

    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("the list is empty!");
            return;
        }
        head = head.next;
        head.prev = null;

    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("the list is empty!");
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    public void delete(int data) {
        if (isEmpty()) {
            System.out.println("the list is empty!");
            return;
        }
        if (head.data == data) {
            deleteFirst();
            return;
        }
        if (tail.data == data) {
            deleteLast();
            return;
        }
        Node cur = head;
        while (cur.next != null && cur.next.data != data) {
            cur = cur.next;
        }
        if (cur.next == null) {
            System.out.println("the node is not found ! ");
            return;
        }
        cur.next = cur.next.next;
        cur.next.next.prev = cur;

    }

    public void search(int data) {
        if (isEmpty()) {
            System.out.println("the list is empty!");
            return;
        }
        boolean found = false;
        Node cur = head;
        while (cur.next != null) {
            if (cur.data == data) {
                found = true;
                break;
            } else {
                cur = cur.next;
            }
        }
        System.out.println(found == true ? "the node is found" : "the node is not found");

    }

    public void display() {
        if (isEmpty()) {
            System.out.println("the list is emoty !");
            return;
        }
        Node cur = head;
        while (cur != null) {
            System.out.print(cur + "<->");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public boolean isEmpty() {
        return head == null;
    }*/
