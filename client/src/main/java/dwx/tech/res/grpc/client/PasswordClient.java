package dwx.tech.res.grpc.client;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.stereotype.Component;

import dwx.res.proto.AddUnlockPasswordRequest;
import dwx.res.proto.AddUnlockPasswordResponse;
import dwx.res.proto.PasswordGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;

public class PasswordClient {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PasswordClient.class);

    private final ManagedChannel channel;
    private final PasswordGrpc.PasswordBlockingStub blockingStub;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public PasswordClient(String host, int port) {
      this(ManagedChannelBuilder.forAddress(host, port)
          // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
          // needing certificates.
          .usePlaintext()
          .build());
    }

    /** Construct client for accessing HelloWorld server using the existing channel. */
    PasswordClient(ManagedChannel channel) {
      this.channel = channel;
      blockingStub = PasswordGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
      channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /** Say hello to server. */
    public void greet(String ownnum) {
        LOGGER.info("Will try to greet " + ownnum + " ...");
        AddUnlockPasswordRequest request = AddUnlockPasswordRequest.newBuilder().setOwnerNum(ownnum).build();
        AddUnlockPasswordResponse response;
      try {
        response = blockingStub.addLockPassword(request);
      } catch (StatusRuntimeException e) {
          LOGGER.error("RPC failed: {}", e.getStatus());
        return;
      }
      LOGGER.info("add password result: " + response.getRetMessage());
    }
}
