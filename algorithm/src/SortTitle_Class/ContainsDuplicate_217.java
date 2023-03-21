package SortTitle_Class;



//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，
//返回 true ；如果数组中每个元素互不相同，返回 false 。 
public class ContainsDuplicate_217 {
	
	public static void main(String[] args) 
	{
		int[] nums= {1,2,1,3,4};
		
		
		containsDuplicate(nums);
	}
	public static boolean pd =false;
	
	public static boolean containsDuplicate(int[] nums) {
//		sort(nums,0,nums.length-1);
		
		int a=nums[0];
		int b = nums[0];
		for (int i=0;i<=nums.length-1;i++) {
			a= a ^ nums[i];
			if(i!=0 && b==a) {
				return true;
			}
			b=a;
		}
		return false;
    }
	
	public static void sort(int[] nums, int L, int R) 
	{
		if(L < R) {
			swop(nums,L+(int)(Math.random() * (R - L + 1)),R);

			int[] a=partition(nums,L,R);
			//进行排序
			sort(nums,L,a[0]-1); // 右边 区
			sort(nums,a[1]+1,R); // 左边 区
		}
		
		
	}
	
	
	private static int[] partition(int[] nums, int l, int r) {
		int less = l - 1; // <区右边界
		int more = r; // >区左边界
		while(l < more) {
			if(nums[l] < nums[r]) {
				swop(nums,++less,l++);
			}else if(nums[l] > nums[r]) {
				swop(nums,--more,l);
			}else {
				l++;
				pd=true;
			}
		}
		swop(nums,more,r);
		return new int[] {less+1 , more};
	}

	public static void swop(int[] nums, int i, int j) {
		int a=nums[i];
		nums[i]=nums[j];
		nums[j]=a;
	}
}
