package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Contract cont;
		
/*		Uma empresa deseja automatizar o processamento de seus contratos. O processamento de
		um contrato consiste em gerar as parcelas a serem pagas para aquele contrato, com base no
		número de meses desejado.
		A empresa utiliza um serviço de pagamento online para realizar o pagamento das parcelas.
		Os serviços de pagamento online tipicamente cobram um juro mensal, bem como uma taxa
		por pagamento. Por enquanto, o serviço contratado pela empresa é o do Paypal, que aplica
		juros simples de 1% a cada parcela, mais uma taxa de pagamento de 2%.
		Fazer um programa para ler os dados de um contrato (número do contrato, data do contrato,
		e valor total do contrato). Em seguida, o programa deve ler o número de meses para
		parcelamento do contrato, e daí gerar os registros de parcelas a serem pagas (data e valor),
		sendo a primeira parcela a ser paga um mês após a data do contrato, a segunda parcela dois
		meses após o contrato e assim por diante. Mostrar os dados das parcelas na tela.
*/		
				
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Número: ");
		int num = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate data = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		double valTotal = sc.nextDouble();
		
		cont = new Contract(num, data, valTotal);
		
		System.out.print("Entre com a quantidade de parcelas: ");
		int i = sc.nextInt();
		
		ContractService cs = new ContractService(new PaypalService());
		
		cs.processContract(cont, i);
		
		System.out.println("Parcelas:");
		for(Installment inst: cont.getInstallments()) {
			System.out.println(inst);
		}
						
		sc.close();
		
	}

}
