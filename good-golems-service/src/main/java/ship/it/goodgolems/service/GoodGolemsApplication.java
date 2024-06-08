package ship.it.goodgolems.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ship.it.goodgolems"})
public class GoodGolemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodGolemsApplication.class, args);
    }

}
