package step1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	@Test
	public void ��_����(){
		//GIVEN
		Customer customer = new Customer("���̸�");
		
		//WHEN
		
		//THEN
		assertThat(customer, is(notNullValue()));
	}

	@Test
	public void �������������ʴ°�_����(){
		//GIVEN
		Customer customer = new Customer("���̸�");
		
		//WHEN
		String statement = customer.statement();
		
		//THEN
		assertThat(statement, is("Rental Record for ���̸�\n"
				+"Amount owed is 0.0\n"
				+"You earned 0 frequent renter pointers"
				));
		
	}

	@Test
	public void regularMovie2�ϴ뿩(){
		//GIVEN
		Customer customer = new Customer("���̸�");
		Movie movie = new Movie("RegularMovie", Movie.REGULAR);
		int daysRented = 2;
		Rental rental = new Rental(movie, daysRented);
		customer.addRental(rental);
		
		//WHEN
		String statement = customer.statement();
		
		//THEN
		assertThat(statement, is("Rental Record for ���̸�\n"
		        + "\t2.0(RegularMovie)\n" 
				+"Amount owed is 2.0\n"
				+"You earned 1 frequent renter pointers"
				));
		
	}

}
