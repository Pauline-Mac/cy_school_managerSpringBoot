package app;

import app.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CySchoolManager extends SpringBootServletInitializer {

    private static final Logger log = LoggerFactory.getLogger(CySchoolManager.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CySchoolManager.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CySchoolManager.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository repository) {
        return (args) -> {
            log.info("Application Initiated");
            log.info("--------------------------------------------");
        };
    }
}