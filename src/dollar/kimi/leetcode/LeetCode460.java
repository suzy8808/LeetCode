package dollar.kimi.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LeetCode460 {
	Map<Integer, Node> cache;// 缓存内容
	Map<Integer, LinkedHashSet<Node>> freqMap;// 频次双向链表
	int size;
	int capacity;
	int min;// 当前最小频次

	public LeetCode460(int capacity) {
		cache = new HashMap<>(capacity);
		freqMap = new HashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		Node node = cache.get(key);
		if (node == null)
			return -1;
		freqInc(node);
		return node.value;
	}

	public void put(int key, int value) {
		if (capacity == 0)
			return;
		Node node = cache.get(key);
		if (node != null) {
			node.value = value;
			freqInc(node);
		} else {
			if (size == capacity) {
				Node deadNode = removeNode();
				cache.remove(deadNode.key);
				size--;
			}
			Node newNode = new Node(key, value);
			cache.put(key, newNode);
			addNode(newNode);
			size++;
		}
	}

	void freqInc(Node node) {
		int freq = node.freq;
		LinkedHashSet<Node> set = freqMap.get(freq);
		set.remove(node);
		if (freq == min && set.size() == 0) {
			min = freq + 1;
		}
		node.freq++;
		LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
		if (newSet == null) {
			newSet = new LinkedHashSet<Node>();
			freqMap.put(freq + 1, newSet);
		}
		newSet.add(node);
	}

	Node removeNode() {
		LinkedHashSet<Node> set = freqMap.get(min);
		Node deadNode = set.iterator().next();
		set.remove(deadNode);
		return deadNode;
	}

	void addNode(Node node) {
		LinkedHashSet<Node> set = freqMap.get(1);
		if (set == null) {
			set = new LinkedHashSet<Node>();
			freqMap.put(1, set);
		}
		set.add(node);
		min = 1;
	}

	class Node {
		int key;
		int value;
		int freq = 1;// 使用频率

		public Node() {
		}

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}
}
