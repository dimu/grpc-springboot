package dwx.tech.res.grpc.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * grpc server配置类,可以针对不同服务配置不同的端口
 * @author dwx
 *
 */
@Component
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
