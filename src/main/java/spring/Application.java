package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static ConfigurableApplicationContext springContext;

    public static void main(String[] args) {
        //new javax.swing.JFrame().setVisible(true);
        springContext = SpringApplication.run(Application.class);
        new spring.services.UserSvc().example();
    }

}
