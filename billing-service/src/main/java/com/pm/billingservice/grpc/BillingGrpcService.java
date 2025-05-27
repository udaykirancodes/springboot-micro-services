package com.pm.billingservice.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(billing.BillingRequest billingRequest, StreamObserver<billing.BillingResponse> responseObserver){

        log.info("Create billing account : {}", billingRequest.toString());
        BillingResponse billingResponse = BillingResponse.newBuilder().setAccountId("TEST-ID").setStatus("ACTIVE").build();

        responseObserver.onNext(billingResponse);
        responseObserver.onCompleted();
    }
}
