package com.sample.server;

import com.sample.grpc.proto.HelloReply;
import com.sample.grpc.proto.HelloRequest;
import com.sample.grpc.proto.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends SimpleGrpc.SimpleImplBase { //Simple is the service name in proto
    @Override
    public void greeting(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply helloReply =  HelloReply.newBuilder().setMessage("Welcome "+ request.getName()).build();

        responseObserver.onNext(helloReply);
        responseObserver.onCompleted();
    }
}
