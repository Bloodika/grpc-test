package com.bloodika.grpcserver;

import com.bloodika.grpcserver.proto.InvoiceRequest;
import com.bloodika.grpcserver.proto.InvoiceResponse;
import com.bloodika.grpcserver.proto.InvoiceServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.grpc.server.service.GrpcService;


@Slf4j
@GrpcService
public class GRPCInvoiceService extends InvoiceServiceGrpc.InvoiceServiceImplBase {

    @Override
    public void sendInvoiceData(final InvoiceRequest request, final StreamObserver<InvoiceResponse> responseObserver) {
        log.info("received request: " + request);
        final InvoiceResponse invoiceResponse = InvoiceResponse.newBuilder().setStatus(true).build();
        responseObserver.onNext(invoiceResponse);
        responseObserver.onCompleted();
    }
}
