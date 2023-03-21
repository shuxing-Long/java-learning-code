//导包
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入整数:");
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();

        System.out.println(number1 + number2);
    }
}
