package grapesu.example.calculator1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @Autowired
    private Calculator calculator;

    @RequestMapping("/sum")
    String sum(@RequestParam("a") Integer a, @RequestParam("b") Integer b)
    {
        return String.valueOf(calculator.sum(a, b));
    }

    @RequestMapping("/substract")
    String substract(@RequestParam("a") Integer a, @RequestParam("b") Integer b)
    {
        return String.valueOf(calculator.subtract(a, b));
    }
}
