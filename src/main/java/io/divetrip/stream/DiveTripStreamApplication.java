package io.divetrip.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "io.divetrip.stream", "io.divetrip.library" })
@EnableJpaRepositories(basePackages = { "io.divetrip.library.domain.repository" })
@EntityScan(basePackages = { "io.divetrip.library.domain.entity" })
public class DiveTripStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiveTripStreamApplication.class, args);
	}

}
