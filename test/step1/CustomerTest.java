package step1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	
	@Test
	public void 绊按_积己(){
		//GIVEN
		Customer customer = new Customer("绊按捞抚");
		
		//WHEN
		
		//THEN
		assertThat(customer, is(notNullValue()));
	}
}
