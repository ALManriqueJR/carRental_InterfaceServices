package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter rental data");
		
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		
		System.out.print("Pickup : ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return : ");
		Date finish = sdf.parse(sc.nextLine());
		
		CarRental car = new CarRental(start, finish, new Vehicle(carModel));
		
		/* Code in case custom prices per hour and day need to be changed
		 * System.out.print("Enter price per hour: "); Double pricePerHour =
		 * sc.nextDouble(); System.out.print("Enter price per day: "); Double
		 * pricePerDay = sc.nextDouble();
		 */
		
		RentalService rs = new RentalService(10.0, 130.0, new BrazilTaxService());
		
		rs.processInvoice(car);
		
		System.out.println("INVOICE");
		
		System.out.print("Basic payment: " + String.format("%.2f", car.getReceipt().getBasicPayment()) + "\n");
		System.out.print("Tax: " + String.format("%.2f", car.getReceipt().getTax()) + "\n");
		System.out.print("Total payment: " + String.format("%.2f", car.getReceipt().getTotalPayment()));
		 
		
		sc.close();
	}

}
