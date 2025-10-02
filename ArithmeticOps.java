import java.util.Scanner;

public class ArithmeticOps 
{
	public static void main(String[] args) 
	{
	    
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter first number");
		double num=sc.nextDouble();
		
		System.out.println("Enter second number");
		double num1=sc.nextDouble();
		
		double Addition=num+num1;
		double subtraction=num-num1;
		double multiplication=num*num1;
		double division=num/num1;
		
		
		System.out.println(Addition);
		System.out.println(subtraction);
        System.out.println(multiplication);
        System.out.println(division);
	}
}