package step1;

public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(String title) {
		super(title, Movie.NEW_RELEASE);
	}

	@Override
	double getChargeFor(int daysRented) {
		double thisAmount = 0;
		thisAmount += daysRented * 3;
		return thisAmount;
	}

	@Override
	public int frequentRentersFor(int daysRented) {
		if (daysRented > 1)
			return 2;
		return 1;
	}

}
