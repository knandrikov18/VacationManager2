package com.example.vacationmanager2;
import com.example.vacationmanager2.dao.UserRepository;
import com.example.vacationmanager2.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class VacationManagerApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public static void main(String[] args) {
        SpringApplication.run(VacationManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Inserting Player 2: {}", userRepository.save(new User("Kaloqn", "Kaloqn123",
                "Kaloqn", "Andrikov", "CEO", "team1")));
    }
}