package step1;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	};
	
	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	};

	public String statement() {
		String result = "Rental Record for " + getName() + "\n";

		result += getRentalLineReport();

		result += "Amount owed is " + getTotalCharge() + "\n";
		result += "You earned " + getFrequentRenterPoints() + " frequent renter pointers";

		return result;
	}

	private String getRentalLineReport() {
		String result = "";
		for (Rental rental : rentals) {
			result += "\t" +  rental.getCharge() + "(" + rental.getMovie().getTitle() + ")" + "\n";
		}
		return result;
	}

	private int getFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental rental : rentals) {
			frequentRenterPoints += rental.frequentRentersFor();
		}
		return frequentRenterPoints;
	}

	private double getTotalCharge() {
		double totalAmount = 0;
		for (Rental rental : rentals) {
			totalAmount += rental.getCharge();
		}
		return totalAmount;
	}
}