package si.mlimedija.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import si.mlimedija.service.NodeInfoService;
import si.mlimedija.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class StorageMain {

    private static final Logger logger = LoggerFactory.getLogger(StorageMain.class.getSimpleName());

    public static void main(String[] args) throws InterruptedException, IOException {
        StorageService storageService = new StorageService();
        NodeInfoService nodeInfoService = new NodeInfoService(storageService);

        Server server = ServerBuilder.forPort(9070).
                addService(storageService).
                addService(nodeInfoService).
                build();

        logger.info("Starting gRPC server");

        server.start();

        String ipAddress = getIPAddress();
        logger.info("Server started at " + ipAddress + ":" + server.getPort());

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
