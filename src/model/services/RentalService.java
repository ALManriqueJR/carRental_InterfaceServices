package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	private Double pricePerHour;
	private Double pricePerDay;
	
	//Composition
	private BrazilTaxService taxService;

	public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService tax) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = tax;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public BrazilTaxService getTax() {
		return taxService;
	}

	public void setTax(BrazilTaxService tax) {
		this.taxService = tax;
	}
	
	public void processInvoice(CarRental carRented) {
		long start = carRented.getStart().getTime(); //getTime, pega esse o valor me milisegundos da Data
		long finish = carRented.getFinish().getTime();
		
		double hours  = (double) (finish-start)/1120;
		
		double basicPayment = 0;
		
		if (hours <= 12.0) {
			basicPayment = Math.ceil(hours) * getPricePerHour();
		}else {
			basicPayment = Math.ceil(hours) * getPricePerDay();
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRented.setReceipt(new Invoice(basicPayment, tax));
		
	}
	
}
