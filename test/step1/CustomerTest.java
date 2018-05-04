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

	private static final String ���̸� = "���̸�";
	
	Customer customer = new Customer(���̸�);

	@Test
	public void ��_����() {
		// GIVEN

		// WHEN

		// THEN
		assertThat(customer, is(notNullValue()));
	}

	@Test
	public void �������������ʴ°�_����() {
		// GIVEN

		// WHEN
		// THEN
		assertThat(customer.statement(),
				is("Rental Record for ���̸�\n" 
						+ "Amount owed is 0.0\n" 
						+ "You earned 0 frequent renter pointers"));

	}

	@Test
	public void regularMovie2�ϴ뿩() {
		// GIVEN
		createRentalFor(REGULAR_MOVIE, Movie.REGULAR, 2);

		// WHEN
		// THEN
		assertThat(customer.statement(), is("Rental Record for ���̸�\n" 
						+ "\t2.0(RegularMovie)\n" + "Amount owed is 2.0\n"
						+ "You earned 1 frequent renter pointers"));
	}

	@Test
	public void regularMovie3�ϴ뿩() {
		// GIVEN
		createRentalFor(REGULAR_MOVIE, Movie.REGULAR, 3);

		// WHEN
		// THEN
		assertThat(customer.statement(), is("Rental Record for ���̸�\n" 
							+ "\t3.5(RegularMovie)\n" 
							+ "Amount owed is 3.5\n"
							+ "You earned 1 frequent renter pointers"));

	}

	@Test
	public void newReleaseMovie1�ϴ뿩() {
		// GIVEN
		createRentalFor(NEW_RELEASE_MOVIE, Movie.NEW_RELEASE, 1);

		// WHEN
		// THEN
		assertThat(customer.statement(), is("Rental Record for ���̸�\n" 	
							+ "\t3.0(NewReleaseMovie)\n" 
							+ "Amount owed is 3.0\n"
							+ "You earned 1 frequent renter pointers"));

	}

	@Test
	public void newReleaseMovie2�ϴ뿩() {
		// GIVEN
		createRentalFor(NEW_RELEASE_MOVIE, Movie.NEW_RELEASE, 2);

		// WHEN
		// THEN
		assertThat(customer.statement(), is("Rental Record for ���̸�\n" 	
							+ "\t6.0(NewReleaseMovie)\n" 
							+ "Amount owed is 6.0\n"
							+ "You earned 2 frequent renter pointers"));

	}
	
	@Test
	public void childrenMovie3�ϴ뿩() {
		// GIVEN
		createRentalFor(CHILDREN_MOVIE, Movie.CHILDRENS, 3);

		// WHEN
		// THEN
		assertThat(customer.statement(), is("Rental Record for ���̸�\n" 
							+ "\t1.5(ChildrenMovie)\n" 
							+ "Amount owed is 1.5\n"
							+ "You earned 1 frequent renter pointers"));

	}

	@Test
	public void childrenMovie4�ϴ뿩() {
		// GIVEN
		createRentalFor(CHILDREN_MOVIE, Movie.CHILDRENS, 4);

		// WHEN
		// THEN
		assertThat(customer.statement(), is("Rental Record for ���̸�\n" 
								+ "\t3.0(ChildrenMovie)\n" 
								+ "Amount owed is 3.0\n"
								+ "You earned 1 frequent renter pointers"));

	}

	private void createRentalFor(String movieTitle, int movieType, int daysRented) {
		Movie movie = createMovie(movieTitle, movieType);
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);
	}

	private Movie createMovie(String movieTitle, int movieType) {
		Movie movie = new Movie(movieTitle, movieType);
		return movie;
	}

	@Test
	public void �������Ǻ������뿩() {

		createRentalFor(CHILDREN_MOVIE, Movie.CHILDRENS, 3);
		createRentalFor(REGULAR_MOVIE, Movie.REGULAR, 3);
		createRentalFor(NEW_RELEASE_MOVIE, Movie.NEW_RELEASE, 3);



		// WHEN
		// THEN
		assertThat(customer.statement(), is("Rental Record for ���̸�\n" 
								+ "\t1.5(ChildrenMovie)\n" 
								+ "\t3.5(RegularMovie)\n" 
								+ "\t9.0(NewReleaseMovie)\n" 
								+ "Amount owed is 14.0\n"
								+ "You earned 4 frequent renter pointers"));

	}

	@Test
	public void otherMovie4�ϴ뿩() {
		// GIVEN
		createRentalFor(OTHER_MOVIE, 4, 4);

		// WHEN
		// THEN
		assertThat(customer.statement(), is("Rental Record for ���̸�\n" 
								+ "\t0.0(OtherMovie)\n" 
								+ "Amount owed is 0.0\n"
								+ "You earned 1 frequent renter pointers"));

	}
}
