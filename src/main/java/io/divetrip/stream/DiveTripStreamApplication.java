package io.divetrip.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"io.divetrip.stream",
		"io.divetrip.library"
})
public class DiveTripStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiveTripStreamApplication.class, args);
	}

}
