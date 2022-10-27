package model.entities;

public class Invoice {
	
	private Double basicPay;
	private Double tax;

	
	public Invoice(Double basicPay, Double tax) {
		this.basicPay = basicPay;
		this.tax = tax;
	}
	public Double getbasicPay() {
		return basicPay;
	}
	public void setbasicPay(Double basicPay) {
		this.basicPay = basicPay;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public double getPagTotal() {
		return getbasicPay() + getTax();
	}
	
}
