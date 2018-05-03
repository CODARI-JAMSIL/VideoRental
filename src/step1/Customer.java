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
		int frequentRenterPoints = 0;
		Iterator<Rental> iterator = rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";

		while ( iterator.hasNext() ) {
			Rental each = (Rental) iterator.next();
			// determine amounts for each line

			// show figures
			result += "\t" +  each.getCharge() + "(" + each.getMovie().getTitle() + ")" + "\n";

		}


		for (Rental rental : rentals) {
			frequentRenterPoints++;
			if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
				frequentRenterPoints++;
		}
		
		result += "Amount owed is " + getTotalCharge() + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter pointers";

		return result;
	}

	private double getTotalCharge() {
		double totalAmount = 0;
		for (Rental rental : rentals) {
			totalAmount += rental.getCharge();
		}
		return totalAmount;
	}
}