package tree;

import java.util.ArrayList;
import java.util.Stack;

public class MClosestNode {
    public static class TreeIter {
	Stack<Node> m_stk = new Stack<Node>();

	Node getNext() {
	    if (m_stk.empty())
		return null;

	    Node pCur = m_stk.peek();
	    if (pCur.right != null) {
		return pushLft(pCur.right);
	    }

	    while (!m_stk.isEmpty() && pCur != m_stk.peek().left) {
		pCur = m_stk.pop();
	    }
	    return pCur;
	}

	Node pushLft(Node pNode) {
	    Node pCur = pNode;
	    while (null != pCur) {
		m_stk.push(pCur);
		pCur = pCur.left;
	    }
	    return pCur;
	}

	Node getPrev() {
	    if (m_stk.empty())
		return null;
	    Node pCur = m_stk.peek();
	    if (pCur.left != null) {
		return pushRgt(pCur.left);
	    }

	    while (!m_stk.empty() && pCur != m_stk.peek().right) {
		pCur = m_stk.pop();
	    }
	    return pCur;
	}

	Node pushRgt(Node pNode) {
	    Node pCur = pNode;
	    while (null != pCur) {
		m_stk.push(pCur);
		pCur = pCur.right;
	    }
	    return pCur;
	}

	Node getCur() {
	    if (m_stk.empty())
		return null;

	    return m_stk.peek();
	}

    }

    boolean getMClosest(Node pRoot, int nTg, int m, ArrayList<Node> vec) {
	if (null == pRoot || m <= 0)
	    return false;

	TreeIter iter = new TreeIter();
	Node pCur = pRoot;
	while (pCur != null && pCur.value != nTg) {
	    iter.m_stk.push(pCur);
	    if (nTg > pCur.value)
		pCur = pCur.right;
	    else
		pCur = pCur.left;
	}
	// this method need ntg in the tree
	if (pCur == null)
	    return false;

	iter.m_stk.push(pCur);

	TreeIter itLft = iter;
	itLft.getPrev();
	TreeIter itRgt = iter;
	itRgt.getNext();

	while ((itLft.getCur() != null || itRgt.getCur() != null)
		&& vec.size() != m) {
	    if (itLft.getCur() == null) {
		vec.add(itRgt.getCur());
		itRgt.getNext();
	    } else if (itRgt.getCur() == null) {
		vec.add(itLft.getCur());
		itLft.getPrev();
	    } else {
		if (Math.abs(itLft.getCur().value - nTg) < Math.abs(itRgt
			.getCur().value - nTg)) {
		    vec.add(itLft.getCur());
		    itLft.getPrev();
		} else {
		    vec.add(itRgt.getCur());
		    itRgt.getNext();
		}
	    }
	}

	return vec.size() == m;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	MClosestNode m = new MClosestNode();
	ArrayList<Node> vec = new ArrayList<Node>();

	System.out.println(m.getMClosest(Node.create1(), 15, 2, vec));
	System.out.println(vec);
    }

}
