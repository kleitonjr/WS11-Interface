package application;

import java.security.InvalidParameterException;
import java.util.Locale;
import java.util.Scanner;

import services.BrazilInterestService;
import services.InterestService;
import services.UsaInterestService;

public class Program {
	public static void main(String[] args) {
			
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("Amount: ");
			double amount = sc.nextDouble();
			System.out.print("Months: ");
			int months = sc.nextInt();
			
			InterestService is = new BrazilInterestService(2.0);
			UsaInterestService us = new UsaInterestService(1.0); 
			double payment = is.payment(amount, months);
			double payment2 = us.payment(amount, months);
			
			System.out.println("Payment after " + months + " months:");
			System.out.println("Brazil: " + String.format("%.2f", payment));
			System.out.println("USA: " + String.format("%.2f", payment2));
			
		}catch(InvalidParameterException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();

	}

}
