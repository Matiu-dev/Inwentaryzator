package pl.io2.inwentaryzator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.io2.inwentaryzator.product.ProductRepository;
import pl.io2.inwentaryzator.user.WorkerRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {WorkerRepository.class, ProductRepository.class})
public class InwentaryzatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(InwentaryzatorApplication.class, args);
	}
}
