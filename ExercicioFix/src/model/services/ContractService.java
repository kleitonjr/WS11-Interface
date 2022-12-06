package model.services; 

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService ops;
	
	public ContractService(OnlinePaymentService ops) {
		this.ops = ops;
	}

	public void processContract(Contract cont, Integer months) {
		
		double basicQuota = cont.getValTotal()/ months;
		
		for(int i = 1; i<= months; i++) {
			LocalDate dtaVenc = cont.getData().plusMonths(i);	
		
			double interest = ops.interest(basicQuota, i);
			double fee = ops.payFee(basicQuota + interest);
			double quota = basicQuota + fee + interest;
			
			cont.getInstallments().add(new Installment(dtaVenc, quota));
		
		}
			
	}

}
