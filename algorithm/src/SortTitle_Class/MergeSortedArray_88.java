package SortTitle_Class;

import java.util.Arrays;

//给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
//分别表示 nums1 和 nums2 中的元素数目。
//请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
//注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，
//nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。
//nums2 的长度为 n 。
public class MergeSortedArray_88 {
	public static void main(String[] args) {
		int[] nums1= {2,0};
		int m=1;
		int[] nums2= {1};
		int n = 1;
		merge(nums1, m, nums2, n);
		
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if(m==0 && n ==0) {nums1 = null; return;}
		if(m==0) {
			for(int c=0;c<nums1.length;c++) {
				nums1[c]=nums2[c];
			}
			return;
		}
		if(n==0) {return;}
		
		int[] help=new int[n+m];
		int i=0;
		int j=0;
		int k=0;
		while(m>i&&n>j) {
			help[k++]=nums1[i]<=nums2[j]?nums1[i++]:nums2[j++];
		}

		while(m>i) {
			help[i+j]=nums1[i++];
		}
		while(n>j) {
			help[i+j]=nums2[j++];
		}
		for(int b=0;b<help.length;b++) {
			nums1[b]=help[b];
		}
		
		System.out.println(Arrays.toString(nums1));
    }
}
