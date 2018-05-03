package step1;

class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public double getCharge() {
		return getChargeFor(daysRented);
	}

	private double getChargeFor(int daysRented) {
		double thisAmount = 0;
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (getDaysRented() > 2)
				thisAmount += (daysRented - 2) * 1.5;
			break;
			
		case Movie.NEW_RELEASE:
			thisAmount += daysRented * 3;
			break;
			
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (daysRented > 3)
				thisAmount += (daysRented - 3) * 1.5;
			break;
		}
		return thisAmount;
	}

	int frequentRentersFor() {
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
			return 2;
		return 1;
	}
}