import java.util.Scanner;

public class FunctionsSwap {

	public static void main(String[] args) 
	{
		swap();
	}

	 public static void swap() 
	 {
	 	int num1,num2;
	 	Scanner sc = new Scanner(System.in);
	 	System.out.println("Enter the 2 number");
	 	num1=sc.nextInt();
	 	num2=sc.nextInt();
	 	
	 	num1=num1+num2;
	 	num2=num1-num2;
	 	num1=num1-num2;
	 	
	 	System.out.println("the Swapped numbers are:"+ num1 + " and " + num2);
	 	sc.close();
	 }

}
 
