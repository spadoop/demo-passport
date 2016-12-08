package com.ocs.ms.rpc;

import java.util.logging.Logger;

import com.ocs.ms.PassportApplication;
import com.ocs.ms.UserProto.User;
import com.ocs.ms.UserProto.UserId;
import com.ocs.ms.UserQueryServiceGrpc;
import com.ocs.ms.entity.UserName;
import com.ocs.ms.mapper.NameMapper;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class UserQueryServer {
	private static final Logger logger = Logger.getLogger(UserQueryServer.class.getName());

	private int port = 10001;
	private Server server;

	public void start() throws Exception {
		server = ServerBuilder.forPort(port).addService(new UserQueryService()).build().start();
		logger.info("Server started, listening on " + port);
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			@Override
			public void run() {
				System.err.println("*** shutting down gRPC server since JVM is shutting down");
				UserQueryServer.this.stop();
				System.err.println("*** server shut down");
			}
		}));
	}

	private void stop() {
		if (server != null) {
			server.shutdown();
		}
	}

	public void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	private static class UserQueryService extends UserQueryServiceGrpc.UserQueryServiceImplBase {
		private User user = User.newBuilder().build();
		UserName un;
		NameMapper nameMapper = (NameMapper) PassportApplication.ac.getBean(NameMapper.class);

		@Override
		public void getUserById(UserId request, StreamObserver<User> responseObserver) {
			un = nameMapper.getNameById(request.getId());
			user = user.toBuilder().setUsername(un.getUsername()).build();
			responseObserver.onNext(user);
			responseObserver.onCompleted();
		}
	}

	public static void main(String[] args) throws Exception {
		final UserQueryServer server = new UserQueryServer();
		server.start();
		server.blockUntilShutdown();
	}
}