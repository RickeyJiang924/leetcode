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
    	int mid = (len1+len2)/2;  //mid������mid��������mid��������λ����mid-1��ʵ���±�
    	
    	if((len1+len2)%2 == 0) {  //��������� ������ ż������
    		return (supportFunction(nums1, nums2, mid)+supportFunction(nums1, nums2, mid+1))/2.0;
    	}
    	else {
    		return supportFunction(nums1, nums2, mid+1);
    	}
    }
    
//    һ��ȡK��Ԫ�س�����nums1��ȡ K/2��(������ȫ��ȡ��)�� nums2��ȡ K - K/2(��nums1.length),
//    �ж�ȡ������������Ԫ���е�ĩλ��С��
//    ���nums1[p1] < nums2[p2]��˵��nums1ȡ���ˣ�nums2ȡ���ˣ���K��Ԫ��Ӧ����nums1�ĺ�벿�ֻ�nums2��ǰ�벿�֣�
//    ���nums1[p1] > nums2[p2], ˵��nums2ȡ���ˣ�nums1ȡ���ˣ���K��Ԫ��Ӧ����nums2�ĺ�벿�ֻ�nums1��ǰ�벿�֣�
    public double supportFunction(int[] nums1, int[] nums2, int mid) {
    	
    	//�߽����
    	//��֤nums2���ȴ���nums1
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
    	
    	//һ�����
    	int len = nums1.length;
    	int p1 = Math.min(mid/2, len);
    	int p2 = mid - p1;
    	
    	if(nums1[p1-1] < nums2[p2-1]) { //nums1ȡ���ˣ���λ����nums1��벿�֣�nums2ǰ�벿��
    		return supportFunction(Arrays.copyOfRange(nums1, p1, nums1.length), Arrays.copyOfRange(nums2, 0, p2), mid-p1);
    	}
    	else { //nums2ȡ���ˣ���λ����nums2��벿�֣�nums1ǰ�벿��
    		return supportFunction(Arrays.copyOfRange(nums1, 0, p1), Arrays.copyOfRange(nums2, p2, nums2.length), mid-p2);
    	}
    }
}
