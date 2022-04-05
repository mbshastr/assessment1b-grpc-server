package com.persistent.grpc_assessment1b;

import com.persistent.grpc_assessment1b.User.APIResponse;
import com.persistent.grpc_assessment1b.User.Empty;
import com.persistent.grpc_assessment1b.User.LoginRequest;
import com.persistent.grpc_assessment1b.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{
	
	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.login(request, responseObserver);
		System.out.println("Inside login");
		String username = request.getUsername();
		String password = request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		
		if(username.equals(password)) {
			response.setResponseCode(0).setResponsemessage("SUCCESS");
		} else {
			response.setResponseCode(100).setResponsemessage("INVALID PASSWORD");
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
	
	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.logout(request, responseObserver);
	}
}
