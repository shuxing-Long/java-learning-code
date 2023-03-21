package SortTitle_Class;


//69. x 的平方根 
public class SolutionSqrt_69 {
	public static void main(String[] args) 
	{
		int x=15135355;
		System.out.print(mySqrt(x)+ "\n");
		System.out.print(Math.pow(x,0.5));
	}
	

	//	给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//	由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//	注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
	public static int mySqrt(int x) {
		//使用牛顿迭代法
		if(x == 0 || x== 1) return x;
		double xn=x/2;
		double xn1 = 0;
		while(x>0) {
			xn=(xn+(x/xn))/2;
			if(xn == xn1) {
				break;
			}else {
				xn1 = xn;
			}
		}
		return (int)xn;
    }
	
	
	
}
