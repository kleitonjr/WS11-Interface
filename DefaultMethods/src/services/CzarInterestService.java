package services; 

public class CzarInterestService implements InterestService {

	private double interestRate;

	public CzarInterestService(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}
}