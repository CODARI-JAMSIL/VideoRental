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
		Iterator<Rental> iterator = rentals.iterator();
		
		String result = getStatementHeader();
		result += getStatementBody();
		result += getStatementFooter();

		return result;
	}

	public String getStatementHeader() {
		String result = "Rental Record for " + getName() + "\n";
		return result;
	}

	public String getStatementFooter() {
		String result= "";
		result += "Amount owed is " + getTotalCharge() + "\n";
		result += "You earned " + getFrequentRentalPoint() + " frequent renter pointers";
		return result;
	}

	public String getStatementBody() {
		String result= "";
		for (Rental rental : rentals) {
			result += "\t" +  rental.getCharge() + "(" + rental.getMovie().getTitle() + ")" + "\n";
		}
		return result;
	}

	public int getFrequentRentalPoint() {
		int frequentRenterPoints = 0;
		for (Rental rental : rentals) {
			frequentRenterPoints += rental.getFrequentRentalPointFor();
		}
		return frequentRenterPoints;
	}

	public double getTotalCharge() {
		double totalAmount = 0;
		for (Rental rental : rentals) {
			totalAmount += rental.getCharge(); 
		}
		return totalAmount;
	}
}