package stackqueuelinkedlist;

public class ReverseLinkedList {
    public static class Node {
        int element;
        Node next;

        public Node(int i) {
            element = i;
        }
    }

    public static Node reverseList(Node start) {
        Node currentNode = start;
        Node prevNode = null;
        while (currentNode != null) {
            // save value of next Node
            Node nextNode = currentNode.next;

            // change link
            currentNode.next = prevNode;

            // List traverse
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        reverseList(n);
    }

}
