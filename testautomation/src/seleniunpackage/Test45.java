package seleniunpackage;

import java.util.Scanner;

public class Test45 {

	public static void main(String[] args) {
		//get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a no.");
		int x=sc.nextInt();
		//check even or odd
		if (x%2==0) {
			System.out.println(x + "is even");
		}
		else
		{
System.out.println(x + "is odd ");
		}
		sc.close();
}
	
}
