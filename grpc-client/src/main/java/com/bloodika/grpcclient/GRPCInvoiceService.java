package com.bloodika.grpcclient;

import com.bloodika.grpcserver.proto.InvoiceRequest;
import com.bloodika.grpcserver.proto.InvoiceServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class GRPCInvoiceService {

    private final InvoiceServiceGrpc.InvoiceServiceBlockingV2Stub invoiceStub;

    public GRPCInvoiceService() {

        final ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .enableRetry()
                .keepAliveTime(30, TimeUnit.SECONDS)
                .build();
        this.invoiceStub = InvoiceServiceGrpc.newBlockingV2Stub(managedChannel);


    }

    public boolean sendRequest(final InvoiceRequest request) {
        return invoiceStub.sendInvoiceData(request).getStatus();
    }


}
