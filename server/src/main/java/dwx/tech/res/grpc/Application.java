package dwx.tech.res.grpc;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import dwx.tech.res.grpc.server.PasswordServer;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("dwx.tech.res.grpc.**")
public class Application implements CommandLineRunner {

    @Resource
    private PasswordServer passwordServer;
    
    public static void main(String[] args) {
//        new SpringApplicationBuilder().web(WebApplicationType.NONE).build(args);
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        passwordServer.start("lock");
        passwordServer.blockUntilShutdown();
    }
}
