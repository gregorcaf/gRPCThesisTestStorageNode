package si.mlimedija.service;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.mlimedija.proto.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NodeInfoService extends nodeInfoGrpc.nodeInfoImplBase {

    private static final Logger logger = LoggerFactory.getLogger(NodeInfoService.class.getSimpleName());

    private StorageService storageService;

    public NodeInfoService(StorageService storageService) {
        this.storageService = storageService;
    }

    // TODO => retrieve CPU utilization % from the system and return it in response
    @Override
    public void getNodeInfo(NodeInfoRequest request, StreamObserver<NodeInfoResponse> responseObserver) {

        // extract server request
        int nodeId = request.getNodeId();
        String nodeIpAddress = request.getNodeIpAddress();

        logger.info("GET_NODE_INFO request: nodeId=" + nodeId + "|nodeIpAddress=" + nodeIpAddress);

        NodeInfoResponse.Builder response = NodeInfoResponse.newBuilder();
        response.setNodeId(nodeId);

        // TODO => make smaller try-catch blocks for each response separately
        try {
            response.setNodeIpAddress(getIPAddress());
            response.setIsHealthy(true);
            response.setMapSize(storageService.getMapSize());
            response.setResponseCode(200);
            response.setResponseMessage("GET_NODE_INFO success");
        } catch (Exception e) {
            response.setNodeIpAddress(nodeIpAddress);
            response.setIsHealthy(false);
            response.setMapSize(-1);
            response.setResponseCode(400);
            response.setResponseMessage("GET_NODE_INFO success");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
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
