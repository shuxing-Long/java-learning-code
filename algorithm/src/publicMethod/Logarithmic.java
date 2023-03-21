package publicMethod;

import java.util.Random;

//对数器的公共类
public class Logarithmic {
	
	//自动生成数组
	//maxSize:数组长度
	//maxValue:生成的数值的最大值
	public static int[] listAutomaticallyGenerated(int maxSize,int maxValue) {
		int[] arr =new int[new Random((maxSize+1)).nextInt()];
		for(int i=0;i<arr.length;i++) {
			arr[i] = new Random((maxValue+1)).nextInt();
			
		}
		return arr;
	}
	
	
	
}
