package grapesu.example.calculator1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTest {
    @Autowired
    private Calculator calculator ;
    @Test
    public void testSum() {
        assertEquals(5, calculator.sum(2, 3));
    }
}
