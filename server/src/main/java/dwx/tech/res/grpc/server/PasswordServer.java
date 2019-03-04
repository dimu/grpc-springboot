package dwx.tech.res.grpc.server;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import dwx.res.proto.AddUnlockPasswordRequest;
import dwx.res.proto.AddUnlockPasswordResponse;
import dwx.res.proto.PasswordGrpc.PasswordImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;

@Component
public class PasswordServer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PasswordServer.class);

    private Server server;

    public void start() throws IOException {
      /* The port on which the server should run */
      int port = 50051;
      server = ServerBuilder.forPort(port)
          .addService(new PasswordImpl())
          .build()
          .start();
      LOGGER.info("Server started, listening on " + port);
      Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run() {
          // Use stderr here since the logger may have been reset by its JVM shutdown hook.
          System.err.println("*** shutting down gRPC server since JVM is shutting down");
          PasswordServer.this.stop();
          System.err.println("*** server shut down");
        }
      });
    }

    private void stop() {
      if (server != null) {
        server.shutdown();
      }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    public void blockUntilShutdown() throws InterruptedException {
      if (server != null) {
        server.awaitTermination();
      }
    }

    /**
     * Main launches the server from the command line.
     */
//    public static void main(String[] args) throws IOException, InterruptedException {
//      final PasswordServer server = new PasswordServer();
//      server.start();
//      server.blockUntilShutdown();
//    }
    
    static class PasswordImpl extends PasswordImplBase {

        public void addLockPassword(AddUnlockPasswordRequest request,
                io.grpc.stub.StreamObserver<AddUnlockPasswordResponse> responseObserver) {
            System.out.println(request.getOwnerNum());
            AddUnlockPasswordResponse reply = AddUnlockPasswordResponse.newBuilder().setRetCode("200")
                    .setRetMessage("ok").build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
