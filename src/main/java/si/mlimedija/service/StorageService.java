package si.mlimedija.service;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.mlimedija.proto.*;
import java.util.HashMap;

public class StorageService extends storageGrpc.storageImplBase {

    private static final Logger logger = LoggerFactory.getLogger(StorageService.class.getSimpleName());

    private HashMap<String, String> dataMap = new HashMap<>();

    public int getMapSize() {
        return dataMap.size();
    }

    @Override
    public void putDataNode(PutDataNodeRequest request, StreamObserver<PutDataNodeResponse> responseObserver) {
        int nodeId = request.getNodeId();
        String key = request.getKey();
        String value = request.getValue();

        logger.info("PUT_DATA_NODE request: nodeId=" + nodeId + "|key=" + key + "|value=" + value);

        PutDataNodeResponse.Builder response = PutDataNodeResponse.newBuilder();
        response.setKey(key);

        // put value to cache
        // TODO => make smaller try-catch blocks for each response separately
        try {
            dataMap.put(key, value);
            response.setResponseCode(200);
            response.setResponseMessage("PUT_DATA_NODE success");
        } catch (Exception e) {
            response.setResponseCode(400);
            response.setResponseMessage("PUT_DATA_NODE fail | error=" + e.getMessage());
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }


    @Override
    public void getDataNode(GetDataNodeRequest request, StreamObserver<GetDataNodeResponse> responseObserver) {

        int nodeId = request.getNodeId();
        String key = request.getKey();

        logger.info("GET_DATA_NODE request: nodeId=" + nodeId + "|key=" + key);

        GetDataNodeResponse.Builder response = GetDataNodeResponse.newBuilder();
        response.setKey(key);

        // get value from cache
        // TODO => make smaller try-catch blocks for each response separately
        try {
            response.setValue(dataMap.get(key));
            response.setResponseCode(200);
            response.setResponseMessage("GET_DATA_NODE success");
        } catch (Exception e) {
            response.setValue("");
            response.setResponseCode(400);
            response.setResponseMessage("GET_DATA_NODE fail | error=" + e.getMessage());
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
