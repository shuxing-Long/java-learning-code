package publicMethod;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import publicMethod.Student.student;

//外部类不可以说明静态
public class Student {
	
	//数值
	public static class student{
		
		private String strName;
		private long nums;
		private char charNums;
		
		public student(String str, long nums,char charNums) {
			this.strName = str;
			this.nums = nums;
			this.charNums = charNums;
		}
		//获取字符串类型的数值
		public String getStrName() { 
			return strName;
		}
		// 获取int类型的数值
		public long getNums() { 
			return nums;
		}
		// 获取char类型的数值
		public long getcharNums() { 
			return charNums;
		}
		
		
		//修改字符串类型的数值
		public void setStrName(String str) { 
			this.strName = str;
		}
		//修改int类型的数值
		public void setNums(long nums) { 
			this.nums = nums;
		}
		//修改char类型的数值
		public void setcharNums(char charNums) { 
			this.charNums = charNums;
		}
	}
	

	//编写比较器，实现Comparator接口
	//int类型的比较
	public static class IdintcendingComparator implements Comparator<student>{
		//返回负数的时候，第一个参数排在前面
		//返回正数的时候，第二个参数排在前面
		//返回0的时候，谁在前面都无所谓
		//重写比较方法
		@Override
		public int compare(student o1, student o2){
			//后减前是降序
			//前减后是升序
			return (int)(o1.nums - o2.nums);
		}
	}
		//编写比较器，实现Comparator接口
		//char类型的比较
		public static class IdcharcendingComparator implements Comparator<student>{
			//返回负数的时候，第一个参数排在前面
			//返回正数的时候，第二个参数排在前面
			//返回0的时候，谁在前面都无所谓
			//重写比较方法
			@Override
			public int compare(student o1, student o2){
				//后减前是降序
				//前减后是升序
				return (int)(Integer.valueOf(o1.charNums) - Integer.valueOf(o2.charNums));
			}
		}          

}
