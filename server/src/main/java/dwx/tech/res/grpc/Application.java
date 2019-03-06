package dwx.tech.res.grpc;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import dwx.tech.res.grpc.server.PasswordServer;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan("dwx.tech.res.grpc.**")
public class Application extends SpringBootServletInitializer implements CommandLineRunner {

    @Resource
    private PasswordServer passwordServer;
    
    public static void main(String[] args) {
//        new SpringApplicationBuilder().web(WebApplicationType.NONE).build(args);
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        passwordServer.start();
        passwordServer.blockUntilShutdown();
    }
    
    @Override
    protected SpringApplicationBuilder configure(
      SpringApplicationBuilder builder) {
        return builder.web(WebApplicationType.NONE).sources(Application.class);
    }

}
