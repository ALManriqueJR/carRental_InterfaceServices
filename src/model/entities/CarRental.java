package model.entities;

import java.util.Date;

public class CarRental {
	private Date start, finish;
	
	//Compositions
	private Vehicle car;
	private Invoice receipt;
	
	public CarRental(Date start, Date finish, Vehicle car) {
		this.start = start;
		this.finish = finish;
		this.car = car;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Vehicle getCar() {
		return car;
	}

	public void setCar(Vehicle car) {
		this.car = car;
	}

	public Invoice getReceipt() {
		return receipt;
	}

	public void setReceipt(Invoice receipt) {
		this.receipt = receipt;
	}
		
}
