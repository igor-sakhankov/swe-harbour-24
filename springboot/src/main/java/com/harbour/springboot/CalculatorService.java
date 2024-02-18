package com.harbour.springboot;

import io.grpc.examples.CalculatorGrpc;
import io.grpc.examples.CalculatorOuterClass;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class CalculatorService  extends CalculatorGrpc.CalculatorImplBase {
    @Override
    public void calculate(CalculatorOuterClass.CalculatorRequest request, StreamObserver<CalculatorOuterClass.CalculatorResponse> responseObserver) {
        var result = request.getNumber1() + request.getNumber2();
        CalculatorOuterClass.CalculatorResponse response = CalculatorOuterClass.CalculatorResponse.newBuilder().setResult(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
