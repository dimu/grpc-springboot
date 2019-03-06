package dwx.tech.res.grpc;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import dwx.tech.res.grpc.client.PasswordClient;

@SpringBootApplication
@ComponentScan("dwx.tech.res.grpc.**")
public class Application implements CommandLineRunner{

    public static void main(String[] args) {
//        new SpringApplicationBuilder().web(WebApplicationType.NONE).build(args);
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        new PasswordClient("localhost", 21).greet("123456");
    }

}
