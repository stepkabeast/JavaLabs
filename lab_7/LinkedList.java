public class LinkedList<T> {
    Node<T> head; // head of list
    public LinkedList<T> next;
    LinkedList(){
        head = null;
    }

    static class Node<T> {
        T data;
        Node next;

        Node(T d)
        {
            data = d;
            next = null;
        }
    }

    public void insert(T data)
    {
        Node<T> new_node = new Node(data);
        new_node.next = null;
        if (head == null) {
            head = new_node;
        }
        else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
    }
    public void printList()
    {
        Node<LinkedList<Integer>> currNode = (Node<LinkedList<Integer>>) head;
        while (currNode != null) {
            LinkedList<Integer> ll = currNode.data;
            Node<Integer> llHead = ll.head;
            while (llHead != null){
                System.out.print(llHead.data + " ");
                llHead = llHead.next;
            }
            currNode = currNode.next;
            System.out.println();
        }
    }
    public void deleteByKey(int key)
    {
        Node<Integer> currNode = (Node<Integer>) head, prev = null;
        if (currNode != null && currNode.data == key) {
            head = currNode.next;
            System.out.println(key + " found and deleted");
        } else {
            while (currNode != null && currNode.data != key) {
                prev = currNode;
                currNode = currNode.next;
            }
            if (currNode != null) {
                prev.next = currNode.next;
                System.out.println(key + " found and deleted");
            }

            if (currNode == null) {
                System.out.println(key + " not found");
            }
        }
    }
    public void deleteAtPosition(int index)
    {
        Node currNode = head, prev = null;
        if (index == 0 && currNode != null) {
            head = currNode.next;
            System.out.println(index + " position element deleted");
        }
        else {
            int counter = 0;
            while (currNode != null) {
                if (counter == index) {
                    prev.next = currNode.next;
                    System.out.println(
                            index + " position element deleted");
                    break;
                } else {
                    prev = currNode;
                    currNode = currNode.next;
                    counter++;
                }
            }
            if (currNode == null) {
                System.out.println(
                        index + " position element not found");
            }
        }
    }
    public Integer get(int col, int row){
        Node<LinkedList<Integer>> currNode = (Node<LinkedList<Integer>>) head;
        while(col != 0){
            currNode = currNode.next;
            col--;
        }
        LinkedList<Integer> ll = currNode.data;
        Node<Integer> llHead = ll.head;
        while(row != 0){
            llHead = llHead.next;
            row--;
        }
        return llHead.data;
    }

}