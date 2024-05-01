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

    @Override
    public void getNodeInfo(NodeInfoRequest request, StreamObserver<NodeInfoResponse> responseObserver) {

        // extract data from server request
        int nodeId = request.getNodeId();

        logger.info("GET_NODE_INFO request: nodeId=" + nodeId);

        NodeInfoResponse.Builder response = NodeInfoResponse.newBuilder();
        response.setNodeId(nodeId);

        // TODO => retrieve CPU utilization

        try {
            response.setMapSize(storageService.getMapSize());
            response.setIsHealthy(true);
            response.setResponseCode(200);
            response.setResponseMessage("GET_NODE_INFO success");
            logger.info("nodeId=" + nodeId + "|isHealthy=" + true + "|mapSize=" + storageService.getMapSize());
        } catch (Exception e) {
            response.setMapSize(-1);
            response.setIsHealthy(false);
            response.setResponseCode(400);
            response.setResponseMessage("GET_NODE_INFO fail | error=" + e.getMessage());
            logger.warn("Can't fetch map size");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
