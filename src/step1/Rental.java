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
		return movie.getChargeFor(this, daysRented);
	}

	public int getFrequentRentalPointFor() {
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
			return 2;
		} else {
			return 1;
		} 
	}
}