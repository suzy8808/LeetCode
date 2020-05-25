package dollar.kimi.leetcode;

public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0) {
            int length=nums2.length-1;
            if(length%2==1) {
                return (nums2[length/2]+nums2[length/2+1])*1.0/2;
            }else {
                return nums2[length/2];
            }
        }
        if(nums2.length==0) {
            int length=nums1.length-1;
            if(length%2==1) {
                return (nums1[length/2]+nums1[length/2+1])*1.0/2;
            }else {
                return nums1[length/2];
            }
        }

        int m=nums1.length;
        int n=nums2.length;
        int sum=(m+n+1)/2;
        int m1=0;
        int m2=0;
        int leftMax=0;
        int rightMin=0;
        for(m1=0;m1<=nums1.length;m1++) {
            m2=sum-m1;
            if(m2>n)continue;

            int index1=m1-1;
            int index2=m2-1;

            if(index2<0){
                leftMax=nums1[index1];
            }else if(index1<0) {
                leftMax=nums2[index2];
            }else if(nums1[index1]>nums2[index2]) {
                leftMax=nums1[index1];
            }else {
                leftMax=nums2[index2];
            }

            if(index2+1>=n){
                rightMin=nums1[index1+1];
            }else if(index1+1>=m) {
                rightMin=nums2[index2+1];
            }else if(nums1[index1+1]>nums2[index2+1]) {
                rightMin=nums2[index2+1];
            }else {
                rightMin=nums1[index1+1];
            }
            if(rightMin>=leftMax) {

                if((m+n)%2==0) {
                    return (rightMin+leftMax)*1.0/2;
                }else {
                    return leftMax;
                }
            }
        }
        return 0;
    }
}
