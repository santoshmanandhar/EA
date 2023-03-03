package calc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;


public class  CalcTest {
    private Calculator calculator;

    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    public void testInitialization() {
        assertThat(calculator.getValue(),closeTo(0.0, 0.0001));
    }

    @Test
    public void testAddZero() {
        calculator.add(0.0);
        assertThat(calculator.getValue(),closeTo(0.0, 0.0001));
    }

    @Test
    public void testAddPositive() {
        calculator.add(23.255);
        assertThat(calculator.getValue(),closeTo(23.255, 0.0001));
    }
    @Test
    public void testAddNegative() {
        calculator.add(-23.255);
        assertThat(calculator.getValue(),closeTo(-23.255, 0.0001));
    }
    @Test
    public void testMultipleAddPositive() {
        calculator.add(23.255);
        calculator.add(10.255);
        assertThat(calculator.getValue(),closeTo(33.510, 0.0001));
    }
    @Test
    public void testMultipleAddNegative() {
        calculator.add(-23.255);
        calculator.add(-10.255);
        assertThat(calculator.getValue(),closeTo(-33.510, 0.0001));
    }
    @Test
    public void testMultipleAddNegativeAndPositive() {
        calculator.add(-23.255);
        calculator.add(10.250);
        assertThat(calculator.getValue(),closeTo(-13.005, 0.0001));
    }


}
