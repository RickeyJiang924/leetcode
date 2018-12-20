package leetcode;

import java.util.Arrays;

public class test {

	/**
	 * Q32.有两个序列a,b，大小都为n,序列元素的值任意整数，无序.
	 * 
	 * 要求：通过交换a,b中的元素，使[序列a元素的和]与[序列b元素的和]之间的差最小。 
	 * 例如: 
	 * int[] a = {100,99,98,1,2,3}; 
	 * int[] b = {1, 2, 3, 4,5,40};
	 * 
	 * 求解思路： 
	 * 当前数组a和数组b的和之差为 A = sum(a) - sum(b) a的第i个元素和b的第j个元素交换后，
	 * a和b的和之差为 A' 
	 * =sum(a) - a[i] + b[j] - （sum(b) - b[j] + a[i]) 
	 * = sum(a) - sum(b) - 2 (a[i] -b[j]) 
	 * = A - 2 (a[i] - b[j]) 
	 * 设x = a[i] - b[j], 则交换后差值变为 A’ = A - 2x
	 * 
	 * 假设A > 0, 当x 在 (0,A)之间时，做这样的交换才能使得交换后的a和b的和之差变小，x越接近A/2效果越好,
	 * 如果找不到在(0,A)之间的x，则当前的a和b就是答案。 所以算法大概如下：
	 * 在a和b中寻找使得x在(0,A)之间并且最接近A/2的i和j，交换相应的i和j元素，重新计算A后，
	 * 重复前面的步骤直至找不到(0,A)之间的x为止。
	 */
	public static void main(String[] args) {
		test minSumASumB=new test();
		int[] a = {100,99,98,1,2,3}; 
		int[] b = {1, 2, 3, 4,5,40};
//		int[] a={3,5,10};
//		int[] b={20,25,50};
//		int[] a={3,5,-10};
//		int[] b={20,25,50};
		minSumASumB.swapToMinusDiff(a, b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}

	public void swapToMinusDiff(int[] a,int[] b){
		
		int sumA=sum(a);
		int sumB=sum(b);
		
		if(sumA==sumB)return;
		
		if(sumA<sumB){
			int[] temp=a;
			a=b;
			b=temp;
		}
		int curDiff=1;
		int oldDiff=Integer.MAX_VALUE;
		int pA=-1;
		int pB=-1;
		boolean shift=true;
		int len=a.length;//the length of a and b should be the same
		while(shift&&curDiff>0){
			shift=false;
			curDiff=sum(a)-sum(b);
			for(int i=0;i<len;i++){
				for(int j=0;j<len;j++){
					int temp=a[i]-b[j];
					int newDiff=Math.abs(curDiff-2*temp);
					if(newDiff<curDiff&&newDiff<oldDiff){
						shift=true;
						oldDiff=newDiff;
						pA=i;
						pB=j;
					}
				}
			}
			if(shift){
				int temp=a[pA];
				a[pA]=b[pB];
				b[pB]=temp;
			}
		}
		System.out.println("the min diff is "+oldDiff);
	}
	public int sum(int[] a){
		int sum=0;
		for(int each:a){
			sum+=each;
		}
		return sum;
	}
}

