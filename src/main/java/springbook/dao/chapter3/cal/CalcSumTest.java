package springbook.dao.chapter3.cal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
public class CalcSumTest {
	Calculator calculator;
	String numFilepath;
	
	@Before
	public void setUP() {
		this.calculator = new Calculator();
		this.numFilepath = getClass().getResource("numbers.txt").getPath();
	}
	
	@Test
	public void sumOfNumbers() throws IOException {
		int sum = calculator.calcSum(this.numFilepath);
		System.out.println(sum);
			assertThat(sum , is(10));
	}
	@Test
	public void multiplyOfNumbers() throws IOException {
		System.out.println(calculator.calclultiply(this.numFilepath));
		assertThat(calculator.calclultiply(this.numFilepath) , is(24));
	}
}
