package leetcode;

import java.util.Arrays;

public class problem4 {
	public static void main(String[] args) {
		int[] nums1 = {1, 3};
		int[] nums2 = {2};
		System.out.println(new Solution4().findMedianSortedArrays(nums1, nums2));
	}
}

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
    	int mid = (len1+len2)/2;  //mid代表找mid个数，第mid数就是中位数，mid-1是实际下标
    	
    	if((len1+len2)%2 == 0) {  //分情况讨论 奇数个 偶数个数
    		return (supportFunction(nums1, nums2, mid)+supportFunction(nums1, nums2, mid+1))/2.0;
    	}
    	else {
    		return supportFunction(nums1, nums2, mid+1);
    	}
    }
    
//    一次取K个元素出来，nums1中取 K/2个(不够就全都取出)， nums2中取 K - K/2(或nums1.length),
//    判断取出的两个数组元素中的末位大小；
//    如果nums1[p1] < nums2[p2]，说明nums1取少了，nums2取多了，第K个元素应该在nums1的后半部分或nums2的前半部分；
//    如果nums1[p1] > nums2[p2], 说明nums2取少了，nums1取多了，第K个元素应该在nums2的后半部分或nums1的前半部分；
    public double supportFunction(int[] nums1, int[] nums2, int mid) {
    	
    	//边界情况
    	//保证nums2长度大于nums1
    	if(nums1.length > nums2.length) {
    		return supportFunction(nums2, nums1, mid);
    	}
    	
    	if(nums1.length == 0) {
    		return nums2[mid-1];
    	}
    	
    	if(nums2.length == 0) {
    		return nums1[mid-1];
    	}
    	
    	if(mid == 1) {
    		return Math.min(nums1[0], nums2[0]);
    	}
    	
    	//一般情况
    	int len = nums1.length;
    	int p1 = Math.min(mid/2, len);
    	int p2 = mid - p1;
    	
    	if(nums1[p1-1] < nums2[p2-1]) { //nums1取少了，中位数在nums1后半部分，nums2前半部分
    		return supportFunction(Arrays.copyOfRange(nums1, p1, nums1.length), Arrays.copyOfRange(nums2, 0, p2), mid-p1);
    	}
    	else { //nums2取少了，中位数在nums2后半部分，nums1前半部分
    		return supportFunction(Arrays.copyOfRange(nums1, 0, p1), Arrays.copyOfRange(nums2, p2, nums2.length), mid-p2);
    	}
    }
}
