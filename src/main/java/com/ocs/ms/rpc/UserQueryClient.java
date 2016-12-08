package com.ocs.ms.rpc;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ocs.ms.UserProto.User;
import com.ocs.ms.UserProto.UserId;
import com.ocs.ms.UserQueryServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class UserQueryClient {
	private static final Logger logger = Logger.getLogger(UserQueryClient.class.getName());
	private ManagedChannel channel;
	private UserQueryServiceGrpc.UserQueryServiceBlockingStub blockingStub;

	public UserQueryClient(String host, int port) {
		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
		blockingStub = UserQueryServiceGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws Exception {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public User getUserById(String id) {
		logger.info("Will try to get a Name ...");
		UserId userId = UserId.newBuilder().setId(id).build();
		User user;
		try {
			user = blockingStub.getUserById(userId);
		} catch (StatusRuntimeException e) {
			logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
			return null;
		}
		return user;
	}

	public static void main(String[] args) throws Exception {
		UserQueryClient client = new UserQueryClient("localhost", 10001);
		String id = "adfafa899a8fa9f89as9";
		
		try {
			System.out.println("get mesage: " + client.getUserById(id).getUsername());
		} finally {
			client.shutdown();
		}
	}
}
