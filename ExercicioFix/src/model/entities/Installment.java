package model.entities;

import java.util.Date;

public class Installment {
	
	private Date dtaVenc;
	private Double amount;
	
	public Installment(Date dtaVenc, Double amount) {
		this.dtaVenc = dtaVenc;
		this.amount = amount;
	}

	public Date getDtaVenc() {
		return dtaVenc;
	}

	public void setDtaVenc(Date dtaVenc) {
		this.dtaVenc = dtaVenc;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
