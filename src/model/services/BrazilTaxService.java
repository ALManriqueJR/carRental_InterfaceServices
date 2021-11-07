package model.services;

public class BrazilTaxService {
	public double tax(double amount) {
		if (amount <= 100.0) {
			return amount + (amount * 0.2);
		} else {
			return amount + (amount * 0.15);
		}
	}
}
