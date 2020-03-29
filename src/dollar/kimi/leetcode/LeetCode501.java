package dollar.kimi.leetcode;

import java.util.ArrayList;
import java.util.List;

import dollar.kimi.algorithm.TreeNode;

//�������
public class LeetCode501 {
	int maxNum = 0;// ĳ���ڵ��ֵ������������
	int thisNum = 1;// ĳ���ڵ���γ����ǵڼ��γ��֡�
	List<Integer> list = new ArrayList<Integer>();
	TreeNode pre = null;

	public int[] findMode(TreeNode root) {
		helper(root);
		int len = list.size();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = list.get(i);
		}
		return arr;

	}

	public void helper(TreeNode root) {
		if (root == null)
			return;
		if (pre != null && pre.val == root.val) {// ��ǰֵ����ǰһ���ڵ��ֵʱ���������ڵ���һ�γ��֡�
			thisNum++;
		} else {
			thisNum = 1;// ��������ڵ��һ�γ���
		}
		if (thisNum == maxNum) {// �������ִ����ͽڵ��ܹ����ֵĴ�����ȵ�ʱ���������ڵ���뵽�����С�
			list.add(root.val);
		} else if (thisNum > maxNum) {// �����������֣����������������ѽڵ���뵽�����С�
			maxNum = thisNum;
			list.clear();
			list.add(root.val);
		}
		pre = root;
		helper(root.left);
		helper(root.right);
	}

}
