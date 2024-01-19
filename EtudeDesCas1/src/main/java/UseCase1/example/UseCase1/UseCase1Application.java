package UseCase1.example.UseCase1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@RefreshScope
@SpringBootApplication
public class UseCase1Application {

	public static void main(String[] args) {
		SpringApplication.run(UseCase1Application.class, args);
	}

}
