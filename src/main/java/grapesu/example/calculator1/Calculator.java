package grapesu.example.calculator1;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class Calculator {
    //@Cacheable("sum")
    public int sum(int a,int b) {
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a+b;
    }
    //@Cacheable("subtract")
    public int subtract(int a,int b) {
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a-b;
    }
}
