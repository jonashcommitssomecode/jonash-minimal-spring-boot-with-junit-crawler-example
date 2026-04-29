package jonash.group.packageone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"jonash.group"})
public class SpringBootMainApplicationStarterClass {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainApplicationStarterClass.class, args);
    }

}
