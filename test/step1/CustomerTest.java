package step1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	@Test
	public void 고객_생성(){
		//GIVEN
		Customer customer = new Customer("고객이름");
		
		//WHEN
		
		//THEN
		assertThat(customer, is(notNullValue()));
	}

	@Test
	public void 비디오를빌리지않는고객_생성(){
		//GIVEN
		Customer customer = new Customer("고객이름");
		
		//WHEN
		String statement = customer.statement();
		
		//THEN
		assertThat(statement, is("Rental Record for 고객이름\n"
				+"Amount owed is 0.0\n"
				+"You earned 0 frequent renter pointers"
				));
		
	}

	@Test
	public void regularMovie2일대여(){
		//GIVEN
		Customer customer = new Customer("고객이름");
		Movie movie = new Movie("RegularMovie", Movie.REGULAR);
		int daysRented = 2;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);
		
		//WHEN
		String statement = customer.statement();
		
		//THEN
		assertThat(statement, is("Rental Record for 고객이름\n"
		        + "\t2.0(RegularMovie)\n" 
				+"Amount owed is 2.0\n"
				+"You earned 1 frequent renter pointers"
				));
	}

	@Test
	public void regularMovie3일대여(){
		//GIVEN
		Customer customer = new Customer("고객이름");
		Movie movie = new Movie("RegularMovie", Movie.REGULAR);
		int daysRented = 3;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);
		
		//WHEN
		String statement = customer.statement();
		
		//THEN
		assertThat(statement, is("Rental Record for 고객이름\n"
		        + "\t3.5(RegularMovie)\n" 
				+"Amount owed is 3.5\n"
				+"You earned 1 frequent renter pointers"
				));
		
	}
	
	@Test
	public void newReleaseMovie1일대여(){
		//GIVEN
		Customer customer = new Customer("고객이름");
		Movie movie = new Movie("NewReleaseMovie", Movie.NEW_RELEASE);
		int daysRented = 1;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);
		
		//WHEN
		String statement = customer.statement();
		
		//THEN
		assertThat(statement, is("Rental Record for 고객이름\n"
		        + "\t3.0(NewReleaseMovie)\n" 
				+"Amount owed is 3.0\n"
				+"You earned 1 frequent renter pointers"
				));
		
	}

	@Test
	public void childrenMovie3일대여(){
		//GIVEN
		Customer customer = new Customer("고객이름");
		Movie movie = new Movie("ChildrenMovie", Movie.CHILDRENS);
		int daysRented = 3;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);
		
		//WHEN
		String statement = customer.statement();
		
		//THEN
		assertThat(statement, is("Rental Record for 고객이름\n"
		        + "\t1.5(ChildrenMovie)\n" 
				+"Amount owed is 1.5\n"
				+"You earned 1 frequent renter pointers"
				));
		
	}
}
