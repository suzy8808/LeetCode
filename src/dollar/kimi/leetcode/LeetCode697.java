package dollar.kimi.leetcode;

import java.util.*;

public class LeetCode697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> leftMap=new HashMap<>();
        Map<Integer,Integer> rightMap=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(!leftMap.containsKey(nums[i]))leftMap.put(nums[i],i);
            rightMap.put(nums[i],i);
        }
        int maxFeq=Collections.max(map.values());
        int mind=Integer.MAX_VALUE;
        for(int key:map.keySet()){
            if(maxFeq==map.get(key)){
                int d=rightMap.get(key)-leftMap.get(key)+1;
                if(mind>d) mind=d;
            }
        }
        return mind;
    }
}
