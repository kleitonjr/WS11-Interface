package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
	private LocalDate dtaVenc;
	private Double amount;
	
	public Installment(LocalDate dtaVenc, Double amount) {
		this.dtaVenc = dtaVenc;
		this.amount = amount;
	}

	public LocalDate getDtaVenc() {
		return dtaVenc;
	}
	public void setDtaVenc(LocalDate dtaVenc) {
		this.dtaVenc = dtaVenc;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return getDtaVenc().format(fmt) + " - " + String.format("%.2f", getAmount());
		
	}
	
}
