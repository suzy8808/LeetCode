package dollar.kimi.leetcode;

import dollar.kimi.algorithm.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode105 {
    int pi=0;
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)map.put(inorder[i],i);
        return doBuildTree(preorder,inorder,0,inorder.length-1);
    }

    public TreeNode doBuildTree(int[] preorder, int[] inorder,int start,int end) {
        if(start>end||pi>=preorder.length)return null;
        TreeNode tree=new TreeNode(preorder[pi]);
        int i=map.get(preorder[pi]);
        pi++;

        tree.left=doBuildTree(preorder,inorder,start,i-1);
        tree.right=doBuildTree(preorder,inorder,i+1,end);
        return tree;
    }

}
