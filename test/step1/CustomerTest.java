package step1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	
	private static final String OTHER_MOVIE = "OtherMovie";

	private static final String CHILDREN_MOVIE = "ChildrenMovie";

	private static final String NEW_RELEASE_MOVIE = "NewReleaseMovie";

	private static final String REGULAR_MOVIE = "RegularMovie";

	private static final String �����̸� = "�����̸�";
	
	Customer customer = new Customer(�����̸�);

	@Test
	public void ����_����() {
		// GIVEN

		// WHEN

		// THEN
		assertThat(customer, is(notNullValue()));
	}

	@Test
	public void �������������ʴ°���_����() {
		// GIVEN

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement,
				is("Rental Record for �����̸�\n" 
						+ "Amount owed is 0.0\n" 
						+ "You earned 0 frequent renter pointers"));

	}

	@Test
	public void regularMovie2�ϴ뿩() {
		// GIVEN
		Movie movie = new Movie(REGULAR_MOVIE, Movie.REGULAR);
		int daysRented = 2;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for �����̸�\n" 
						+ "\t2.0(RegularMovie)\n" + "Amount owed is 2.0\n"
						+ "You earned 1 frequent renter pointers"));
	}

	@Test
	public void regularMovie3�ϴ뿩() {
		// GIVEN
		Movie movie = new Movie(REGULAR_MOVIE, Movie.REGULAR);
		int daysRented = 3;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for �����̸�\n" 
							+ "\t3.5(RegularMovie)\n" 
							+ "Amount owed is 3.5\n"
							+ "You earned 1 frequent renter pointers"));

	}

	@Test
	public void newReleaseMovie1�ϴ뿩() {
		// GIVEN
		Movie movie = new Movie(NEW_RELEASE_MOVIE, Movie.NEW_RELEASE);
		int daysRented = 1;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for �����̸�\n" 	
							+ "\t3.0(NewReleaseMovie)\n" 
							+ "Amount owed is 3.0\n"
							+ "You earned 1 frequent renter pointers"));

	}

	@Test
	public void newReleaseMovie2�ϴ뿩() {
		// GIVEN
		Movie movie = new Movie(NEW_RELEASE_MOVIE, Movie.NEW_RELEASE);
		int daysRented = 2;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for �����̸�\n" 	
							+ "\t6.0(NewReleaseMovie)\n" 
							+ "Amount owed is 6.0\n"
							+ "You earned 2 frequent renter pointers"));

	}
	
	@Test
	public void childrenMovie3�ϴ뿩() {
		// GIVEN
		Movie movie = new Movie(CHILDREN_MOVIE, Movie.CHILDRENS);
		int daysRented = 3;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for �����̸�\n" 
							+ "\t1.5(ChildrenMovie)\n" 
							+ "Amount owed is 1.5\n"
							+ "You earned 1 frequent renter pointers"));

	}

	@Test
	public void childrenMovie4�ϴ뿩() {
		// GIVEN
		Movie movie = new Movie(CHILDREN_MOVIE, Movie.CHILDRENS);
		int daysRented = 4;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for �����̸�\n" 
								+ "\t3.0(ChildrenMovie)\n" 
								+ "Amount owed is 3.0\n"
								+ "You earned 1 frequent renter pointers"));

	}

	@Test
	public void �������Ǻ������뿩() {
		// GIVEN
		Movie childrenMovie = new Movie(CHILDREN_MOVIE, Movie.CHILDRENS);
		Movie regularMovie = new Movie(REGULAR_MOVIE, Movie.REGULAR);
		Movie newReleaseMovie = new Movie(NEW_RELEASE_MOVIE, Movie.NEW_RELEASE);
		
		int childrenMoviedaysRented = 3;
		int regularMoviedaysRented = 3;
		int newReleaseMoviedaysRented = 3;

		Rental childrenMovierental = new Rental(childrenMovie, childrenMoviedaysRented);
		Rental regularMovierental = new Rental(regularMovie, regularMoviedaysRented);
		Rental newReleaseMovierental = new Rental(newReleaseMovie, newReleaseMoviedaysRented);

		customer.addRental(childrenMovierental);
		customer.addRental(regularMovierental);
		customer.addRental(newReleaseMovierental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for �����̸�\n" 
								+ "\t1.5(ChildrenMovie)\n" 
								+ "\t3.5(RegularMovie)\n" 
								+ "\t9.0(NewReleaseMovie)\n" 
								+ "Amount owed is 14.0\n"
								+ "You earned 4 frequent renter pointers"));

	}

	@Test
	public void otherMovie4�ϴ뿩() {
		// GIVEN
		Movie movie = new Movie(OTHER_MOVIE, 4);
		int daysRented = 4;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for �����̸�\n" 
								+ "\t0.0(OtherMovie)\n" 
								+ "Amount owed is 0.0\n"
								+ "You earned 1 frequent renter pointers"));

	}
}
