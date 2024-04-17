package si.mlimedija.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: NodeInfo.proto")
public final class nodeInfoGrpc {

  private nodeInfoGrpc() {}

  public static final String SERVICE_NAME = "nodeInfo";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<si.mlimedija.proto.NodeInfoRequest,
      si.mlimedija.proto.NodeInfoResponse> getGetNodeInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getNodeInfo",
      requestType = si.mlimedija.proto.NodeInfoRequest.class,
      responseType = si.mlimedija.proto.NodeInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<si.mlimedija.proto.NodeInfoRequest,
      si.mlimedija.proto.NodeInfoResponse> getGetNodeInfoMethod() {
    io.grpc.MethodDescriptor<si.mlimedija.proto.NodeInfoRequest, si.mlimedija.proto.NodeInfoResponse> getGetNodeInfoMethod;
    if ((getGetNodeInfoMethod = nodeInfoGrpc.getGetNodeInfoMethod) == null) {
      synchronized (nodeInfoGrpc.class) {
        if ((getGetNodeInfoMethod = nodeInfoGrpc.getGetNodeInfoMethod) == null) {
          nodeInfoGrpc.getGetNodeInfoMethod = getGetNodeInfoMethod = 
              io.grpc.MethodDescriptor.<si.mlimedija.proto.NodeInfoRequest, si.mlimedija.proto.NodeInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "nodeInfo", "getNodeInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.NodeInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.NodeInfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new nodeInfoMethodDescriptorSupplier("getNodeInfo"))
                  .build();
          }
        }
     }
     return getGetNodeInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static nodeInfoStub newStub(io.grpc.Channel channel) {
    return new nodeInfoStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static nodeInfoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new nodeInfoBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static nodeInfoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new nodeInfoFutureStub(channel);
  }

  /**
   */
  public static abstract class nodeInfoImplBase implements io.grpc.BindableService {

    /**
     */
    public void getNodeInfo(si.mlimedija.proto.NodeInfoRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.NodeInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNodeInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetNodeInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                si.mlimedija.proto.NodeInfoRequest,
                si.mlimedija.proto.NodeInfoResponse>(
                  this, METHODID_GET_NODE_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class nodeInfoStub extends io.grpc.stub.AbstractStub<nodeInfoStub> {
    private nodeInfoStub(io.grpc.Channel channel) {
      super(channel);
    }

    private nodeInfoStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected nodeInfoStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new nodeInfoStub(channel, callOptions);
    }

    /**
     */
    public void getNodeInfo(si.mlimedija.proto.NodeInfoRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.NodeInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNodeInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class nodeInfoBlockingStub extends io.grpc.stub.AbstractStub<nodeInfoBlockingStub> {
    private nodeInfoBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private nodeInfoBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected nodeInfoBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new nodeInfoBlockingStub(channel, callOptions);
    }

    /**
     */
    public si.mlimedija.proto.NodeInfoResponse getNodeInfo(si.mlimedija.proto.NodeInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetNodeInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class nodeInfoFutureStub extends io.grpc.stub.AbstractStub<nodeInfoFutureStub> {
    private nodeInfoFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private nodeInfoFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected nodeInfoFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new nodeInfoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<si.mlimedija.proto.NodeInfoResponse> getNodeInfo(
        si.mlimedija.proto.NodeInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNodeInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_NODE_INFO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final nodeInfoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(nodeInfoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_NODE_INFO:
          serviceImpl.getNodeInfo((si.mlimedija.proto.NodeInfoRequest) request,
              (io.grpc.stub.StreamObserver<si.mlimedija.proto.NodeInfoResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class nodeInfoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    nodeInfoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return si.mlimedija.proto.NodeInfo.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("nodeInfo");
    }
  }

  private static final class nodeInfoFileDescriptorSupplier
      extends nodeInfoBaseDescriptorSupplier {
    nodeInfoFileDescriptorSupplier() {}
  }

  private static final class nodeInfoMethodDescriptorSupplier
      extends nodeInfoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    nodeInfoMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (nodeInfoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new nodeInfoFileDescriptorSupplier())
              .addMethod(getGetNodeInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
