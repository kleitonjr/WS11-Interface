package application;

import java.security.InvalidParameterException;
import java.util.Locale;
import java.util.Scanner;

import services.BrazilInterestService;
import services.CzarInterestService;
import services.InterestService;
import services.UsaInterestService;

public class Program {
	public static void main(String[] args) {
			
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("Quantidade: ");
			double amount = sc.nextDouble();
			System.out.print("Meses: ");
			int months = sc.nextInt();
			
			InterestService is = new BrazilInterestService(2.0);
			UsaInterestService us = new UsaInterestService(1.0);
			CzarInterestService cz = new CzarInterestService(5.0); 
			
			double payment = is.payment(amount, months);
			double payment2 = us.payment(amount, months);
			double payment3 = cz.payment(amount, months);
			
			System.out.println("\nPagamneto depois de " + months + " meses:");
			System.out.println("Brasil: " + String.format("%.2f", payment));
			System.out.println("USA: " + String.format("%.2f", payment2));
			System.out.println("CZAR: " + String.format("%.2f", payment3));
			
		}catch(InvalidParameterException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();

	}

}
