package br.com.storeflow.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StoreflowBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreflowBffApplication.class, args);
	}

}
