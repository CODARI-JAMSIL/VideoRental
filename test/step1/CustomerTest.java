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

}
