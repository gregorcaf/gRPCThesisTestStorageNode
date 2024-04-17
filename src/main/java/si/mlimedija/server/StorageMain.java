package si.mlimedija.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import si.mlimedija.service.NodeInfoService;
import si.mlimedija.service.StorageService;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class StorageMain {

    public static void main(String[] args) throws InterruptedException, IOException {
        StorageService storageService = new StorageService();
        NodeInfoService nodeInfoService = new NodeInfoService(storageService);

        Server server = ServerBuilder.forPort(9070).
                addService(storageService).
                addService(nodeInfoService).build();

        System.out.println("Starting gRPC server");

        server.start();

        String ipAddress = getIPAddress();
        System.out.println("Server started at " + ipAddress + ":" + server.getPort());

        server.awaitTermination();
    }

    public static String getIPAddress() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            return address.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null; // Handle the error gracefully
        }
    }
}
