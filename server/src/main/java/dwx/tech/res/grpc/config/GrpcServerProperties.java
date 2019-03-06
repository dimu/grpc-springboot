package dwx.tech.res.grpc.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * grpc server配置类
 * @author dwx
 *
 */
@ConfigurationProperties(prefix = "grpc")
public class GrpcServerProperties {
    
    private Map<String, Map<String, Integer>> server;

    public Map<String, Map<String, Integer>> getServer() {
        return server;
    }

    public void setServer(Map<String, Map<String, Integer>> server) {
        this.server = server;
    }
    
}
