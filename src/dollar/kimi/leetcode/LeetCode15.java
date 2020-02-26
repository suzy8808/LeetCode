package dollar.kimi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode15 {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		if(nums==null||nums.length<3)return list;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0)break;
			if(i>0&&nums[i]==nums[i-1])continue;
			int R=nums.length-1;
			int L=i+1;
			while(R>L) {
				int sum=nums[i]+nums[R]+nums[L];
				if(sum==0) {
					list.add(Arrays.asList(nums[i],nums[L],nums[R]));
					while(L<R&&nums[L]==nums[L+1])L++;
					while(L<R&&nums[R]==nums[R-1])R--;
					L++;
					R--;
				}else if(sum>0) {
					R--;
				}else {
					L++;
				}
			}
		}
		return list;
    }
}
