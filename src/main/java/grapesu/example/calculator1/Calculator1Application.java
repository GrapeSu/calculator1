package grapesu.example.calculator1;

import com.hazelcast.client.config.ClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class Calculator1Application {
	private static final String CONSTANT = "constant";
	public static void main(String[] args) {
		SpringApplication.run(Calculator1Application.class, args);
	}
	@Bean
	public ClientConfig hazelcastClientConfig() {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.getNetworkConfig().addAddress("49.234.184.13");
		return clientConfig;
	}
}
