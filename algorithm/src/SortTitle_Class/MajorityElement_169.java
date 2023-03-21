package SortTitle_Class;

public class MajorityElement_169 {
	public static void main(String[] args) {
		int[] nums= {6,6,6,7,7};
		
		int a=majorityElement(nums);
		
		System.out.print(a);
	}
	
	
	
//	给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 
//	大于 ⌊ n/2 ⌋ 的元素。
//	你可以假设数组是非空的，并且给定的数组总是存在多数元素。
	public static int majorityElement(int[] nums) {
		//消除法
//		return eliminate(nums);
		// 快排3.0的方法
		 return quickSort(nums, 0,nums.length-1);
    }
	
	public static int eliminate(int[] nums) {
		//消除法 原理:因为最多的数是整个数组的n/2，所以随着数的消除，剩下的就是最多的数
		int m=0,n=0;
		for(int i=0; i < nums.length;i++) {
			if(n==0) {
				m=nums[i];
				n++;
			}else if(m != nums[i]) {
				n--;
			}else {
				n++;
			}
		}
		return m;
	}
	
	//快排3.0
	public static int quickSort(int[] arr, int L,int R) {
		
		if(L < R) {
			swap(arr,L+(int)(Math.random() * (R - L + 1)),R);
			int[] a=partition(arr,L,R);
			quickSort(arr,L,a[0]-1); // < 区
			quickSort(arr,a[1]+1,R); // > 区
			
		}
		return arr[arr.length/2];
	}

	private static int[] partition(int[] arr, int l, int r) {
		int less = l - 1; // <区右边界
		int more = r; // >区左边界
		while(l < more) {
			if(arr[l] < arr[r]) {
				swap(arr,++less,l++);
			}else if(arr[l] > arr[r]) {
				swap(arr,--more,l);
			}else {
				l++;
			}
		}
		swap(arr,more,r);
		
		return new int[] {less+1 , more};
	}

	private static void swap(int[] arr, int i, int j) {
//		arr[i] = arr[i] ^ arr[r];
//		arr[r] = arr[i] ^ arr[r];
//		arr[i] = arr[i] ^ arr[r];
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
