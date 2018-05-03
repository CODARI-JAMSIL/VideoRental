package step1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	@Test
	public void °í°´_»ý¼º(){
		//GIVEN
		Customer customer = new Customer("°í°´ÀÌ¸§");
		
		//WHEN
		
		//THEN
		assertThat(customer, is(notNullValue()));
	}

	@Test
	public void ºñµð¿À¸¦ºô¸®Áö¾Ê´Â°í°´_»ý¼º(){
		//GIVEN
		Customer customer = new Customer("°í°´ÀÌ¸§");
		
		//WHEN
		String statement = customer.statement();
		
		//THEN
		assertThat(statement, is("Rental Record for °í°´ÀÌ¸§\n"
				+"Amount owed is 0.0\n"
				+"You earned 0 frequent renter pointers"
				));
		
	}
}
