package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache {
    /*
     * private final int CACHE_SIZE; private final int initialCapacity = 16;
     * private final float loadFactor = 0.75F;
     * 
     * public LRUCache(int size) { this.CACHE_SIZE = size; }
     * 
     * // LinkedHashMap(int initialCapacity, float loadFactor, boolean
     * accessOrder) // accessOrder - to maintain in order of elements from
     * least-recently accessed // to most-recently. Invoking the put or get
     * method results in an access. public LinkedHashMap<Integer, Integer> cache
     * = new LinkedHashMap<Integer, Integer>(initialCapacity, loadFactor, true)
     * {
     * 
     * private static final long serialVersionUID = 1L;
     * 
     * // The removeEldestEntry(Map.Entry) - is a method from LinkedHashMap,
     * that // should be overridden to impose a policy for removing OLD mappings
     * // automatically when new mappings are added to the map. // Returns true
     * if this map should remove its eldest entry. This method is // invoked by
     * put and putAll after inserting a new entry into the map.
     * 
     * @Override protected boolean removeEldestEntry(Map.Entry<Integer, Integer>
     * eldest) { boolean ifRemove = this.size() > CACHE_SIZE; return ifRemove; }
     * 
     * };
     * 
     * public int get(int key) { return cache.get(key); }
     * 
     * public void set(int key, int value) { cache.put(key, value); }
     */
    public LRUCache(int capacity) {
	mCapacity = capacity;
    }

    public int get(int key) {

	if (!mKeyValueNodeMap.containsKey(key))
	    return -1;

	Node node = mKeyValueNodeMap.get(key);

	// move the node to the end of link list if it's not the end
	Node prevNode = node.prev;
	Node nextNode = node.next;
	if (nextNode != null) {
	    if (prevNode == null) { // the head node
		mHead = nextNode;
	    } else {
		prevNode.next = nextNode;
	    }
	    nextNode.prev = prevNode;

	    node.prev = mTail;
	    node.next = null;
	    mTail.next = node;
	    mTail = node;
	}

	return node.val;
    }

    public void set(int key, int value) {

	if (mKeyValueNodeMap.containsKey(key)) {
	    get(key); // only to move it to the tail
	    mKeyValueNodeMap.get(key).val = value;
	} else {
	    Node node = new Node(key, value);

	    // invalidate the LRU item, meaning remove the head element
	    if (mKeyValueNodeMap.size() >= mCapacity) {
		if (mHead != null) {
		    Node oldHead = mHead;
		    mHead = mHead.next;
		    oldHead.next = null;
		    if (mHead != null) // it could be only one item
			mHead.prev = null;
		    mKeyValueNodeMap.remove(oldHead.key);
		}
	    }

	    // insert the new value
	    if (mHead == null) {
		mHead = node;
		mTail = node;
	    } else {
		mTail.next = node;
		node.prev = mTail;
		mTail = node;
	    }
	    mKeyValueNodeMap.put(key, node);
	}
    }

    private class Node {

	int key;
	int val;
	Node prev = null;
	Node next = null;

	Node(int k, int v) {
	    key = k;
	    val = v;
	}
    }

    HashMap<Integer, Node> mKeyValueNodeMap = new HashMap<Integer, Node>();
    Node mHead = null;
    Node mTail = null;
    int mCapacity = 0;

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
