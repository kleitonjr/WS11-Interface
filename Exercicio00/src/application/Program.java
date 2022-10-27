package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Car;
import model.entities.CarRent;
import model.services.BrazilTaxService;
import model.services.RentService;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		CarRent cr;

/*		Uma locadora brasileira de carros cobra um valor por hora para loca��es de at� 12 horas.
		Por�m, se a dura��o da loca��o ultrapassar 12 horas, a loca��o ser� cobrada com base em um valor di�rio.
		Al�m do valor da loca��o, � acrescido no pre�o o valor do imposto conforme regras do pa�s que, no caso do Brasil, � 20%
		para valores at� 100.00, ou 15% para valores acima de 100.00. 
		Fazer um programa que l� os dados da loca��o (modelo do carro, instante inicial e final da loca��o), 
		bem como o valor por hora e o valor di�rio de loca��o. 
		O programa deve ent�o gerar a nota de pagamento (contendo valor da loca��o, valor do imposto e valor total do pagamento) e informar os dados na tela.
*/	  

		System.out.println("Entre com os dados do aluguel");
		System.out.print("Modelo do carro: ");
		String car = sc.nextLine();
		System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
		
		cr = new CarRent(start, finish, new Car(car)); 
		
		System.out.print("Pre�o por hora: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Pre�o por dia: ");
		double pricePerDay = sc.nextDouble();
		
		RentService rentalServ = new RentService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalServ.processInvoice(cr);
		
		System.out.println("\nFATURA:");
		System.out.println("Pagamento b�sico: " + String.format("%.2f", cr.getInvoice().getbasicPay()));
		System.out.println("Imposto: " + String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Pagamento total: " + String.format("%.2f", cr.getInvoice().getPagTotal()));
	
		
//		BrazilTaxService tax = new BrazilTaxService();
//		System.out.println(tax.tax(50.0));
		
		sc.close();
		
	}

}
