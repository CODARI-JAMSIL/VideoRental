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
}
