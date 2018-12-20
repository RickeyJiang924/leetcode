package leetcode;

import java.util.Arrays;

public class test {

	/**
	 * Q32.����������a,b����С��Ϊn,����Ԫ�ص�ֵ��������������.
	 * 
	 * Ҫ��ͨ������a,b�е�Ԫ�أ�ʹ[����aԪ�صĺ�]��[����bԪ�صĺ�]֮��Ĳ���С�� 
	 * ����: 
	 * int[] a = {100,99,98,1,2,3}; 
	 * int[] b = {1, 2, 3, 4,5,40};
	 * 
	 * ���˼·�� 
	 * ��ǰ����a������b�ĺ�֮��Ϊ A = sum(a) - sum(b) a�ĵ�i��Ԫ�غ�b�ĵ�j��Ԫ�ؽ�����
	 * a��b�ĺ�֮��Ϊ A' 
	 * =sum(a) - a[i] + b[j] - ��sum(b) - b[j] + a[i]) 
	 * = sum(a) - sum(b) - 2 (a[i] -b[j]) 
	 * = A - 2 (a[i] - b[j]) 
	 * ��x = a[i] - b[j], �򽻻����ֵ��Ϊ A�� = A - 2x
	 * 
	 * ����A > 0, ��x �� (0,A)֮��ʱ���������Ľ�������ʹ�ý������a��b�ĺ�֮���С��xԽ�ӽ�A/2Ч��Խ��,
	 * ����Ҳ�����(0,A)֮���x����ǰ��a��b���Ǵ𰸡� �����㷨������£�
	 * ��a��b��Ѱ��ʹ��x��(0,A)֮�䲢����ӽ�A/2��i��j��������Ӧ��i��jԪ�أ����¼���A��
	 * �ظ�ǰ��Ĳ���ֱ���Ҳ���(0,A)֮���xΪֹ��
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

