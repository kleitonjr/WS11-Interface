package model.services;

public interface OnlinePaymentService {

	double payFee(double amount);
	
	double interest(double amount, int months);

}
