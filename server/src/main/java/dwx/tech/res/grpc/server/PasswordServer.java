package dwx.tech.res.grpc.server;

import java.io.IOException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import dwx.res.proto.AddUnlockPasswordRequest;
import dwx.res.proto.AddUnlockPasswordResponse;
import dwx.res.proto.PasswordGrpc.PasswordImplBase;
import dwx.tech.res.grpc.config.GrpcServerProperties;
import dwx.tech.res.grpc.entity.Project;
import dwx.tech.res.grpc.repository.ProjectRepository;
import io.grpc.Server;
import io.grpc.ServerBuilder;

@Component
public class PasswordServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PasswordServer.class);

    private Server server;
    
    @Resource
    private ProjectRepository projectRepository;

    @Resource
    private GrpcServerProperties grpcServerProperties;

    public void start(String serverName) throws IOException {
        /* The port on which the server should run */
        Integer port = grpcServerProperties.getServer().get(serverName).get("port");
        server = ServerBuilder.forPort(port).addService(new PasswordImpl()).build().start();
        LOGGER.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown
                // hook.
                LOGGER.error("*** shutting down gRPC server since JVM is shutting down");
                PasswordServer.this.stop();
                LOGGER.error("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon
     * threads.
     */
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

   class PasswordImpl extends PasswordImplBase {
        public void addLockPassword(AddUnlockPasswordRequest request,
                io.grpc.stub.StreamObserver<AddUnlockPasswordResponse> responseObserver) {
            LOGGER.info("获取到的值为{}", request.getOwnerNum());
            Project project  = new Project();
            project.setColor("bule");
            project.setJson(true);
            projectRepository.save(project);
            AddUnlockPasswordResponse reply = AddUnlockPasswordResponse.newBuilder().setRetCode("200")
                    .setRetMessage("ok").build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
