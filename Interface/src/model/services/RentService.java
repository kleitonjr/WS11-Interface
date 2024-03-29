package model.services;

import java.time.Duration;

import model.entities.CarRent;
import model.entities.Invoice;

public class RentService{
	
	private Double pricePerDay;
	private Double pricePerHour;
	
	private TaxService taxService;

	public RentService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRent carRent) {
		
		double min = Duration.between(carRent.getStart(), carRent.getFinish()).toMinutes();
		double hours = min/60.0;
		
		double basicPay;
		if(hours <= 12.0) {
			basicPay = pricePerHour * Math.ceil(hours);
		}
		else {
			basicPay = pricePerDay * Math.ceil(hours/24.0);
		}
		
		double tax = taxService.tax(basicPay);
		carRent.setInvoice(new Invoice(basicPay, tax));
	}

}
