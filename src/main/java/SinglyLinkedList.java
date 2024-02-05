public class SinglyLinkedList<T> {
    private static int size;
    private Node head;
    private Node tail;
    // Inner Node class.
    public class Node<T> {
        // Properties of the Node class.
        // The two properties should be:
        // 1. data (the data stored in the node).
        // 2. next (a reference (also known as a pointer) to the next node.


        // Constructor of the Node class.
        // The constructor should set the data property of the Node to be the value passed as a parameter.
        // The constructor should set the next property of the Node to be null.

        private T data;
        private Node next;

        public Node(T d){
            data = d;
            next = null;
        }

        public Node<T> getNext(){
            return next;
        }

        public void setNext(Node<T> n){
            next = n;
        }

    }



    // Properties of the Singly Linked List class.
    // The three properties should be:
    // 1. size (records the number of nodes in our Singly Linked List)
    // 2. head (a reference to the first (also known as the head) node in our Singly Linked List).
    // 3. tail (a reference to the last (also known as the tail) node in our Singly Linked List.


    // Constructor.
    // Creates a Singly Linked List with a head node.
    public SinglyLinkedList(T value) {
        head = new Node<>(value);
        tail = head;
        size = 1;
    }

    // Methods

    // size
    // returns the size of the Singly Linked List.
    public int size() {

        return size;

    }

    // isEmpty
    // returns whether the Singly Linked List is empty.
    public boolean isEmpty() {


        return size <=0;

    }

    // peekFirst
    // returns the data stored in the head node.
    // throws a run time exception if the Singly Linked List is empty.
    public T peekFirst() {
        if(isEmpty()){
            throw new RuntimeException("The single linked list is empty.");
        }

        return (T) head.data;

    }

    // peekLast
    // returns the data stored in the tail node.
    // throws a run time exception if the Singly Linked List is empty.
    public T peekLast() {
        if(isEmpty()){
            throw new RuntimeException("The single linked list is empty.");

        }
        return (T) tail.data;

    }

    // addFirst
    // Adds a node to the front of the Singly Linked List.
    public void addFirst(T value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            head = newNode;
            tail = newNode;}
        else{
            newNode.next = head;
            head = newNode;
        }
        size ++;
    }

    // addLast
    // Adds a node to the back of the Singly Linked List.
    public void addLast(T value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            head = newNode;
            tail = newNode;

        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // insertAt
    // Inserts a node at a specific index.
    // If the index is equal to 0, then we can invoke the addFirst method.
    // If the index is equal to size, then we can invoke the addLast method.
    // throws an illegal argument exception if the index is invalid.
    public void insert(T value, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index.");
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }
        Node newNode = new Node<>(value);
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;

    }

    // removeFirst
    // Removes the first (also known as the head node) from the Singly Linked List.
    // Throws a run time exception if the Singly Linked List is empty.
    // Returns the data stored in the head node.
    // If the size of the Singly Linked List becomes 0, need to set the tail to null.
    public T removeFirst() {
        if(isEmpty()){
            throw new RuntimeException("empty");}
            if(head == null)
                return null;
            head = head.next;
            if(head == null){
                size--;
                return null;
            }

        size--;
        return (T) head.data;
        }



    // removeLast
    // Removes the last (also known as the tail node) from the Singly Linked List.
    // Throws a run time exception if the Singly Linked List is empty.
    // Returns the data stored in the tail node.
    // If the size of the Singly Linked List becomes 0, need to set the tail to null.
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Invalid index.");
        }
        T data = (T) tail.data;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<T> temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
        }
        size--;
        return data;
    }


        // removeAt
    // Removes a node at a specific index.
    // Returns the data stored in the removed node.
    // If the index is equal to 0, then we can invoke the removeFirst method.
    // If the index is equal to size-1, then we can invoke the removeLast method.
    // throws an illegal argument exception if the index is invalid.

    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index.");
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node<T> currentNode = head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.next;
        }

        T data = (T) currentNode.next.data;
        currentNode.next = currentNode.next.next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return data;
    }





    // contains
    // Determines whether the Singly Linked List contains a node that holds data equivalent to the value passed.
    // Returns a boolean.
    public boolean contains(T value) {
        Node<T> temp = head;
        while(temp != null){
            if(temp.data == value){
                return true;
            }
            temp = temp.next;
        }
        return false;

    }

    // valueAt
    // Returns the data held in the node at a specified index.
    // Throws an illegal argument exception if the index is invalid.
    public T valueAt(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Index is invalid");
        }
        Node<T> temp = head;
        for(int i = 0; i< index; i++){
            temp = temp.next;
        }

        return temp.data;

    }

    // reverse
    // Reverses the Singly Linked List.
    public void reverse() {
        if(isEmpty() || size == 1){
            return;
        }
        Node<T> temp = head;
        Node<T> prev = null;
        Node<T> next = null;

        while(temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        tail = head;
        head = prev;

    }

    // toString
    // Returns a String representation of the Singly Linked List.
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<T> temp = head;
        while(temp != null){
            s.append(temp.data);
            if(temp.next != null){
                s.append( " -> ");
            }
            temp = temp.next;
        }
        s.append(" -> null");
        return s.toString();

    }

}

