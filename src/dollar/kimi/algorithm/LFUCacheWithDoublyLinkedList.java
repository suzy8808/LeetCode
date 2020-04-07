package dollar.kimi.algorithm;

import java.util.HashMap;

//90ms
public class LFUCacheWithDoublyLinkedList {
	HashMap<Integer, Node> cache;
	Node head;
	Node tail;
	int capacity;
	int size;

	public LFUCacheWithDoublyLinkedList(int capacity) {
		cache = new HashMap<Integer, Node>(capacity);
		this.capacity = capacity;
		head = new Node();
		tail = new Node();
		head.post = tail;
		tail.pre = head;
	}

	public int get(int key) {
		Node node = cache.get(key);
		if (node == null)
			return -1;
		node.freq++;
		moveToNewPosition(node);
		return node.value;
	}

	public void put(int key, int value) {
		if (capacity == 0)
			return;
		Node node = cache.get(key);
		if (node != null) {
			node.value = value;
			node.freq++;
			moveToNewPosition(node);
		} else {
			if (size == capacity) {
				cache.remove(head.post.key);
				removeNode(head.post);
				size--;
			}
			Node newNode = new Node(key, value);
			addNode(newNode);
			cache.put(key, newNode);
			size++;
		}
	}

	void moveToNewPosition(Node node) {
		Node nextNode = node.post;
		removeNode(node);
		while (nextNode.freq <= node.freq && nextNode != tail) {
			nextNode = nextNode.post;
		}
		nextNode.pre.post = node;
		node.pre = nextNode.pre;
		node.post = nextNode;
		nextNode.pre = node;
	}

	void addNode(Node node) {
		node.post = head.post;
		node.pre = head;
		head.post.pre = node;
		head.post = node;
		moveToNewPosition(node);
	}

	void removeNode(Node node) {
		node.pre.post = node.post;
		node.post.pre = node.pre;
	}

	class Node {
		int key;
		int value;
		int freq = 1;
		Node pre;
		Node post;

		public Node() {
		}

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
