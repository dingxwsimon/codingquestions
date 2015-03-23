package tree;

import java.util.HashSet;
import java.util.Stack;

public class DFS {

    // stack
    // important
    public static void DFS(Node root) {
	Stack<Node> s = new Stack<Node>();
	s.push(root);
	HashSet<Node> visited = new HashSet<Node>();
	visited.add(root);
	System.out.println(root.value);
	while (!s.empty()) {
	    Node n = s.peek();
	    if (n.left != null && !visited.contains(n.left)) {
		s.push(n.left);
		visited.add(n.left);
		System.out.println(n.left.value);
	    } else if (n.right != null && !visited.contains(n.right)) {
		visited.add(n.right);
		s.push(n.right);
		System.out.println(n.right.value);
	    } else
		s.pop();
	}
    }

    public static void DFS1(Node root, HashSet<Node> visited) {
	if (root == null)
	    return;
	visited.add(root);
	System.out.println(root.value);

	if (root.left != null && !visited.contains(root.left)) {
	    DFS1(root.left, visited);
	}
	if (root.right != null && !visited.contains(root.right)) {
	    DFS1(root.right, visited);
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	DFS(Node.create());
    }

}
