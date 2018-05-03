package step1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	@Test
	public void ��_����() {
		// GIVEN
		Customer customer = new Customer("���̸�");

		// WHEN

		// THEN
		assertThat(customer, is(notNullValue()));
	}

	@Test
	public void �������������ʴ°�_����() {
		// GIVEN
		Customer customer = new Customer("���̸�");

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement,
				is("Rental Record for ���̸�\n" 
						+ "Amount owed is 0.0\n" 
						+ "You earned 0 frequent renter pointers"));

	}

	@Test
	public void regularMovie2�ϴ뿩() {
		// GIVEN
		Customer customer = new Customer("���̸�");
		Movie movie = new Movie("RegularMovie", Movie.REGULAR);
		int daysRented = 2;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for ���̸�\n" 
						+ "\t2.0(RegularMovie)\n" + "Amount owed is 2.0\n"
						+ "You earned 1 frequent renter pointers"));
	}

	@Test
	public void regularMovie3�ϴ뿩() {
		// GIVEN
		Customer customer = new Customer("���̸�");
		Movie movie = new Movie("RegularMovie", Movie.REGULAR);
		int daysRented = 3;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for ���̸�\n" 
							+ "\t3.5(RegularMovie)\n" 
							+ "Amount owed is 3.5\n"
							+ "You earned 1 frequent renter pointers"));

	}

	@Test
	public void newReleaseMovie1�ϴ뿩() {
		// GIVEN
		Customer customer = new Customer("���̸�");
		Movie movie = new Movie("NewReleaseMovie", Movie.NEW_RELEASE);
		int daysRented = 1;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for ���̸�\n" 	
							+ "\t3.0(NewReleaseMovie)\n" 
							+ "Amount owed is 3.0\n"
							+ "You earned 1 frequent renter pointers"));

	}

	@Test
	public void newReleaseMovie2�ϴ뿩() {
		// GIVEN
		Customer customer = new Customer("���̸�");
		Movie movie = new Movie("NewReleaseMovie", Movie.NEW_RELEASE);
		int daysRented = 2;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for ���̸�\n" 	
							+ "\t6.0(NewReleaseMovie)\n" 
							+ "Amount owed is 6.0\n"
							+ "You earned 2 frequent renter pointers"));

	}
	
	@Test
	public void childrenMovie3�ϴ뿩() {
		// GIVEN
		Customer customer = new Customer("���̸�");
		Movie movie = new Movie("ChildrenMovie", Movie.CHILDRENS);
		int daysRented = 3;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for ���̸�\n" 
							+ "\t1.5(ChildrenMovie)\n" 
							+ "Amount owed is 1.5\n"
							+ "You earned 1 frequent renter pointers"));

	}

	@Test
	public void childrenMovie4�ϴ뿩() {
		// GIVEN
		Customer customer = new Customer("���̸�");
		Movie movie = new Movie("ChildrenMovie", Movie.CHILDRENS);
		int daysRented = 4;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for ���̸�\n" 
								+ "\t3.0(ChildrenMovie)\n" 
								+ "Amount owed is 3.0\n"
								+ "You earned 1 frequent renter pointers"));

	}

	@Test
	public void �������Ǻ������뿩() {
		// GIVEN
		Customer customer = new Customer("���̸�");
		Movie childrenMovie = new Movie("ChildrenMovie", Movie.CHILDRENS);
		Movie regularMovie = new Movie("RegularMovie", Movie.REGULAR);
		Movie newReleaseMovie = new Movie("NewReleaseMovie", Movie.NEW_RELEASE);
		
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
		assertThat(statement, is("Rental Record for ���̸�\n" 
								+ "\t1.5(ChildrenMovie)\n" 
								+ "\t3.5(RegularMovie)\n" 
								+ "\t9.0(NewReleaseMovie)\n" 
								+ "Amount owed is 14.0\n"
								+ "You earned 4 frequent renter pointers"));

	}

	@Test
	public void otherMovie4�ϴ뿩() {
		// GIVEN
		Customer customer = new Customer("���̸�");
		Movie movie = new Movie("OtherMovie", 4);
		int daysRented = 4;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);

		// WHEN
		String statement = customer.statement();

		// THEN
		assertThat(statement, is("Rental Record for ���̸�\n" 
								+ "\t0.0(OtherMovie)\n" 
								+ "Amount owed is 0.0\n"
								+ "You earned 1 frequent renter pointers"));

	}
}
