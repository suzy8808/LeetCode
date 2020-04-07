package dollar.kimi.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//138ms
public class LFUCacheWithPriorityQueue {
	Map<Integer, Node> cache;
	Queue<Node> queue;
	int capacity;
	int size;
	int idx = 0;

	public LFUCacheWithPriorityQueue(int capacity) {
		cache = new HashMap<Integer, Node>(capacity);
		if (capacity > 0) {
			queue = new PriorityQueue<Node>(capacity);
		}
		this.capacity = capacity;
	}

	public int get(int key) {
		Node node = cache.get(key);
		if (node == null)
			return -1;
		node.freq++;
		node.idx = idx++;
		queue.remove(node);
		queue.offer(node);
		return node.value;
	}

	public void put(int key, int value) {
		if (capacity == 0)
			return;
		Node node = cache.get(key);
		if (node != null) {
			node.value = value;
			node.freq++;
			node.idx = idx++;
			queue.remove(node);
			queue.offer(node);
		} else {
			if (size == capacity) {
				cache.remove(queue.peek().key);
				queue.poll();
				size--;
			}
			Node newNode = new Node(key, value, idx++);
			cache.put(key, newNode);
			queue.offer(newNode);
			size++;
		}
	}

	class Node implements Comparable<Node> {
		int key;
		int value;
		int freq;// Ê¹ÓÃÆµÂÊ
		int idx;

		public Node() {
		}

		public Node(int key, int value, int idx) {
			this.key = key;
			this.value = value;
			this.idx = idx;
			freq = 1;
		}

		@Override
		public int compareTo(Node node) {
			int diff = freq - node.freq;
			return diff != 0 ? diff : idx - node.idx;
		}

	}
}
