package com.bloodika.grpcclient;

import com.bloodika.grpcserver.proto.InvoiceRequest;
import com.bloodika.grpcserver.proto.InvoiceResponse;
import com.bloodika.grpcserver.proto.InvoiceServiceGrpc;
import io.grpc.Deadline;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class GrpcClientApplication implements CommandLineRunner {

    private final GRPCInvoiceService grpcInvoiceService;

    public GrpcClientApplication(final GRPCInvoiceService grpcInvoiceService) {
        this.grpcInvoiceService = grpcInvoiceService;
    }


    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }

    @Override
    public void run(final String... args) {
        final InvoiceRequest request = InvoiceRequest.newBuilder().setInvoiceId("a").setBankAccount("b").setAmount(200).build();
        System.out.println(grpcInvoiceService.sendRequest(request));
    }
}
