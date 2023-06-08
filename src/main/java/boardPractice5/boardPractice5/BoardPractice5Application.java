package boardPractice5.boardPractice5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BoardPractice5Application {

	public static void main(String[] args) {
		SpringApplication.run(BoardPractice5Application.class, args);
	}

}
